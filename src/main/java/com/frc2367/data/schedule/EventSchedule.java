package com.frc2367.data.schedule;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventSchedule
{
	@SerializedName("Schedule")
	@Expose
	private ArrayList<Schedule> schedule = new ArrayList<Schedule>();

	public ArrayList<Schedule> getSchedule()
	{
		return schedule;
	}
	
}
