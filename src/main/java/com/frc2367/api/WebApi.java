package com.frc2367.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.frc2367.data.events.Events;
import com.frc2367.data.ranks.Ranks;
import com.frc2367.data.scores.Scores;
import com.frc2367.data.teams.EventTeams;
import com.frc2367.data.teams.TeamInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class WebApi
{
	private String apiKey;
	private String competition;

	public WebApi(String competition)
	{
		Scanner scan = null;
		try
		{
			scan = new Scanner(new File("apiKey.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("error reading key");
		}
		apiKey = scan.nextLine();
		System.out.println(apiKey);
		this.competition = competition;
	}

	public Events getEvents()// gets all the events
	{
		String json = this.makeRequest("https://frc-api.firstinspires.org/v2.0/2016/events", "events", true);
		return new Gson().fromJson(json, Events.class);

	}

	public Events getEvents(int teamNumber)// gets all the events
	{
		String json = this.makeRequest("https://frc-api.firstinspires.org/v2.0/2016/events?teamNumber=" + teamNumber, "events-" + teamNumber, true);
		return new Gson().fromJson(json, Events.class);

	}

	public EventTeams getTeams()// gets all the teams at the event
	{
		String json = this.makeRequest("http://thebluealliance.com/api/v2/event/2016" + competition + "/teams", competition + "-teams", false);

		Type fooType = new TypeToken<ArrayList<TeamInfo>>()
		{
		}.getType();
		ArrayList<TeamInfo> array = new Gson().fromJson(json, fooType);
		EventTeams teams = new EventTeams();
		teams.setTeams(array);
		return teams;
	}

	public Scores getMatchDetails(String event, int teamNumber, String level)// gets info about match of team
	{
		String json = this.makeRequest("https://frc-api.firstinspires.org/v2.0/2016/scores/" + event + "/" + level + "?teamNumber=" + teamNumber, competition + "-" + teamNumber + "-" + level, true);
		return new Gson().fromJson(json, Scores.class);
	}

	public Ranks getRanks(String event)// gets rankings of events
	{
		String json = this.makeRequest("https://frc-api.firstinspires.org/v2.0/2016/rankings/" + event, event + "-ranks", true);
		return new Gson().fromJson(json, Ranks.class);
	}

	public void updateData()
	{
		this.getEvents();
	}

	public String makeRequest(String request, String fileName, boolean auth)
	{
		File f = new File("Cache/" + fileName + ".txt");
		Client client = ClientBuilder.newClient();
		Response response = null;
		String body = null;
		if (!f.exists() && !f.isDirectory())
		{
			System.out.println("No files, grabing new response");
			if (auth)
				response = client.target(request)
				.request(MediaType.TEXT_PLAIN_TYPE)
				.header("Authorization", apiKey).get();
			else
				response = client.target(request)
				.request(MediaType.TEXT_PLAIN_TYPE)
				.header("X-TBA-App-Id", "frc2367:team-analysis:v0.1").get();

		}
		else
		{
			try
			{
				Scanner scan = new Scanner(new File("Cache/" + fileName + "-mod.txt"));
				String modDate = scan.nextLine();
				scan.close();
				modDate.replaceAll("[^A-Za-z0-9()\\[\\]]", "");
				if (auth)
					response = client.target(request)
					.request(MediaType.TEXT_PLAIN_TYPE)
					.header("Authorization", apiKey)
					.header("If-Modified-Since", modDate).get();
				else
					response = client.target(request)
					.request(MediaType.TEXT_PLAIN_TYPE)
					.header("X-TBA-App-Id", "frc2367:team-analysis:v0.1")
					.header("If-Modified-Since", modDate).get();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		body = response.readEntity(String.class);
		if (response.getStatus() == 200)// successful
		{
			System.out.println("Got new data");
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
				System.out.println("Error writing to file");
			}
		}
		else if (response.getStatus() == 304)// no new data
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
}
