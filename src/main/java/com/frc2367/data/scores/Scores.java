package com.frc2367.data.scores;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Scores
{

	@SerializedName("MatchScores")
	@Expose
	private ArrayList<MatchScore> matchScores = new ArrayList<MatchScore>();

	public Scores()
	{

	}

	public ArrayList<MatchScore> getMatchScores()
	{
		return matchScores;
	}

}
