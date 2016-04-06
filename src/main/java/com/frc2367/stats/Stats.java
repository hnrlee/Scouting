package com.frc2367.stats;

import com.frc2367.data.scores.Alliance;
import com.frc2367.gui.GUI;

import java.awt.BasicStroke;
import java.awt.Color;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.FastScatterPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.ScatterRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

public class Stats extends ApplicationFrame {

	private JPanel panel;
	private DefaultXYDataset test = new DefaultXYDataset();
	private XYSeries series = new XYSeries("2367");
	private XYSeriesCollection seriesCollection = new XYSeriesCollection();
	private JFreeChart scatter;

	public Stats(String applicationTitle, String chartTitle) {
		super(applicationTitle);
		createSeries();
		scatter = ChartFactory.createScatterPlot("Team Number vs Score", "Team Number", "Match Score",
				seriesCollection, PlotOrientation.VERTICAL, true, true, false);
		ChartPanel chartPanel = new ChartPanel(scatter);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 500));
		XYLineAndShapeRenderer render = new XYLineAndShapeRenderer();
		render.setSeriesPaint(0, Color.RED);
		render.setSeriesStroke(0, new BasicStroke(4.0f));
		XYPlot plot = new XYPlot();
		plot.setRenderer(render);
		setContentPane(chartPanel);

	}
	
	public JFreeChart getPlot(){
		return scatter;
	}

	public void createSeries() {
		series.add(2367, 39);
		series.add(2367, 59);
		series.add(2367, 91);
		series.add(2367, 99);
		series.add(2367, 44);
		series.add(2367, 58);
		series.add(2367, 68);
		series.add(2367, 64);
		seriesCollection.addSeries(series);
	}

	public double calcExpectedMatchPoints(Alliance a) {

		return -1;
	}

	public double stdDevProportion() {
		return -1;
	}

	public double stdDevPop() {
		return -1;
	}

}
