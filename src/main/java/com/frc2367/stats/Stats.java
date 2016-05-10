package com.frc2367.stats;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.frc2367.api.FullTeam;
import com.frc2367.api.WebApiTesting;

public class Stats {
	private DefaultXYDataset test = new DefaultXYDataset();
	private XYSeriesCollection seriesCollection = new XYSeriesCollection();
	private JFreeChart scatter;
	private WebApiTesting api = new WebApiTesting(true);
	private ArrayList<FullTeam> arr = api.updateData();
	private XYSeries[] bigTest = new XYSeries[arr.size()];
	private ArrayList<Integer> totalPoints;
	private int xMax = 0, xMin = 0, yMax = 0, yMin = 0;

	public Stats() {

	}

	public JFreeChart getPlot() {
		return scatter;
	}

	public void createSeries() {

		int xVal, yVal = 0;

		for (int i = 0; i < arr.size(); i++) {
			bigTest[i] = new XYSeries(arr.get(i).getTeamNumberAsString());
			for (int j = 0; j < arr.get(i).getTeamScores().size(); j++) {
				xVal = arr.get(i).getTeamScores().get(j).getBreachPoints();
				yVal = arr.get(i).getTeamScores().get(j).getTotalPoints();
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

	public JPanel displayChart() {

		int xTickUnit = 0, yTickUnit = 0;

		JPanel panelForReturn = new JPanel();

		// chart setup
		createSeries();
		scatter = ChartFactory.createScatterPlot("Team Number vs Score", "Team Number", "Match Score", seriesCollection,
				PlotOrientation.VERTICAL, false, false, false);
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
		NumberAxis yAxis = new NumberAxis();
		yAxis.setTickUnit(new NumberTickUnit(yTickUnit));
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

		yAxis.setRange(yMin, yMax + 5);
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
