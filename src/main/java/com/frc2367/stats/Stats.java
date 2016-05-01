package com.frc2367.stats;

import java.awt.BasicStroke;
import java.awt.Color;

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

public class Stats {
	private DefaultXYDataset test = new DefaultXYDataset();
	private XYSeries series = new XYSeries("2367");
	private XYSeriesCollection seriesCollection = new XYSeriesCollection();
	private JFreeChart scatter;

	public Stats() {

	}

	public JFreeChart getPlot() {
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

	public JPanel displayChart() {
		JPanel panelForReturn = new JPanel();
		
		// chart setup
		createSeries();
		scatter = ChartFactory.createScatterPlot("Team Number vs Score", "Team Number", "Match Score", seriesCollection,
				PlotOrientation.VERTICAL, true, true, false);
		XYLineAndShapeRenderer render = new XYLineAndShapeRenderer();
		render.setSeriesPaint(0, Color.RED);
		render.setSeriesStroke(0, new BasicStroke(4.0f));
		XYPlot plot = new XYPlot();

		// configure axes
		NumberAxis xAxis = new NumberAxis();
		xAxis.setTickUnit(new NumberTickUnit(1000));
		xAxis.setRange(0.0, 3000.0);
		NumberAxis yAxis = new NumberAxis();
		yAxis.setTickUnit(new NumberTickUnit(10));
		yAxis.setRange(0.0, 200);
		((XYPlot) scatter.getPlot()).setDomainAxis(xAxis);
		((XYPlot) scatter.getPlot()).setRangeAxis(yAxis);

		// rendering and displaying
		plot.setRenderer(render);
		panelForReturn.add(new ChartPanel(scatter));
		JFrame frame = new JFrame();
		frame.add(panelForReturn);
		frame.setSize(800, 500);
		frame.setVisible(true);
		
		
		return panelForReturn;
	}

//	public double calcExpectedMatchPoints(Alliance a) {
//
//		return -1;
//	}

	public double stdDevProportion() {
		return -1;
	}

	public double stdDevPop() {
		return -1;
	}

}
