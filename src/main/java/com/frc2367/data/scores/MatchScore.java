package com.frc2367.data.scores;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MatchScore
{

	private String matchLevel;
	private int matchNumber;
	@SerializedName("AudienceGroup")
	@Expose
	private String audienceGroup;
	@SerializedName("Alliances")
	@Expose
	private ArrayList<Alliance> alliances = new ArrayList<Alliance>();
	
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
		return audienceGroup;
	}

	public ArrayList<Alliance> getAlliances()
	{
		return alliances;
	}
	public Alliance getAlliance(String color)
	{
		for(Alliance ally : alliances)
		{
			if(ally.getAlliance()==color)
				return ally;
		}
		return null;
	}
		

}
