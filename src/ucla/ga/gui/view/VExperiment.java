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

package ucla.ga.gui.view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import ucla.ga.gui.controller.CExperiment;
import net.miginfocom.swing.MigLayout;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class VExperiment extends JFrame {

	private static final long serialVersionUID = 3534945320350243632L;

	private List<JButton> buttons;
	private JPanel pnlCentral;
	private JLabel lblLocale;
	private JLabel lblLimLow;
	private JLabel lblChromosome;
	private JLabel lblPopulation;
	private JSpinner spiLow;
	private JSpinner spiUp;
	private JSpinner spiChromosome;
	private JSpinner spiPopulation;
	private DefaultComboBoxModel<String> cmbModelSelectLocale;
	private JComboBox<String> cmbSelectLocale;
	private JButton btnRun;
	private JLabel lblGenerations;
	private JSpinner spiGenerations;
	private JLabel lblProbCrossover;
	private JTextField txtProbCrossover;
	private JLabel lblProbMutation;
	private JTextField txtProbMutation;
	private JPanel pnlSouth;
	private JButton btnClose;
	private JTextField txtPathOutput;
	private JButton btnPathOutput;
	private JLabel lblPathOutput;
	private JLabel lblLimUp;
	private JLabel lblCrossover;
	private DefaultComboBoxModel<String> cmbModelCrossover;
	private JComboBox<String> cmbCrossover;
	private JLabel lblMutation;
	private DefaultComboBoxModel<String> cmbModelMutation;
	private JComboBox<String> cmbMutation;
	private JLabel lblIndividual;
	private DefaultComboBoxModel<String> cmbModelIndividual;
	private JComboBox<String> cmbIndividual;
	private JLabel lblSelection;
	private DefaultComboBoxModel<String> cmbModelSelection;
	private JComboBox<String> cmbSelection;
	private JLabel lblFitness;
	private DefaultComboBoxModel<String> cmbModelFitness;
	private JComboBox<String> cmbFitness;
	private JLabel lblName;
	private JTextField txtName;

	private XYSeriesCollection dataset;
	private JFreeChart chart;
	private XYSeries offline;
	private XYSeries average;
	private XYSeries online;
	private JLabel lblOffline;
	private JLabel lblOnline;
	private JLabel lblAverage;
	private ChartPanel chartPanel;
	private JLabel lblAverageTitle;
	private JLabel lblOfflineTitle;
	private JLabel lblOnlineTitle;
	private XYSeries elite;
	private JLabel lblEliteTitle;
	private JLabel lblElite;

	public VExperiment() {
		setLayout(new BorderLayout());
		setSize(900, 700);
		setLocationRelativeTo(this);
		setResizable(false);
		buttons = new ArrayList<JButton>();

		// CENTER

		pnlCentral = new JPanel();
		pnlCentral.setLayout(new MigLayout());
		add(pnlCentral, BorderLayout.CENTER);

		lblLocale = new JLabel();
		cmbModelSelectLocale = new DefaultComboBoxModel<String>();
		cmbSelectLocale = new JComboBox<String>(cmbModelSelectLocale);

		lblLimLow = new JLabel();
		spiLow = new JSpinner();
		spiLow.setModel(new SpinnerNumberModel(-10., -100000., 100000., .5));

		lblLimUp = new JLabel();
		spiUp = new JSpinner();
		spiUp.setModel(new SpinnerNumberModel(10., -100000., 100000., .5));

		lblChromosome = new JLabel();
		spiChromosome = new JSpinner();
		spiChromosome.setModel(new SpinnerNumberModel(10, 0, 63, 1));

		lblPopulation = new JLabel();
		spiPopulation = new JSpinner();
		spiPopulation.setModel(new SpinnerNumberModel(10, 0, 100000, 1));

		lblGenerations = new JLabel();
		spiGenerations = new JSpinner();
		spiGenerations.setModel(new SpinnerNumberModel(100, 0, 100000, 1));

		lblProbCrossover = new JLabel();
		txtProbCrossover = new JTextField("0.5");

		lblProbMutation = new JLabel();
		txtProbMutation = new JTextField("0.001");

		lblIndividual = new JLabel();
		cmbModelIndividual = new DefaultComboBoxModel<String>();
		cmbIndividual = new JComboBox<String>(cmbModelIndividual);

		lblCrossover = new JLabel();
		cmbModelCrossover = new DefaultComboBoxModel<String>();
		cmbCrossover = new JComboBox<String>(cmbModelCrossover);

		lblMutation = new JLabel();
		cmbModelMutation = new DefaultComboBoxModel<String>();
		cmbMutation = new JComboBox<String>(cmbModelMutation);

		lblSelection = new JLabel();
		cmbModelSelection = new DefaultComboBoxModel<String>();
		cmbSelection = new JComboBox<String>(cmbModelSelection);

		lblFitness = new JLabel();
		cmbModelFitness = new DefaultComboBoxModel<String>();
		cmbFitness = new JComboBox<String>(cmbModelFitness);

		lblPathOutput = new JLabel();
		txtPathOutput = new JTextField();
		btnPathOutput = new JButton("...");

		lblName = new JLabel();
		txtName = new JTextField();

		lblAverage = new JLabel("");
		lblAverage.setHorizontalTextPosition(SwingConstants.LEFT);
		lblAverageTitle = new JLabel("Average: ");

		lblOffline = new JLabel("");
		lblOffline.setHorizontalTextPosition(SwingConstants.LEFT);
		lblOfflineTitle = new JLabel("Offline: ");

		lblOnline = new JLabel("");
		lblOnline.setHorizontalTextPosition(SwingConstants.LEFT);
		lblOnlineTitle = new JLabel("Online: ");

		lblElite = new JLabel("");
		lblElite.setHorizontalTextPosition(SwingConstants.LEFT);
		lblEliteTitle = new JLabel("Elite: ");

		average = new XYSeries("Average");
		offline = new XYSeries("Offline");
		online = new XYSeries("Online");
		elite = new XYSeries("Elite");

		dataset = new XYSeriesCollection();
		dataset.addSeries(average);
		dataset.addSeries(online);
		dataset.addSeries(elite);
		dataset.addSeries(offline);

		chart = ChartFactory.createXYLineChart("title", "xLabel", "yLabel", dataset, PlotOrientation.VERTICAL, true, true, false);
		chartPanel = new ChartPanel(chart);

		pnlCentral.add(lblLocale, "width 120, height 25");
		pnlCentral.add(cmbSelectLocale, "width 120, height 25, wrap");

		pnlCentral.add(lblLimLow, "width 120, height 25");
		pnlCentral.add(spiLow, "width 120, height 25");
		pnlCentral.add(lblIndividual, "width 80, height 25");
		pnlCentral.add(cmbIndividual, "growx, height 25, span 2, wrap");

		pnlCentral.add(lblLimUp, "width 120, height 25");
		pnlCentral.add(spiUp, "width 120, height 25");
		pnlCentral.add(lblCrossover, "width 80, height 25");
		pnlCentral.add(cmbCrossover, "growx, height 25, span 2, wrap");

		pnlCentral.add(lblChromosome, "width 120, height 25");
		pnlCentral.add(spiChromosome, "width 120, height 25");
		pnlCentral.add(lblMutation, "width 80, height 25");
		pnlCentral.add(cmbMutation, "growx, height 25, span 2, wrap");

		pnlCentral.add(lblPopulation, "width 120, height 25");
		pnlCentral.add(spiPopulation, "width 120, height 25");
		pnlCentral.add(lblSelection, "width 80, height 25");
		pnlCentral.add(cmbSelection, "growx, height 25, span 2");
		pnlCentral.add(lblAverageTitle, "width 70, height 25");
		pnlCentral.add(lblAverage, "width 200, height 25, wrap");

		pnlCentral.add(lblGenerations, "width 120, height 25");
		pnlCentral.add(spiGenerations, "width 120, height 25");
		pnlCentral.add(lblFitness, "width 80, height 25");
		pnlCentral.add(cmbFitness, "growx, height 25, span 2");
		pnlCentral.add(lblOnlineTitle, "growx, height 25");
		pnlCentral.add(lblOnline, "growx, height 25, wrap");

		pnlCentral.add(lblProbCrossover, "width 120, height 25");
		pnlCentral.add(txtProbCrossover, "width 120, height 25");
		pnlCentral.add(lblPathOutput, "width 80, height 25");
		pnlCentral.add(txtPathOutput, "width 280, height 25");
		pnlCentral.add(btnPathOutput, "width 20, height 25");
		pnlCentral.add(lblEliteTitle, "growx, height 25");
		pnlCentral.add(lblElite, "growx, height 25, wrap");

		pnlCentral.add(lblProbMutation, "width 120, height 25");
		pnlCentral.add(txtProbMutation, "width 120, height 25");
		pnlCentral.add(lblName, "width 80, height 25");
		pnlCentral.add(txtName, "growx, height 25, span 2");
		pnlCentral.add(lblOfflineTitle, "growx, height 25");
		pnlCentral.add(lblOffline, "growx, height 25, wrap");

		pnlCentral.add(chartPanel, "growx, span 7");

		// SOUTH
		pnlSouth = new JPanel();
		add(pnlSouth, BorderLayout.SOUTH);

		btnRun = new JButton();
		btnClose = new JButton();

		pnlSouth.add(btnRun);
		pnlSouth.add(btnClose);

		// ADD BUTTONS
		buttons.add(btnClose);
		buttons.add(btnPathOutput);
		buttons.add(btnRun);
	}

	public void addListener(CExperiment listener) {
		for (JButton button : buttons) {
			button.addActionListener(listener);
		}
		addWindowListener(listener);
		cmbSelectLocale.addItemListener(listener);
		txtName.addKeyListener(listener);
	}

	public JLabel getLblLocale() {
		return lblLocale;
	}

	public DefaultComboBoxModel<String> getCmbModelSelectLocale() {
		return cmbModelSelectLocale;
	}

	public JButton getBtnRun() {
		return btnRun;
	}

	public JSpinner getSpiLow() {
		return spiLow;
	}

	public JSpinner getSpiUp() {
		return spiUp;
	}

	public JLabel getLblChromosome() {
		return lblChromosome;
	}

	public JSpinner getSpiChromosome() {
		return spiChromosome;
	}

	public JLabel getLblPopulation() {
		return lblPopulation;
	}

	public JSpinner getSpiPopulation() {
		return spiPopulation;
	}

	public JLabel getLblGenerations() {
		return lblGenerations;
	}

	public JSpinner getSpiGenerations() {
		return spiGenerations;
	}

	public JLabel getLblProbCrossover() {
		return lblProbCrossover;
	}

	public JTextField getTxtProbCrossover() {
		return txtProbCrossover;
	}

	public JLabel getLblProbMutation() {
		return lblProbMutation;
	}

	public JTextField getTxtProbMutation() {
		return txtProbMutation;
	}

	public JButton getBtnClose() {
		return btnClose;
	}

	public JTextField getTxtPathOutput() {
		return txtPathOutput;
	}

	public JButton getBtnPathOutput() {
		return btnPathOutput;
	}

	public JLabel getLblPathOutput() {
		return lblPathOutput;
	}

	public JLabel getLblLimLow() {
		return lblLimLow;
	}

	public JLabel getLblLimUp() {
		return lblLimUp;
	}

	public JLabel getLblCrossover() {
		return lblCrossover;
	}

	public DefaultComboBoxModel<String> getCmbModelCrossover() {
		return cmbModelCrossover;
	}

	public JLabel getLblMutation() {
		return lblMutation;
	}

	public DefaultComboBoxModel<String> getCmbModelMutation() {
		return cmbModelMutation;
	}

	public JLabel getLblIndividual() {
		return lblIndividual;
	}

	public DefaultComboBoxModel<String> getCmbModelIndividual() {
		return cmbModelIndividual;
	}

	public JLabel getLblSelection() {
		return lblSelection;
	}

	public DefaultComboBoxModel<String> getCmbModelSelection() {
		return cmbModelSelection;
	}

	public JLabel getLblFitness() {
		return lblFitness;
	}

	public DefaultComboBoxModel<String> getCmbModelFitness() {
		return cmbModelFitness;
	}

	public JLabel getLblName() {
		return lblName;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public JFreeChart getChart() {
		return chart;
	}

	public void disable() {
		btnRun.setEnabled(false);
		btnPathOutput.setEnabled(false);
		spiLow.setEnabled(false);
		spiUp.setEnabled(false);
		spiChromosome.setEnabled(false);
		spiPopulation.setEnabled(false);
		spiGenerations.setEnabled(false);
		txtProbCrossover.setEnabled(false);
		txtProbMutation.setEnabled(false);
		txtName.setEnabled(false);
		txtPathOutput.setEnabled(false);
		cmbSelectLocale.setEnabled(false);
		cmbIndividual.setEnabled(false);
		cmbCrossover.setEnabled(false);
		cmbMutation.setEnabled(false);
		cmbSelection.setEnabled(false);
		cmbFitness.setEnabled(false);
	}

	public void enable() {
		btnRun.setEnabled(true);
		btnPathOutput.setEnabled(true);
		spiLow.setEnabled(true);
		spiUp.setEnabled(true);
		spiChromosome.setEnabled(true);
		spiPopulation.setEnabled(true);
		spiGenerations.setEnabled(true);
		txtProbCrossover.setEnabled(true);
		txtProbMutation.setEnabled(true);
		txtName.setEnabled(true);
		txtPathOutput.setEnabled(true);
		cmbSelectLocale.setEnabled(true);
		cmbIndividual.setEnabled(true);
		cmbCrossover.setEnabled(true);
		cmbMutation.setEnabled(true);
		cmbSelection.setEnabled(true);
		cmbFitness.setEnabled(true);
	}

	public XYSeries getOffline() {
		return offline;
	}

	public XYSeries getAverage() {
		return average;
	}

	public XYSeries getOnline() {
		return online;
	}

	public void resetXY() {
		average = new XYSeries("Average");
		offline = new XYSeries("Offline");
		online = new XYSeries("Online");
		elite = new XYSeries("Elite");

		dataset.removeAllSeries();
		dataset.addSeries(average);
		dataset.addSeries(online);
		dataset.addSeries(elite);
		dataset.addSeries(offline);
	}

	public JLabel getLblOffline() {
		return lblOffline;
	}

	public JLabel getLblOnline() {
		return lblOnline;
	}

	public JLabel getLblAverage() {
		return lblAverage;
	}

	public XYSeries getElite() {
		return elite;
	}

	public JLabel getLblElite() {
		return lblElite;
	}

}
