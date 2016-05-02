package com.frc2367.data.scores;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Match
{
	private String actualStartTime;
	private String description;
	private int number;
	private String postResultTime;
	private int scoreRedFinal;
	private int scoreRedFoul;
	private int scoreRedAuto;
	private int scoreBlueFinal;
	private int scoreBlueFoul;
	private int scoreBlueAuto;
	private String tournamentLevel;
	
	@SerializedName("Teams")
	@Expose
	private ArrayList<Team> teams = new ArrayList<Team>();

	public String getActualStartTime()
	{
		return actualStartTime;
	}

	public String getDescription()
	{
		return description;
	}

	public int getNumber()
	{
		return number;
	}

	public String getPostResultTime()
	{
		return postResultTime;
	}

	public int getScoreRedFinal()
	{
		return scoreRedFinal;
	}

	public int getScoreRedFoul()
	{
		return scoreRedFoul;
	}

	public int getScoreRedAuto()
	{
		return scoreRedAuto;
	}

	public int getScoreBlueFinal()
	{
		return scoreBlueFinal;
	}

	public int getScoreBlueFoul()
	{
		return scoreBlueFoul;
	}

	public int getScoreBlueAuto()
	{
		return scoreBlueAuto;
	}

	public String getTournamentLevel()
	{
		return tournamentLevel;
	}

	public ArrayList<Team> getTeams()
	{
		return teams;
	}
	
	public String getTeamAlliance(int teamNumber)
	{
		for(Team team : teams)
		{
			if(team.getTeamNumber()==teamNumber)
			{
				if(team.getStation().contains("blue"))
					return "blue";
				else
					return "red";
			}
		}
		return null;
	}
}
