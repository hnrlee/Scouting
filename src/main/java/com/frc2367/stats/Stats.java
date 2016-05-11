package com.frc2367.stats;

import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.frc2367.api.FullTeam;
import com.frc2367.api.WebApiTesting;

public class Stats {
	private XYSeriesCollection seriesCollection = new XYSeriesCollection();
	private JFreeChart scatter;
	private WebApiTesting api = new WebApiTesting(true);
	private ArrayList<FullTeam> arr = api.updateData();
	private XYSeries[] bigTest = new XYSeries[arr.size()];
	private int xMax = 0, xMin = 0, yMax = 0, yMin = 0;
	private String xAxisData = "test x";
	private String yAxisData = "test y";
//	private int xSelection = 0;
//	private int ySelection = 0;

	public Stats() {

	}

	public JFreeChart getPlot() {
		return scatter;
	}

	public void createSeries(int xSelection,int ySelection) {

		int xVal, yVal = 0;
		seriesCollection = new XYSeriesCollection();
		bigTest = new XYSeries[arr.size()];
		

		for (int i = 0; i < arr.size(); i++) {
			bigTest[i] = new XYSeries(arr.get(i).getTeamNumberAsString());
			for (int j = 0; j < arr.get(i).getTeamScores().size(); j++) {

				/*
				 * autoboulderslow autobouldershigh teleopboulderslow
				 * teleopbouldershigh towerendstrength foulcount techfoulcount
				 * autopoints autoreachpoints autocrossingpoints
				 * autoboulderpoints teleoppoints teleopcrossingpoints
				 * teleopboulderpoints teleopchallengepoints teleopscalepoints
				 * foulpoints totalpoints
				 */

				switch (xSelection) {
				case 0:
					xVal = arr.get(i).getTeamScores().get(j).getAutoBouldersLow();
					xAxisData = "Auto Low Goal Count";
					break;
				case 1:
					xVal = arr.get(i).getTeamScores().get(j).getAutoBouldersHigh();
					xAxisData = "Auto High Goal Count";
					break;
				case 2:
					xVal = arr.get(i).getTeamScores().get(j).getTeleopBouldersLow();
					xAxisData = "Teleop Low Goal Count";
					break;
				case 3:
					xVal = arr.get(i).getTeamScores().get(j).getTeleopBouldersHigh();
					xAxisData = "Teleop High Goal Count";
					break;
				case 4:
					xVal = arr.get(i).getTeamScores().get(j).getTowerEndStrength();
					xAxisData = "Tower End Strength";
					break;
				case 5:
					xVal = arr.get(i).getTeamScores().get(j).getFoulCount();
					xAxisData = "Foul Count";
					break;
				case 6:
					xVal = arr.get(i).getTeamScores().get(j).getTechFoulCount();
					xAxisData = "Tech Foul Count";
					break;
				case 7:
					xVal = arr.get(i).getTeamScores().get(j).getAutoPoints();
					xAxisData = "Auto Points";
					break;
				case 8:
					xVal = arr.get(i).getTeamScores().get(j).getAutoReachPoints();
					xAxisData = "Auto Reach Points";
					break;
				case 9:
					xVal = arr.get(i).getTeamScores().get(j).getAutoCrossingPoints();
					xAxisData = "Auto Crossing Points";
					break;
				case 10:
					xVal = arr.get(i).getTeamScores().get(j).getAutoBoulderPoints();
					xAxisData = "Auto Goal Points";
					break;
				case 11:
					xVal = arr.get(i).getTeamScores().get(j).getTeleopPoints();
					xAxisData = "Teleop Points";
					break;
				case 12:
					xVal = arr.get(i).getTeamScores().get(j).getTeleopCrossingPoints();
					xAxisData = "Teleop Crossing Points";
					break;
				case 13:
					xVal = arr.get(i).getTeamScores().get(j).getTeleopBoulderPoints();
					xAxisData = "Teleop Goal Points";
					break;
				case 14:
					xVal = arr.get(i).getTeamScores().get(j).getTeleopChallengePoints();
					xAxisData = "Teleop Challenge Points";
					break;
				case 15:
					xVal = arr.get(i).getTeamScores().get(j).getTeleopScalePoints();
					xAxisData = "Teleop Scale Points";
					break;
				case 16:
					xVal = arr.get(i).getTeamScores().get(j).getFoulPoints();
					xAxisData = "Foul Points";
					break;
				case 17:
					xVal = arr.get(i).getTeamScores().get(j).getTotalPoints();
					xAxisData = "Total Points";
					break;
				case 18:
					xVal = arr.get(i).getTeamNumber();
					xAxisData = "Team Number";
					break;
				default:
					xVal = arr.get(i).getTeamNumber();
					xAxisData = "Team Number";
					break;
				}

				switch (ySelection) {
				case 0:
					yVal = arr.get(i).getTeamScores().get(j).getAutoBouldersLow();
					yAxisData = "Auto Low Goal Count";
					break;
				case 1:
					yVal = arr.get(i).getTeamScores().get(j).getAutoBouldersHigh();
					yAxisData = "Auto High Goal Count";
					break;
				case 2:
					yVal = arr.get(i).getTeamScores().get(j).getTeleopBouldersLow();
					yAxisData = "Teleop Low Goal Count";
					break;
				case 3:
					yVal = arr.get(i).getTeamScores().get(j).getTeleopBouldersHigh();
					yAxisData = "Teleop High Goal Count";
					break;
				case 4:
					yVal = arr.get(i).getTeamScores().get(j).getTowerEndStrength();
					yAxisData = "Tower End Strength";
					break;
				case 5:
					yVal = arr.get(i).getTeamScores().get(j).getFoulCount();
					yAxisData = "Foul Count";
					break;
				case 6:
					yVal = arr.get(i).getTeamScores().get(j).getTechFoulCount();
					yAxisData = "Tech Foul Count";
					break;
				case 7:
					yVal = arr.get(i).getTeamScores().get(j).getAutoPoints();
					yAxisData = "Auto Points";
					break;
				case 8:
					yVal = arr.get(i).getTeamScores().get(j).getAutoReachPoints();
					yAxisData = "Auto Reach Points";
					break;
				case 9:
					yVal = arr.get(i).getTeamScores().get(j).getAutoCrossingPoints();
					yAxisData = "Auto Crossing Points";
					break;
				case 10:
					yVal = arr.get(i).getTeamScores().get(j).getAutoBoulderPoints();
					yAxisData = "Auto Goal Points";
					break;
				case 11:
					yVal = arr.get(i).getTeamScores().get(j).getTeleopPoints();
					yAxisData = "Teleop Points";
					break;
				case 12:
					yVal = arr.get(i).getTeamScores().get(j).getTeleopCrossingPoints();
					yAxisData = "Teleop Crossing Points";
					break;
				case 13:
					yVal = arr.get(i).getTeamScores().get(j).getTeleopBoulderPoints();
					yAxisData = "Teleop Goal Points";
					break;
				case 14:
					yVal = arr.get(i).getTeamScores().get(j).getTeleopChallengePoints();
					yAxisData = "Teleop Challenge Points";
					break;
				case 15:
					yVal = arr.get(i).getTeamScores().get(j).getTeleopScalePoints();
					yAxisData = "Teleop Scale Points";
					break;
				case 16:
					yVal = arr.get(i).getTeamScores().get(j).getFoulPoints();
					yAxisData = "Foul Points";
					break;
				case 17:
					yVal = arr.get(i).getTeamScores().get(j).getTotalPoints();
					yAxisData = "Total Points";
					break;
				case 18:
					yVal = arr.get(i).getTeamNumber();
					yAxisData = "Team Number";
					break;
				default:
					yVal = arr.get(i).getTeamNumber();
					yAxisData = "Team Number";
					break;
				}

				bigTest[i].add(xVal, yVal);

				if (i == 0 && j == 0) {
					xMin = xVal;
					xMax = xVal;
					yMin = yVal;
					yMin = yVal;
				}

				if (xVal > xMax)
					xMax = xVal;
				if (yVal > yMax)
					yMax = yVal;

				// bigTest[i].add(arr.get(i).getTeamScores().get(j).getAutoPoints(),
				// arr.get(i).getTeamScores().get(j).getTotalPoints());
			}
			seriesCollection.addSeries(bigTest[i]);
		}

		// series.add(2367, 39);
		// series.add(2367, 59);
		// series.add(2367, 91);
		// series.add(2367, 99);
		// series.add(2367, 44);
		// series.add(2367, 58);
		// series.add(2367, 68);
		// series.add(2367, 64);
		// series.add(2367, 64);
		// series.add(2367, 64);
		// seriesCollection.addSeries(series);
	}

	public JPanel displayChart(int xSelection,int ySelection) {

		int xTickUnit = 0, yTickUnit = 0;

		JPanel panelForReturn = new JPanel();

		// chart setup
		createSeries(xSelection,ySelection);
		scatter = ChartFactory.createScatterPlot(xAxisData + " vs " + yAxisData, xAxisData, yAxisData, seriesCollection,
				PlotOrientation.VERTICAL, false, true, false);
		XYLineAndShapeRenderer render = new XYLineAndShapeRenderer();
		XYPlot plot = new XYPlot();

		// configure axes
		NumberAxis xAxis = new NumberAxis();

		if (xMin < 6)
			xMin = 0;
		else
			xMin -= 5;
		if (xMax - xMin < 10)
			xTickUnit = 2;
		else if (xMax - xMin < 50)
			xTickUnit = 10;
		else if (xMax - xMin < 500)
			xTickUnit = 20;
		else if (xMax - xMin < 1000)
			xTickUnit = 100;
		else if (xMax - xMin < 10000)
			xTickUnit = 500;

		xAxis.setTickUnit(new NumberTickUnit(xTickUnit));
		xAxis.setRange(xMin, xMax + 5);
		xAxis.setLabel(xAxisData);

		NumberAxis yAxis = new NumberAxis();

		if (yMin < 6)
			yMin = 0;
		else
			yMin -= 5;

		if (yMax - yMin < 10)
			yTickUnit = 2;
		else if (yMax - yMin < 50)
			yTickUnit = 10;
		else if (yMax - yMin < 500)
			yTickUnit = 20;
		else if (yMax - yMin < 1000)
			yTickUnit = 100;
		else if (yMax - yMin < 10000)
			yTickUnit = 500;

		yAxis.setTickUnit(new NumberTickUnit(yTickUnit));
		yAxis.setRange(yMin, yMax + 5);
		yAxis.setLabel(yAxisData);
		((XYPlot) scatter.getPlot()).setDomainAxis(xAxis);
		((XYPlot) scatter.getPlot()).setRangeAxis(yAxis);

		// rendering and displaying
		plot.setRenderer(render);
		panelForReturn.add(new ChartPanel(scatter));
		return panelForReturn;
	}

	// public double calcExpectedMatchPoints(Alliance a) {
	//
	// return -1;
	// }

	public double stdDevProportion() {
		return -1;
	}

	public double stdDevPop() {
		return -1;
	}

}
