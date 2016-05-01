package com.frc2367.data.teams;

import java.util.ArrayList;



public class TeamRequest
{
	private ArrayList<TeamInfo> teams = new ArrayList<TeamInfo>();
	private int teamCountTotal;
	private int teamCountPage;
	private int pageCurrent;
	private int pageTotal;
	
	public ArrayList<TeamInfo> getTeams()
	{
		return teams;
	}
	public int getTeamCountTotal()
	{
		return teamCountTotal;
	}
	public int getTeamCountPage()
	{
		return teamCountPage;
	}
	public int getPageCurrent()
	{
		return pageCurrent;
	}
	public int getPageTotal()
	{
		return pageTotal;
	}
	
	
	
}
