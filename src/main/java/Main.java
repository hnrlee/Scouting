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
		Stats chart = new Stats("Test thing", "test");
		NumberAxis xAxis = new NumberAxis();
		xAxis.setTickUnit(new NumberTickUnit(1000));
		xAxis.setRange(0.0, 3000.0);

		NumberAxis yAxis = new NumberAxis();
		yAxis.setTickUnit(new NumberTickUnit(10));
		yAxis.setRange(0.0, 200);

		// Assign it to the chart
		XYPlot plot = (XYPlot) chart.getPlot().getPlot();
		plot.setDomainAxis(xAxis);
		plot.setRangeAxis(yAxis);
		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);
		ArrayList<ScoutedTeam> teams = new ArrayList<ScoutedTeam>();
		WebApi api = new WebApi("cada", true, teams);
		api.updateData();

	}
}
