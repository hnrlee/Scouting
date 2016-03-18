package com.frc2367.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

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

	@GET
	@Produces(MediaType.TEXT_PLAIN)

	public void getEvents()
	{
		File f = new File("Cache/events.txt");
		if (!f.exists() && !f.isDirectory())
		{
			Client client = ClientBuilder.newClient();
			Response response = client.target("https://frc-api.firstinspires.org/v2.0/2016/events").request(MediaType.TEXT_PLAIN_TYPE).header("Authorization", apiKey).get();
			System.out.println("status: " + response.getStatus());
			System.out.println("headers: " + response.getHeaders());
			String body = response.readEntity(String.class);
			try
			{
				PrintWriter out = new PrintWriter("Cache/events.txt");
				out.println(body);
				out.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("Error writing to file");
			}
		}

	}

	public void getTeams()
	{
		File f = new File("Cache/" + competition + "-teams.txt");
		if (!f.exists() && !f.isDirectory())
		{
			Client client = ClientBuilder.newClient();
			Response response = client.target("http://thebluealliance.com/api/v2/event/" + competition + "/teams").request(MediaType.TEXT_PLAIN_TYPE).header("X-TBA-App-Id", "frc2367:team-analysis:v0.1").get();

			System.out.println("status: " + response.getStatus());
			String body = response.readEntity(String.class);
			try
			{
				PrintWriter out = new PrintWriter("Cache/" + competition + "-teams.txt");
				out.println(body);
				out.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("Error writing to file");
			}
		}
	}

	public void getMatchDetails(String event, int teamNumber, String level)
	{
		File f = new File("Cache/" + competition + "-" + teamNumber + "-" + level + ".txt");
		if (!f.exists() && !f.isDirectory())
		{
			
			Client client = ClientBuilder.newClient();
			// Response response = client.target("https://frc-api.firstinspires.org/v2.0/2016/scores/" + event + "/" + level + "?teamNumber=" +
			// teamNumber).request(MediaType.TEXT_PLAIN_TYPE).header("Authorization", apiKey).get();
			Response response = client.target("https://frc-api.firstinspires.org/v2.0/2016/scores/" + event + "/" + level + "?matchNumber=1").request(MediaType.TEXT_PLAIN_TYPE).header("Authorization", apiKey).get();
			System.out.println("status: " + response.getStatus());
			System.out.println("headers: " + response.getHeaders());
			String body = response.readEntity(String.class);
			try
			{
				PrintWriter out = new PrintWriter("Cache/" + competition + "-" + teamNumber + "-" + level + ".txt");
				out.println(body);
				out.close();
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
				System.out.println("Error writing to file");
			}
			Gson gson = new Gson();
			Scores scores = gson.fromJson(body, Scores.class);
			System.out.println(scores.getMatchScores().get(0).getMatchNumber());
		}	
	}
}
