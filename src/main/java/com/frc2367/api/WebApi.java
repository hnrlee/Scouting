package com.frc2367.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.frc2367.data.ScoutedTeam;
import com.frc2367.data.events.Event;
import com.frc2367.data.events.Events;
import com.frc2367.data.ranks.Ranks;
import com.frc2367.data.schedule.EventSchedule;
import com.frc2367.data.schedule.Team;
import com.frc2367.data.scores.MatchScore;
import com.frc2367.data.scores.Scores;
import com.frc2367.data.teams.EventTeams;
import com.frc2367.data.teams.SearchableTeam;
import com.frc2367.data.teams.TeamInfo;
import com.frc2367.gui.AutoCompleteJComboBox;
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

	private EventTeams eventTeams;
	private boolean forceNoUpdate;
	private ArrayList<ScoutedTeam> scoutedTeams;
	private PrintWriter logFile;
	private int debugLevel = 2; //0 none, 1 logFile, 2 log and print

	public WebApi(String competition, boolean forceNoUpdate, ArrayList<ScoutedTeam> scoutedTeams)
	{
		try {
			logFile = new PrintWriter("log.txt");
		} catch (FileNotFoundException e1) {
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
		this.competition = competition;
		this.forceNoUpdate = forceNoUpdate;
		this.scoutedTeams = scoutedTeams;
	}

	public ScoutedTeam findScoutedTeam(int num)
	{
		for (ScoutedTeam team : this.scoutedTeams)
		{
			if (team.getTeamNum() == num)
				return team;
		}
		return null;
	}

	public void updateData()
	{
		eventTeams = this.getTeams();
		for (TeamInfo team : eventTeams.getTeams())
		{
			Events teamEvents = this.getEvents(team.getTeamNumber());
			for (Event event : teamEvents.getEvents())
			{
				EventSchedule eventSchedule = this.getSchedule(event.getCode(), team.getTeamNumber());
				Scores scoresQual = this.getMatchDetails(event.getCode(), team.getTeamNumber(), "qual");
				Scores scoresPlayoff = this.getMatchDetails(event.getCode(), team.getTeamNumber(), "playoff");
				MatchScore score;
				int scheduleIndex = 0;
				for (int i = 0; i < scoresQual.getMatchScores().size(); i++)
				{
					scheduleIndex = i;
					score = scoresQual.getMatchScores().get(i);
					if (score.getMatchNumber() == eventSchedule.getSchedule().get(scheduleIndex).getMatchNumber())
					{
						if (eventSchedule.getSchedule().get(scheduleIndex).getDescription().contains(score.getMatchLevel()))
						{
							for (Team scheduleTeam : eventSchedule.getSchedule().get(scheduleIndex).getTeams())
							{
								if (scheduleTeam.getNumber() == team.getTeamNumber())
								{
									if (scheduleTeam.getStation().toLowerCase().contains("blue"))
									{
										ScoutedTeam scTeam = null;
										if ((scTeam = findScoutedTeam(team.getTeamNumber())) != null)
										{
											scTeam.getAllMatches().add(score.getAlliances().get(0));
										}
										else
										{
											this.scoutedTeams.add(new ScoutedTeam(team.getNickname(), team.getTeamNumber()));
											this.scoutedTeams.get(this.scoutedTeams.size() - 1).getAllMatches().add(score.getAlliances().get(0));
										}
									}
									else if (scheduleTeam.getStation().toLowerCase().contains("red"))
									{
										ScoutedTeam scTeam = null;
										if ((scTeam = findScoutedTeam(team.getTeamNumber())) != null)
										{
											scTeam.getAllMatches().add(score.getAlliances().get(0));
										}
										else
										{
											this.scoutedTeams.add(new ScoutedTeam(team.getNickname(), team.getTeamNumber()));
											this.scoutedTeams.get(this.scoutedTeams.size() - 1).getAllMatches().add(score.getAlliances().get(1));
										}
									}
								}
							}
						}
					}
				}
				for (int i = 0; i < scoresPlayoff.getMatchScores().size(); i++)
				{
					scheduleIndex = i;
					score = scoresPlayoff.getMatchScores().get(i);
					if (score.getMatchNumber() == eventSchedule.getSchedule().get(scheduleIndex).getMatchNumber())
					{
						if (eventSchedule.getSchedule().get(scheduleIndex).getDescription().contains(score.getMatchLevel()))
						{
							for (Team scheduleTeam : eventSchedule.getSchedule().get(scheduleIndex).getTeams())
							{
								if (scheduleTeam.getNumber() == team.getTeamNumber())
								{
									if (scheduleTeam.getStation().toLowerCase().contains("blue"))
									{
										ScoutedTeam scTeam = null;
										if ((scTeam = findScoutedTeam(team.getTeamNumber())) != null)
										{
											scTeam.getAllMatches().add(score.getAlliances().get(0));
										}
										else
										{
											this.scoutedTeams.add(new ScoutedTeam(team.getNickname(), team.getTeamNumber()));
											this.scoutedTeams.get(this.scoutedTeams.size() - 1).getAllMatches().add(score.getAlliances().get(0));
										}
									}
									else if (scheduleTeam.getStation().toLowerCase().contains("red"))
									{
										ScoutedTeam scTeam = null;
										if ((scTeam = findScoutedTeam(team.getTeamNumber())) != null)
										{
											scTeam.getAllMatches().add(score.getAlliances().get(0));
										}
										else
										{
											this.scoutedTeams.add(new ScoutedTeam(team.getNickname(), team.getTeamNumber()));
											this.scoutedTeams.get(this.scoutedTeams.size() - 1).getAllMatches().add(score.getAlliances().get(1));
										}
									}
								}
							}
						}
					}
				}
			}
			ScoutedTeam scTeam = null;
			if ((scTeam = findScoutedTeam(team.getTeamNumber())) == null)
			{
				this.scoutedTeams.add(new ScoutedTeam(team.getNickname(), team.getTeamNumber()));
			}
		}
		SearchableTeam searchable = new SearchableTeam(eventTeams.getTeams());
		AutoCompleteJComboBox<TeamInfo> combo = new AutoCompleteJComboBox<TeamInfo>(searchable);
		JFrame frame = new JFrame();
		frame.add(combo);
		frame.pack();
		frame.setVisible(true);
		System.out.println("Done updating");
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

	public EventTeams getTeams()// gets all the teams at the main event
	{
		String json = this.makeRequest("http://thebluealliance.com/api/v2/event/2016" + competition + "/teams", competition + "-teams", false);

		Type fooType = new TypeToken<ArrayList<TeamInfo>>(){}.getType();
		ArrayList<TeamInfo> array = new Gson().fromJson(json, fooType);
		EventTeams teams = new EventTeams();
		teams.setTeams(array);
		return teams;
	}

	public Scores getMatchDetails(String event, int teamNumber, String level)// gets info about match of team
	{
		event = event.toLowerCase();
		String json = this.makeRequest("https://frc-api.firstinspires.org/v2.0/2016/scores/" + event + "/" + level + "?teamNumber=" + teamNumber, event + "-" + teamNumber + "-" + level, true);
		return new Gson().fromJson(json, Scores.class);
	}

	public Ranks getRanks(String event)// gets rankings of events
	{
		event = event.toLowerCase();
		String json = this.makeRequest("https://frc-api.firstinspires.org/v2.0/2016/rankings/" + event, event + "-ranks", true);
		return new Gson().fromJson(json, Ranks.class);
	}

	public EventSchedule getSchedule(String event, int teamNumber)
	{
		event = event.toLowerCase();
		String json = this.makeRequest("https://frc-api.firstinspires.org/v2.0/2016/schedule/" + event + "?teamNumber=" + teamNumber, "schedule-" + event + "-" + teamNumber, true);
		return new Gson().fromJson(json, EventSchedule.class);
	}

	public String makeRequest(String request, String fileName, boolean auth)// handles all the logic for requests
	{
		File f = new File("Cache/" + fileName + ".txt");
		Client client = ClientBuilder.newClient();
		Response response = null;
		String body = null;
		if (!forceNoUpdate && ( !f.exists() && !f.isDirectory()))
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
		if(debugLevel == 1)
			logFile.println(cal + ":------: " + msg);
		else if(debugLevel == 2)
		{
			logFile.println(cal + ":------: " +msg);
			System.out.println(msg);
		}
			
	}
}
