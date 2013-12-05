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

package ucla.ga.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import ucla.ga.util.HelperDate;
import ucla.ga.util.HelperImage;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class CExperiment implements ActionListener, WindowListener, ItemListener, KeyListener {

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
		vExperiment.getCmbModelSelectLocale().setSelectedItem(config.get("LOCALE"));
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

		vExperiment.getTxtPathOutput().setText(new File("").getAbsolutePath());
		String title = "GA-" + HelperDate.nowFormat("yyyy-MM-dd");
		vExperiment.getTxtName().setText(title);
		vExperiment.getChart().setTitle(title);
		vExperiment.setTitle(title);
	}

	private void loadLocale() {
		vExperiment.getLblLocale().setText(locale.get("lblLocale"));
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
		vExperiment.getLblCrossover().setText(locale.get("lblCrossover"));
		vExperiment.getLblMutation().setText(locale.get("lblMutation"));
		vExperiment.getLblIndividual().setText(locale.get("lblIndividual"));
		vExperiment.getLblSelection().setText(locale.get("lblSelection"));
		vExperiment.getLblFitness().setText(locale.get("lblFitness"));
		vExperiment.getLblName().setText(locale.get("lblName"));
		vExperiment.getChart().getXYPlot().getDomainAxis().setLabel(locale.get("xAxisLabel"));
		vExperiment.getChart().getXYPlot().getRangeAxis().setLabel(locale.get("yAxisLabel"));
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
				vExperiment.enable();
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
		String name = vExperiment.getTxtName().getText();
		Class<?> classIndividual = Class.forName("ucla.ga.element.individual." + vExperiment.getCmbModelIndividual().getSelectedItem().toString());
		Class<?> classCrossover = Class.forName("ucla.ga.element.crossover." + vExperiment.getCmbModelCrossover().getSelectedItem().toString());
		Class<?> classMutation = Class.forName("ucla.ga.element.mutation." + vExperiment.getCmbModelMutation().getSelectedItem().toString());
		Class<?> classSelection = Class.forName("ucla.ga.element.selection." + vExperiment.getCmbModelSelection().getSelectedItem().toString());
		Class<?> classFitness = Class.forName("ucla.ga.element.fitness." + vExperiment.getCmbModelFitness().getSelectedItem().toString());

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
		File file = new File(path);
		file.mkdir();
		PrintWriter prGraph = new PrintWriter(new FileWriter(filesName + "GRAPH.txt"), true);
		PrintWriter prPopul = new PrintWriter(new FileWriter(filesName + "PPLTN.txt"), true);
		PrintStream prConsl = System.out;

		// RUN
		vExperiment.disable();
		ag.run();
		vExperiment.resetXY();
		// RESULTS VAR
		double sumOnline = 0;
		double sumOffline = 0;
		double online = 0;
		double offline = 0;
		double average = 0;
		double sumAverage = 0;
		Individual elite = null;

		// RESULTS
		String header = String.format("NAME: %s\nTIME: %s\nRANGE: [%.2f;%.2f]\nGENES: %d\nPOPULATION: %d\nGENERATIONS: %d\nPROB. CROSSOVER: %f\nPROB. MUTATION: %f", name, HelperDate.nowFormat("yyyy-MM-dd H:mm:ss"), limLow, limUp, chromSize, populationSize, generations, probCrossover, probMutation);
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
			addPoint(i, average, offline, online);
		}

		exportImage(filesName + "IMAGE.png");
		prGraph.close();
		prPopul.close();
		vExperiment.enable();
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		String title = vExperiment.getTxtName().getText();
		vExperiment.setTitle(title);
		vExperiment.getChart().setTitle(title);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	public void exportImage(String path) throws IOException {
		HelperImage.writeImage(vExperiment.getChart().createBufferedImage(800, 600), path);
	}

	public void addPoint(int t, double vAverage, double vOffLine, double vOnLine) {
		vExperiment.getAverage().add(t, vAverage);
		vExperiment.getOffline().add(t, vOffLine);
		vExperiment.getOnline().add(t, vOnLine);
		vExperiment.getLblAverage().setText(String.format("%.15f", vAverage));
		vExperiment.getLblOffline().setText(String.format("%.15f", vOffLine));
		vExperiment.getLblOnline().setText(String.format("%.15f", vOnLine));
	}

}
