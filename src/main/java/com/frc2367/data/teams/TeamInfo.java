package com.frc2367.data.teams;

public class TeamInfo implements Comparable<TeamInfo>
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

	public String getTeamNumberAsString()
	{
		return Integer.toString(teamNumber);
	}

	public String toString()
	{
		return Integer.toString(teamNumber) + " - " + nameShort;
	}

	@Override
	public int compareTo(TeamInfo arg0)
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
	
}
