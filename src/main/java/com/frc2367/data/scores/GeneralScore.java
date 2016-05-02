package com.frc2367.data.scores;

public class GeneralScore
{
	private MatchScore detailScore;
	private Match simpleScore;
	public GeneralScore(MatchScore matchScore, Match match)
	{
		this.detailScore = matchScore;
		this.simpleScore = match;
	}
	public MatchScore getDetailScore()
	{
		return detailScore;
	}
	public Match getSimpleScore()
	{
		return simpleScore;
	}

	
}
