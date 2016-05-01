package com.frc2367.data.scores;

public class GeneralScore
{
	private MatchScore matchScore;
	private Match match;
	public GeneralScore(MatchScore matchScore, Match match)
	{
		this.matchScore = matchScore;
		this.match = match;
	}
	public MatchScore getMatchScore()
	{
		return matchScore;
	}
	public Match getMatch()
	{
		return match;
	}
	
	
}
