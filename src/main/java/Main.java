import java.util.ArrayList;

import javax.swing.JFrame;

import com.frc2367.api.FullTeam;
import com.frc2367.api.WebApiTesting;
import com.frc2367.data.ScoutedTeam;
import com.frc2367.gui.GUI;
import com.frc2367.stats.Stats;

public class Main {
	public static void main(String[] args) {
		GUI mainWindow = new GUI();
		Stats stat = new Stats();
		//mainWindow.setTestScatter(stat.displayChart());
		//mainWindow.setupBasicStatPanel();
		ArrayList<ScoutedTeam> teams = new ArrayList<ScoutedTeam>();
		//WebApiTesting api = new WebApiTesting(true);
		//api.updateData();
		//ArrayList<FullTeam> arrTest = api.updateData();
		//System.out.println(api.updateData().get(10).getTeamNumber());
		//System.out.println("asdf");
		JFrame j = new JFrame("asdf");
		j.setSize(1900, 1000);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.add(stat.displayChart());
		j.setVisible(true);

	}
}
