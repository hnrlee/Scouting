package com.frc2367.data.events;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Events
{
	@SerializedName("Events")
	@Expose
	private ArrayList<Event> events = new ArrayList<Event>();
	public int eventCount;
	
	public ArrayList<Event> getEvents()
	{
		return events;
	}
	public void setEvents(ArrayList<Event> events)
	{
		this.events = events;
	}
	public int getEventCount()
	{
		return eventCount;
	}
	public void setEventCount(int eventCount)
	{
		this.eventCount = eventCount;
	}
	
}
