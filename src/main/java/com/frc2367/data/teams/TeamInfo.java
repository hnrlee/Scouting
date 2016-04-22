package com.frc2367.data.teams;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeamInfo implements Comparable<TeamInfo>
{

	private String website;
	private String name;
	private String locality;
	
	@SerializedName("rookie_year")
	@Expose
	private int rookieYear;
	private String region;
	
	@SerializedName("team_number")
	@Expose
	
	private int teamNumber;
	private String location;
	private String key;
	private String countryName;
	private String motto;
	private String nickname;
	
	public TeamInfo()
	{
	}

	public String getWebsite()
	{
		return website;
	}

	public String getName()
	{
		return name;
	}

	public String getLocality()
	{
		return locality;
	}

	public int getRookieYear()
	{
		return rookieYear;
	}

	public String getRegion()
	{
		return region;
	}

	public int getTeamNumber()
	{
		return teamNumber;
	}

	public String getLocation()
	{
		return location;
	}

	public String getKey()
	{
		return key;
	}

	public String getCountryName()
	{
		return countryName;
	}

	public String getMotto()
	{
		return motto;
	}

	public String getNickname()
	{
		return nickname;
	}

	public String getTeamNumberAsString()
	{
		return Integer.toString(teamNumber);
	}
	public String toString()
	{
		return Integer.toString(teamNumber) + " - "  + nickname;
	}

	@Override
	public int compareTo(TeamInfo arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
