package com.frc2367.data.schedule;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Schedule
{
	private String description;
	private String field;
	private int matchNumber;
	private String startTime;
	private String tournamentLevel;
	@SerializedName("Teams")
	@Expose
	private ArrayList<Team> teams = new ArrayList<Team>();
	public String getDescription()
	{
		return description;
	}
	public String getField()
	{
		return field;
	}
	public int getMatchNumber()
	{
		return matchNumber;
	}
	public String getStartTime()
	{
		return startTime;
	}
	public String getTournamentLevel()
	{
		return tournamentLevel;
	}
	public ArrayList<Team> getTeams()
	{
		return teams;
	}
	
}
