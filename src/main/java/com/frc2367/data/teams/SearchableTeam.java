//shoutout to G. Cope
package com.frc2367.data.teams;

import java.util.ArrayList;
import java.util.Collection;

public class SearchableTeam implements Searchable<TeamInfo> {
	
	private ArrayList<TeamInfo> teams = new ArrayList<TeamInfo>();
	public SearchableTeam(ArrayList<TeamInfo> allTeams)
	{
		teams.addAll(allTeams);
	}

	@Override
	public Collection<TeamInfo> search(String value) {
		ArrayList<TeamInfo> found = new ArrayList<TeamInfo>();
		for(TeamInfo team: teams)
		{
			if(team.getTeamNumberAsString().indexOf(value)==0)
				found.add(team);
		}
		return found;
	}

}
