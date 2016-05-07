package com.frc2367.api;

import java.util.ArrayList;

import com.frc2367.data.scores.Alliance;
import com.frc2367.data.teams.TeamInfo;

public class FullTeam implements Comparable<FullTeam>
{
	private int teamNumber;
	private String nameFull;
	private String nameShort;
	private String city;
	private String stateProv;
	private String country;
	private int rookieYear;
	private String robotName;
	private String districtCode;
	private String website;
	private ArrayList<Alliance> teamScores;

	
	public FullTeam()
	{
		teamScores = new ArrayList<Alliance>();
	}
	
	public void setInfo(TeamInfo info)
	{
		this.teamNumber = info.getTeamNumber();
		this.nameFull = info.getNameFull();
		this.nameShort = info.getNameShort();
		this.city = info.getCity();
		this.stateProv = info.getStateProv();
		this.country = info.getCountry();
		this.rookieYear = info.getRookieYear();
		this.robotName = info.getRobotName();
		this.districtCode = info.getDistrictCode();
		this.website = info.getWebsite();
	}
	
	public String getTeamNumberAsString()
	{
		return Integer.toString(teamNumber);
	}

	public String toString()
	{
		return Integer.toString(teamNumber) + " - " + nameShort;
	}

	@Override
	public int compareTo(FullTeam arg0)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	public int getTeamNumber()
	{
		return teamNumber;
	}

	public String getNameFull()
	{
		return nameFull;
	}

	public String getNameShort()
	{
		return nameShort;
	}

	public String getCity()
	{
		return city;
	}

	public String getStateProv()
	{
		return stateProv;
	}

	public String getCountry()
	{
		return country;
	}

	public int getRookieYear()
	{
		return rookieYear;
	}

	public String getRobotName()
	{
		return robotName;
	}

	public String getDistrictCode()
	{
		return districtCode;
	}

	public String getWebsite()
	{
		return website;
	}

	public ArrayList<Alliance> getTeamScores()
	{
		return teamScores;
	}
	public void addMatch(Alliance ally)
	{
		this.teamScores.add(ally);
	}
	
}
