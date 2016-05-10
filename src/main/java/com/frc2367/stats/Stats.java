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
	private int xAxisData;

	public Stats() {

	}

	public JFreeChart getPlot() {
		return scatter;
	}

	public void createSeries() {
		int xMax,xMin, yMax, yMin;

		for (int i = 0; i < arr.size(); i++) {
			bigTest[i] = new XYSeries(arr.get(i).getTeamNumberAsString());
			for (int j = 0; j < arr.get(i).getTeamScores().size(); j++) {
				try {
					//bigTest[i].add(arr.get(i).getTeamNumber(), arr.get(i).getTeamScores().get(j).getTotalPoints());
					
					bigTest[i].add(arr.get(i).getTeamScores().get(j).getAutoPoints(), arr.get(i).getTeamScores().get(j).getTotalPoints());
				} catch (Exception e) {
					System.out.println("ayylmao");
				}
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
		JPanel panelForReturn = new JPanel();

		// chart setup
		createSeries();
		scatter = ChartFactory.createScatterPlot("Team Number vs Score", "Team Number", "Match Score", seriesCollection,
				PlotOrientation.VERTICAL, false, false, false);
		XYLineAndShapeRenderer render = new XYLineAndShapeRenderer();
		XYPlot plot = new XYPlot();

		// configure axes
		NumberAxis xAxis = new NumberAxis();
		xAxis.setTickUnit(new NumberTickUnit(1000));
		xAxis.setRange(0.0, 6000.0);
		NumberAxis yAxis = new NumberAxis();
		yAxis.setTickUnit(new NumberTickUnit(20));
		yAxis.setRange(0.0, 300);
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
