package com.frc2367.data.scores;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Match
{

	public String actualStartTime;

	public String description;

	public int number;

	public String postResultTime;

	public int scoreRedFinal;

	public int scoreRedFoul;

	public int scoreRedAuto;

	public int scoreBlueFinal;

	public int scoreBlueFoul;

	public int scoreBlueAuto;

	public String tournamentLevel;
	@SerializedName("Teams")
	@Expose
	private List<Team> teams = new ArrayList<Team>();

}
