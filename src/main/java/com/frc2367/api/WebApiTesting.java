package com.frc2367.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.frc2367.data.events.Event;
import com.frc2367.data.events.EventRequest;
import com.frc2367.data.scores.Alliance;
import com.frc2367.data.scores.EventMatchRequest;
import com.frc2367.data.scores.GeneralScore;
import com.frc2367.data.scores.ScoreDetailRequest;
import com.frc2367.data.teams.TeamInfo;
import com.frc2367.data.teams.TeamRequest;
import com.google.gson.Gson;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class WebApiTesting
{
	private String apiKey;

	private boolean forceNoUpdate;
	private PrintWriter logFile;
	private int debugLevel = 2; // 0 none, 1 logFile, 2 log and print

	public WebApiTesting(boolean forceNoUpdate)
	{
		try
		{
			logFile = new PrintWriter("log.txt");
		}
		catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		Scanner scan = null;
		try
		{
			scan = new Scanner(new File("apiKey.txt"));
		}
		catch (FileNotFoundException e)
		{
			debug("error reading key");
		}
		apiKey = scan.nextLine();
		this.forceNoUpdate = forceNoUpdate;
		getTeams();
		getMatches();
	}

	public ArrayList<FullTeam> updateData()
	{
		ArrayList<TeamInfo> allTeams = getTeams();
		ArrayList<GeneralScore> allScores = getMatches();
		ArrayList<FullTeam> fullTeams = new ArrayList<FullTeam>();
		for (int i = 0; i < allTeams.size(); i++)
		{
			FullTeam team = new FullTeam();
			int teamNumber = allTeams.get(i).getTeamNumber();
			team.setInfo(allTeams.get(i));
			for (GeneralScore score : allScores)
			{
				String allianceColor = score.getSimpleScore().getTeamAlliance(teamNumber);
				if (allianceColor != null)
				{
					debug("found team " + teamNumber + " in match " + score.getSimpleScore().getNumber());
					Alliance ally = score.getDetailScore().getAlliance(allianceColor);
					if (ally != null)
					{
						debug("added match for team " + teamNumber);
						team.addMatch(ally);
					}

				}
			}
			fullTeams.add(team);
		}
		return fullTeams;
	}

	public ArrayList<TeamInfo> getTeams()// gets all the teams at the main event
	{
		ArrayList<TeamInfo> allTeams = new ArrayList<TeamInfo>();
		String json = this.makeRequest("https://frc-api.firstinspires.org/v2.0/2016/teams?page=1", "teams1", true);
		TeamRequest teams = new Gson().fromJson(json, TeamRequest.class);
		int numPages = teams.getPageTotal();
		allTeams.addAll(teams.getTeams());
		for (int i = 2; i <= numPages; i++)
		{
			json = this.makeRequest("https://frc-api.firstinspires.org/v2.0/2016/teams?page=1", "teams" + i, true);
			allTeams.addAll(new Gson().fromJson(json, TeamRequest.class).getTeams());
		}
		debug("done getting teams");
		return allTeams;
	}

	public ArrayList<GeneralScore> getMatches()// gets info about match of team
	{
		String json = this.makeRequest("https://frc-api.firstinspires.org/v2.0/2016/events", "events", true);
		EventRequest events = new Gson().fromJson(json, EventRequest.class);
		ArrayList<GeneralScore> allScores = new ArrayList<GeneralScore>();
		for (Event e : events.getEvents())
		{
			String level = "qual";
			String json2 = this.makeRequest("https://frc-api.firstinspires.org/v2.0/2016/scores/" + e.getCode() + "/" + level, e.getCode() + "-" + level + "-details", true);
			ScoreDetailRequest score = new Gson().fromJson(json2, ScoreDetailRequest.class);
			json2 = this.makeRequest("https://frc-api.firstinspires.org/v2.0/2016/matches/" + e.getCode() + "?tournamentLevel=" + level, e.getCode() + "-" + level + "-matches", true);
			EventMatchRequest eventMatch = new Gson().fromJson(json2, EventMatchRequest.class);

			try
			{
				// if(event)
				for (int i = 0; i < score.getMatchScores().size() && i < eventMatch.getMatches().size(); i++)
				{
					allScores.add(new GeneralScore(score.getMatchScores().get(i), eventMatch.getMatches().get(i)));
				}
			}
			catch (NullPointerException exp)
			{
				System.out.println("Error getting " + e.getCode() + " scores");
			}

			level = "playoff";
			json2 = this.makeRequest("https://frc-api.firstinspires.org/v2.0/2016/scores/" + e.getCode() + "/" + level, e.getCode() + "-" + level + "-details", true);
			ScoreDetailRequest scorePlay = new Gson().fromJson(json2, ScoreDetailRequest.class);
			json2 = this.makeRequest("https://frc-api.firstinspires.org/v2.0/2016/matches/" + e.getCode() + "?tournamentLevel=" + level, e.getCode() + "-" + level + "-matches", true);
			EventMatchRequest eventMatchPlay = new Gson().fromJson(json2, EventMatchRequest.class);

			try
			{
				for (int i = 0; i < score.getMatchScores().size() && i < eventMatchPlay.getMatches().size(); i++)
				{
					allScores.add(new GeneralScore(scorePlay.getMatchScores().get(i), eventMatchPlay.getMatches().get(i)));
				}
			}
			catch (NullPointerException exp)
			{
				System.out.println("Error getting " + e.getCode() + " scores");
			}

		}
		debug("done getting matches");
		return allScores;
	}

	public String makeRequest(String request, String fileName, boolean auth)// handles all the logic for requests
	{
		File f = new File("Cache/" + fileName + ".txt");
		Client client = ClientBuilder.newClient();
		Response response = null;
		String body = null;
		if (!forceNoUpdate && (!f.exists() && !f.isDirectory()))
		{
			System.out.println("No files, grabing new response");
			if (auth)
				response = client.target(request).request(MediaType.TEXT_PLAIN_TYPE).header("Authorization", apiKey).get();
			else
				response = client.target(request).request(MediaType.TEXT_PLAIN_TYPE).header("X-TBA-App-Id", "frc2367:team-analysis:v0.1").get();

		}
		else if (!forceNoUpdate)
		{
			try
			{
				Scanner scan = new Scanner(new File("Cache/" + fileName + "-mod.txt"));
				String modDate = scan.nextLine();
				scan.close();
				modDate.replaceAll("[^A-Za-z0-9()\\[\\]]", "");
				if (auth)
					response = client.target(request).request(MediaType.TEXT_PLAIN_TYPE).header("Authorization", apiKey).header("If-Modified-Since", modDate).get();
				else
					response = client.target(request).request(MediaType.TEXT_PLAIN_TYPE).header("X-TBA-App-Id", "frc2367:team-analysis:v0.1").header("If-Modified-Since", modDate).get();
				debug(modDate + " " + response.getHeaderString("Last-Modified"));
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		if (!forceNoUpdate && response.getStatus() == 200)// successful
		{
			body = response.readEntity(String.class);
			debug("Got new data");
			String lastMod = response.getHeaderString("Last-Modified");
			try
			{
				PrintWriter outBody = new PrintWriter("Cache/" + fileName + ".txt");
				outBody.println(body);
				outBody.close();
				PrintWriter outMod = new PrintWriter("Cache/" + fileName + "-mod.txt");
				outMod.println(lastMod);
				outMod.close();
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
				debug("Error writing to file");
			}
		}
		else if (forceNoUpdate || response.getStatus() == 304)// no new data
		{
			System.out.println("No new data, using old data");
			try
			{
				body = new String(Files.readAllBytes(Paths.get("Cache/" + fileName + ".txt")));
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return body;
	}

	public void debug(String msg)
	{
		Calendar cal = Calendar.getInstance();
		if (debugLevel == 1)
			logFile.println(msg);
		else if (debugLevel == 2)
		{
			logFile.println(msg);
			System.out.println(msg);
		}

	}
}
