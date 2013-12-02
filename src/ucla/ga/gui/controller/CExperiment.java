package ucla.ga.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import ucla.ga.app.Config;
import ucla.ga.app.Locale;
import ucla.ga.element.Crossover;
import ucla.ga.element.Fitness;
import ucla.ga.element.GeneticAlgorithm;
import ucla.ga.element.Individual;
import ucla.ga.element.Mutation;
import ucla.ga.element.Selection;
import ucla.ga.gui.view.VExperiment;
import ucla.ga.gui.view.VGraphic;
import ucla.ga.util.HelperDate;

public class CExperiment implements ActionListener, WindowListener, ItemListener {

	private Locale locale;
	private Config config;
	private VExperiment vExperiment;
	private String pathResource;
	private String pathLocale;

	public CExperiment() throws FileNotFoundException, IOException {
		pathResource = "resource/";
		pathLocale = "resource/locale/";

		config = new Config(pathResource);
		config.load();

		locale = new Locale(pathLocale);
		locale.load(config.get("LOCALE"));

		vExperiment = new VExperiment();
		initView();
		loadLocale();
		vExperiment.setVisible(true);
	}

	private void initView() {
		for (String string : locale.list()) {
			vExperiment.getCmbModelSelectLocale().addElement(string);
		}
		vExperiment.addListener(this);

		vExperiment.getCmbModelIndividual().addElement("IndividualReal");
		vExperiment.getCmbModelIndividual().addElement("IndividualInteger");
		vExperiment.getCmbModelIndividual().addElement("IndividualFunction1");
		vExperiment.getCmbModelIndividual().addElement("IndividualFunction2");
		vExperiment.getCmbModelIndividual().addElement("IndividualFunction3");

		vExperiment.getCmbModelCrossover().addElement("CrossoverOnePoint");

		vExperiment.getCmbModelFitness().addElement("FitnessParable");
		vExperiment.getCmbModelFitness().addElement("Function1");
		vExperiment.getCmbModelFitness().addElement("Function2");
		vExperiment.getCmbModelFitness().addElement("Function3");

		vExperiment.getCmbModelMutation().addElement("MutationPerChromosome");

		vExperiment.getCmbModelSelection().addElement("SelectionRoulette");
	}

	private void loadLocale() {
		vExperiment.getLblLocale().setText(locale.get("lblLocale"));
		vExperiment.getCmbModelSelectLocale().setSelectedItem(config.get("LOCALE"));
		vExperiment.getBtnRun().setText(locale.get("btnRun"));
		vExperiment.getBtnClose().setText(locale.get("btnClose"));
		vExperiment.getLblLimLow().setText(locale.get("lblLimLow"));
		vExperiment.getLblLimUp().setText(locale.get("lblLimUp"));
		vExperiment.getLblChromosome().setText(locale.get("lblChromosome"));
		vExperiment.getLblPopulation().setText(locale.get("lblPolulation"));
		vExperiment.getLblGenerations().setText(locale.get("lblGenerations"));
		vExperiment.getLblProbCrossover().setText(locale.get("lblProbCrossover"));
		vExperiment.getLblProbMutation().setText(locale.get("lblProbMutation"));
		vExperiment.getLblPathOutput().setText(locale.get("lblPathOutput"));
		vExperiment.getTxtPathOutput().setText(new File("").getAbsolutePath());
		vExperiment.getLblCrossover().setText(locale.get("lblCrossover"));
		vExperiment.getLblMutation().setText(locale.get("lblMutation"));
		vExperiment.getLblIndividual().setText(locale.get("lblIndividual"));
		vExperiment.getLblSelection().setText(locale.get("lblSelection"));
		vExperiment.getLblFitness().setText(locale.get("lblFitness"));
	}

	public void close() {
		vExperiment.dispose();
		System.exit(0);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {

	}

	@Override
	public void windowClosed(WindowEvent arg0) {

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		close();
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {

	}

	@Override
	public void windowIconified(WindowEvent arg0) {

	}

	@Override
	public void windowOpened(WindowEvent arg0) {

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		try {
			String loc = vExperiment.getCmbModelSelectLocale().getSelectedItem().toString();
			locale.load(loc);
			config.set("LOCALE", loc);
			loadLocale();
			config.save();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vExperiment.getBtnClose())) {
			close();
		} else if (e.getSource().equals(vExperiment.getBtnPathOutput())) {
			JFileChooser fileChooser = new JFileChooser(new File(vExperiment.getTxtPathOutput().getText()));
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooser.showOpenDialog(vExperiment);
			if (fileChooser.getSelectedFile() != null) {
				vExperiment.getTxtPathOutput().setText(fileChooser.getSelectedFile().getAbsolutePath());
			}
		} else if (e.getSource().equals(vExperiment.getBtnRun())) {
			try {
				run();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
				vExperiment.setEnabled(true);
			}
		}
	}

	private void run() throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		// GET VAR
		int populationSize = (int) vExperiment.getSpiPopulation().getValue();
		int chromSize = (int) vExperiment.getSpiChromosome().getValue();
		int generations = (int) vExperiment.getSpiGenerations().getValue();
		double limLow = (double) vExperiment.getSpiLow().getValue();
		double limUp = (double) vExperiment.getSpiUp().getValue();
		double probMutation = (double) vExperiment.getSpiProbMutation().getValue();
		double probCrossover = (double) vExperiment.getSpiProbCrossover().getValue();
		String path = vExperiment.getTxtPathOutput().getText() + "/RESULTS-" + HelperDate.nowFormat("yyyyMMdd");
		String time = HelperDate.nowFormat("yyyyMMddHmmss");
		String filesName = path + "/" + time;
		Class<?> classIndividual = Class.forName("ucla.ga.element.individual" + "." + vExperiment.getCmbModelIndividual().getSelectedItem().toString());
		Class<?> classCrossover = Class.forName("ucla.ga.element.crossover" + "." + vExperiment.getCmbModelCrossover().getSelectedItem().toString());
		Class<?> classMutation = Class.forName("ucla.ga.element.mutation" + "." + vExperiment.getCmbModelMutation().getSelectedItem().toString());
		Class<?> classSelection = Class.forName("ucla.ga.element.selection" + "." + vExperiment.getCmbModelSelection().getSelectedItem().toString());
		Class<?> classFitness = Class.forName("ucla.ga.element.fitness" + "." + vExperiment.getCmbModelFitness().getSelectedItem().toString());

		// CREATE OBJECTS
		Selection selection = (Selection) classSelection.newInstance();
		Crossover crossover = (Crossover) classCrossover.newInstance();
		Mutation mutation = (Mutation) classMutation.newInstance();
		Fitness fitness = (Fitness) classFitness.newInstance();
		Individual[] firstPopulation = new Individual[populationSize];
		Constructor<?> constructorIndividual = classIndividual.getDeclaredConstructor(double.class, double.class, int.class);
		for (int i = 0; i < firstPopulation.length; i++) {
			firstPopulation[i] = (Individual) constructorIndividual.newInstance(limLow, limUp, chromSize);
		}
		GeneticAlgorithm ag = new GeneticAlgorithm(selection, mutation, crossover, fitness, firstPopulation, generations, probMutation, probCrossover);
		VGraphic vGraphic = new VGraphic("TEST: " + HelperDate.nowFormat("yyyyMMddHmmss"));
		File file = new File(path);
		file.mkdir();
		PrintWriter prGraph = new PrintWriter(new FileWriter(filesName + "GRAPH.txt"), true);
		PrintWriter prPopul = new PrintWriter(new FileWriter(filesName + "PPLTN.txt"), true);
		PrintStream prConsl = System.out;

		// RUN
		vExperiment.setEnabled(false);
		ag.run();

		// RESULTS
		vGraphic.setVisible(true);

		// RESULTS VAR
		double sumOnline = 0;
		double sumOffline = 0;
		double online = 0;
		double offline = 0;
		double average = 0;
		double sumAverage = 0;
		Individual elite = null;

		String header = String.format("TIME: %s\nRANGE: [%.2f;%.2f]\nGENES: %d\nPOPULATION: %d\nGENERATIONS: %d\nPROB. CROSSOVER: %f\nPROB. MUTATION: %f", HelperDate.nowFormat("yyyy-MM-dd H:mm:ss"), limLow, limUp, chromSize, populationSize, generations, probCrossover, probMutation);

		header += String.format("\nINDIVIDUAL: %s\nCROSSOVER: %s\nMUTATION: %s\nSELECTION: %s\nFITNESS: %s", classIndividual.getSimpleName(), classCrossover.getSimpleName(), classMutation.getSimpleName(), classSelection.getSimpleName(), classFitness.getSimpleName());

		prConsl.println(header);
		prGraph.println(header);
		prPopul.println(header);

		prGraph.println("\nGENERATION\tAVERAGE\tOFFLINE\tONLINE\tELITE");

		for (int i = 1; i <= ag.getGenerations().size(); i++) {

			prConsl.println("\nGENERATION: " + i);
			prPopul.println("\nGENERATION: " + i);

			Individual[] population = ag.getGenerations().elementAt(i - 1);
			sumAverage = 0;
			elite = null;

			for (int j = 0; j < population.length; j++) {
				Individual individual = population[j];
				sumAverage += individual.getObjetiveValue();
				prPopul.println(individual);
				prConsl.println(individual);
				if (elite == null) {
					elite = individual;
				} else if (individual.getSelectionProb() > elite.getSelectionProb()) {
					elite = individual;
				}
			}

			average = sumAverage / population.length;
			sumOnline = sumOnline + average;
			sumOffline = sumOffline + elite.getObjetiveValue();
			online = sumOnline / i;
			offline = sumOffline / i;

			prConsl.println(String.format("AVERAGE: %.15f; OFFLINE: %.15f; ONLINE: %.15f; ELITE: %.15f", average, offline, online, elite.getSelectionProb()));
			prPopul.println(String.format("AVERAGE: %.15f; OFFLINE: %.15f; ONLINE: %.15f; ELITE: %.15f", average, offline, online, elite.getSelectionProb()));
			prGraph.println(String.format("%d\t%.15f\t%.15f\t%.15f\t%.15f", i, average, offline, online, elite.getSelectionProb()));
			vGraphic.addPoint(i, average, offline, online);
		}

		vGraphic.exportImage(filesName + "IMAGE.png");
		prGraph.close();
		prPopul.close();
		vExperiment.setEnabled(true);
	}

}
