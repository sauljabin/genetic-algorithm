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

import ucla.ga.gui.controller.CExperiment;
import net.miginfocom.swing.MigLayout;

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
	private JSpinner spiProbCrossover;
	private JLabel lblProbMutation;
	private JSpinner spiProbMutation;
	private JPanel pnlSouth;
	private JButton btnClose;
	private JTextField txtPathOutput;
	private JButton btnPathOutput;
	private JLabel lblPathOutput;
	private JPanel pnlNorth;
	private JPanel pnlEast;
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

	public VExperiment() {
		setLayout(new BorderLayout());
		setSize(720, 350);
		setTitle("GENETIC ALGORITHM - SAUL PIÑA");
		setResizable(false);
		setLocationRelativeTo(this);
		buttons = new ArrayList<JButton>();

		pnlCentral = new JPanel();
		pnlCentral.setLayout(new MigLayout());
		add(pnlCentral, BorderLayout.CENTER);

		pnlNorth = new JPanel();
		pnlNorth.setLayout(new MigLayout());
		add(pnlNorth, BorderLayout.NORTH);

		lblLocale = new JLabel();
		cmbModelSelectLocale = new DefaultComboBoxModel<String>();
		cmbSelectLocale = new JComboBox<String>(cmbModelSelectLocale);

		pnlNorth.add(lblLocale, "width 100, height 25");
		pnlNorth.add(cmbSelectLocale, "width 100, height 25, wrap 20");

		lblLimLow = new JLabel();
		lblLimUp = new JLabel();
		spiLow = new JSpinner();
		spiLow.setModel(new SpinnerNumberModel(-10., -100000., 100000., .5));
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
		spiProbCrossover = new JSpinner();
		spiProbCrossover.setModel(new SpinnerNumberModel(.5, 0., 1., .01));

		lblProbMutation = new JLabel();
		spiProbMutation = new JSpinner();
		spiProbMutation.setModel(new SpinnerNumberModel(.001, 0., 1., .001));

		pnlSouth = new JPanel();
		add(pnlSouth, BorderLayout.SOUTH);
		btnRun = new JButton();
		btnClose = new JButton();
		pnlSouth.add(btnRun);
		pnlSouth.add(btnClose);

		pnlCentral.add(lblLimLow, "width 120, height 25");
		pnlCentral.add(spiLow, "width 120, height 25, wrap");
		pnlCentral.add(lblLimUp, "width 120, height 25");
		pnlCentral.add(spiUp, "width 120, height 25, wrap");
		pnlCentral.add(lblChromosome, "width 120, height 25");
		pnlCentral.add(spiChromosome, "width 120, height 25, wrap");
		pnlCentral.add(lblPopulation, "width 120, height 25");
		pnlCentral.add(spiPopulation, "width 120, height 25, wrap");
		pnlCentral.add(lblGenerations, "width 120, height 25");
		pnlCentral.add(spiGenerations, "width 120, height 25, wrap");
		pnlCentral.add(lblProbCrossover, "width 120, height 25");
		pnlCentral.add(spiProbCrossover, "width 120, height 25, wrap");
		pnlCentral.add(lblProbMutation, "width 120, height 25");
		pnlCentral.add(spiProbMutation, "width 120, height 25, wrap");

		pnlEast = new JPanel();
		pnlEast.setLayout(new MigLayout());
		add(pnlEast, BorderLayout.EAST);

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

		pnlEast.add(lblIndividual, "width 80, height 25");
		pnlEast.add(cmbIndividual, "width 280, height 25, wrap");

		pnlEast.add(lblCrossover, "width 80, height 25");
		pnlEast.add(cmbCrossover, "width 280, height 25, wrap");

		pnlEast.add(lblMutation, "width 80, height 25");
		pnlEast.add(cmbMutation, "width 280, height 25, wrap");

		pnlEast.add(lblSelection, "width 80, height 25");
		pnlEast.add(cmbSelection, "width 280, height 25, wrap");

		pnlEast.add(lblFitness, "width 80, height 25");
		pnlEast.add(cmbFitness, "width 280, height 25, wrap");

		pnlEast.add(lblPathOutput, "width 80, height 25");
		pnlEast.add(txtPathOutput, "width 280, height 25");
		pnlEast.add(btnPathOutput, "width 20, height 25, wrap");

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

	public JSpinner getSpiProbCrossover() {
		return spiProbCrossover;
	}

	public JLabel getLblProbMutation() {
		return lblProbMutation;
	}

	public JSpinner getSpiProbMutation() {
		return spiProbMutation;
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

}
