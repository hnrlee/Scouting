import java.util.ArrayList;

import com.frc2367.api.FullTeam;
import com.frc2367.api.WebApiTesting;
import com.frc2367.data.ScoutedTeam;
import com.frc2367.gui.GUI;
import com.frc2367.stats.Stats;

public class Main {
	public static void main(String[] args) {
		GUI mainWindow = new GUI();
		Stats stat = new Stats();
		mainWindow.setTestScatter(stat.displayChart());
		mainWindow.setupBasicStatPanel();
		ArrayList<ScoutedTeam> teams = new ArrayList<ScoutedTeam>();
		WebApiTesting api = new WebApiTesting(true);
		//api.updateData();
		ArrayList<FullTeam> arrTest = api.updateData();
		//System.out.println(api.updateData().get(10).getTeamNumber());
		System.out.println("asdf");

	}
}
