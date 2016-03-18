package com.frc2367.data.scores;

import java.util.ArrayList;

public class MatchScore
{

	private String matchLevel;
	private int matchNumber;
	private String AudienceGroup;
	private ArrayList<Alliance> Alliances = new ArrayList<Alliance>();
	
	public MatchScore()
	{
		
	}

	public String getMatchLevel()
	{
		return matchLevel;
	}

	public int getMatchNumber()
	{
		return matchNumber;
	}

	public String getAudienceGroup()
	{
		return AudienceGroup;
	}

	public ArrayList<Alliance> getAlliances()
	{
		return Alliances;
	}
		

}
