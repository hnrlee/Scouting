import java.util.ArrayList;

import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.ui.RefineryUtilities;

import com.frc2367.api.WebApi;
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
		WebApi api = new WebApi("cada", true, teams);
		api.updateData();

	}
}
