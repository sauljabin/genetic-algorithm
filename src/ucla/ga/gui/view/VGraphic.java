package ucla.ga.gui.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import ucla.ga.util.HelperImage;

public class VGraphic extends JFrame {

	private static final long serialVersionUID = -7690162952744313595L;

	XYSeriesCollection dataset;
	JFreeChart chart;
	XYSeries offline;
	XYSeries average;
	XYSeries online;

	JLabel lblOffline;
	JLabel lblOnline;
	JLabel lblAverage;

	public VGraphic(String title) {
		setSize(800, 600);
		setLocationRelativeTo(this);
		setTitle(title);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
			}
		});
		setLayout(new BorderLayout());

		average = new XYSeries("Average");
		offline = new XYSeries("Off-Line");
		online = new XYSeries("On-Line");

		dataset = new XYSeriesCollection();
		dataset.addSeries(average);
		dataset.addSeries(offline);
		dataset.addSeries(online);

		chart = ChartFactory.createXYLineChart(title, "Generations", "Values", dataset, PlotOrientation.VERTICAL, true, true, false);

		add(new ChartPanel(chart), BorderLayout.CENTER);

		JPanel sur = new JPanel(new MigLayout());

		lblAverage = new JLabel("");
		lblAverage.setHorizontalTextPosition(SwingConstants.LEFT);
		lblAverage.setFont(new Font("ARIAL", Font.BOLD, 26));
		JLabel lblAverageTitle = new JLabel("Average: ");
		lblAverageTitle.setFont(new Font("ARIAL", Font.BOLD, 26));
		sur.add(lblAverageTitle);
		sur.add(lblAverage, "wrap");

		lblOffline = new JLabel("");
		lblOffline.setHorizontalTextPosition(SwingConstants.LEFT);
		lblOffline.setFont(new Font("ARIAL", Font.BOLD, 26));
		JLabel lblOfflineTitle = new JLabel("Offline: ");
		lblOfflineTitle.setFont(new Font("ARIAL", Font.BOLD, 26));
		sur.add(lblOfflineTitle);
		sur.add(lblOffline, "wrap");

		lblOnline = new JLabel("");
		lblOnline.setHorizontalTextPosition(SwingConstants.LEFT);
		lblOnline.setFont(new Font("ARIAL", Font.BOLD, 26));
		JLabel lblOnlineTitle = new JLabel("Online: ");
		lblOnlineTitle.setFont(new Font("ARIAL", Font.BOLD, 26));
		sur.add(lblOnlineTitle);
		sur.add(lblOnline, "wrap");

		add(sur, BorderLayout.SOUTH);
		setVisible(true);
		repaint();
	}

	public void addPoint(int t, double vAverage, double vOffLine, double vOnLine) {
		average.add(t, vAverage);
		offline.add(t, vOffLine);
		online.add(t, vOnLine);
		lblAverage.setText("" + vAverage);
		lblOffline.setText("" + vOffLine);
		lblOnline.setText("" + vOnLine);
	}

	public void exportImage(String path) throws IOException {
		HelperImage.writeImage(chart.createBufferedImage(800, 600), path);
	}

}