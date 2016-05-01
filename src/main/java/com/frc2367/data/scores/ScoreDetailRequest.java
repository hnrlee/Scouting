package com.frc2367.data.scores;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ScoreDetailRequest
{

	@SerializedName("MatchScores")
	@Expose
	private ArrayList<MatchScore> matchScores = new ArrayList<MatchScore>();

	public ScoreDetailRequest()
	{

	}

	public ArrayList<MatchScore> getMatchScores()
	{
		return matchScores;
	}

}
