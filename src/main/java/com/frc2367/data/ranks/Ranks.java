package com.frc2367.data.ranks;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ranks
{
	@SerializedName("Rankings")
	@Expose
	private ArrayList<Ranking> Rankings = new ArrayList<Ranking>();
	public Ranks()
	{
		
	}
	public ArrayList<Ranking> getRankings()
	{
		return Rankings;
	}
	
	
}
