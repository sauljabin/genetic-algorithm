/**
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *  
 */

package ai.ga.gui.view;

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

import ai.ga.util.HelperImage;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class VGraphic extends JFrame {

	private static final long serialVersionUID = -7690162952744313595L;

	private XYSeriesCollection dataset;
	private JFreeChart chart;
	private XYSeries offline;
	private XYSeries average;
	private XYSeries online;

	private JLabel lblOffline;
	private JLabel lblOnline;
	private JLabel lblAverage;	

	public VGraphic(String title, String xLabel, String yLabel) {
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
		offline = new XYSeries("Offline");
		online = new XYSeries("Online");

		dataset = new XYSeriesCollection();
		dataset.addSeries(average);
		dataset.addSeries(offline);
		dataset.addSeries(online);

		chart = ChartFactory.createXYLineChart(title, xLabel, yLabel, dataset, PlotOrientation.VERTICAL, true, true, false);
		add(new ChartPanel(chart), BorderLayout.CENTER);

		JPanel south = new JPanel(new MigLayout());

		lblAverage = new JLabel("");
		lblAverage.setHorizontalTextPosition(SwingConstants.LEFT);
		lblAverage.setFont(new Font("ARIAL", Font.BOLD, 26));
		JLabel lblAverageTitle = new JLabel("Average: ");
		lblAverageTitle.setFont(new Font("ARIAL", Font.BOLD, 26));
		south.add(lblAverageTitle);
		south.add(lblAverage, "wrap");

		lblOffline = new JLabel("");
		lblOffline.setHorizontalTextPosition(SwingConstants.LEFT);
		lblOffline.setFont(new Font("ARIAL", Font.BOLD, 26));
		JLabel lblOfflineTitle = new JLabel("Offline: ");
		lblOfflineTitle.setFont(new Font("ARIAL", Font.BOLD, 26));
		south.add(lblOfflineTitle);
		south.add(lblOffline, "wrap");

		lblOnline = new JLabel("");
		lblOnline.setHorizontalTextPosition(SwingConstants.LEFT);
		lblOnline.setFont(new Font("ARIAL", Font.BOLD, 26));
		JLabel lblOnlineTitle = new JLabel("Online: ");
		lblOnlineTitle.setFont(new Font("ARIAL", Font.BOLD, 26));
		south.add(lblOnlineTitle);
		south.add(lblOnline, "wrap");

		add(south, BorderLayout.SOUTH);
	}

	public void addPoint(int t, double vAverage, double vOffLine, double vOnLine) {
		average.add(t, vAverage);
		offline.add(t, vOffLine);
		online.add(t, vOnLine);
		lblAverage.setText(String.format("%.15f", vAverage));
		lblOffline.setText(String.format("%.15f", vOffLine));
		lblOnline.setText(String.format("%.15f", vOnLine));
	}

	public void exportImage(String path) throws IOException {
		HelperImage.writeImage(chart.createBufferedImage(800, 600), path);
	}

}