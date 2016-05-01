package com.frc2367.data.scores;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class EventMatchRequest
{
	@SerializedName("Matches")
	private ArrayList<Match> matches = new ArrayList<Match>();

	public ArrayList<Match> getMatches()
	{
		return matches;
	}

}
