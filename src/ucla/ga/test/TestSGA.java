package ucla.ga.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import ucla.ga.element.GeneticAlgorithm;
import ucla.ga.element.Individual;
import ucla.ga.element.crossover.CrossoverOnePoint;
import ucla.ga.element.fitness.FitnessParable;
import ucla.ga.element.individual.*;
import ucla.ga.element.mutation.MutationPerChromosome;
import ucla.ga.element.selection.SelectionRoulette;
import ucla.ga.gui.view.VGraphic;
import ucla.ga.util.HelperDate;

public class TestSGA {

	public static void main(String[] args) throws IOException {
		Individual[] populationTemp = new Individual[10];

		for (int i = 0; i < populationTemp.length; i++) {
			populationTemp[i] = new IndividualReal(-50, 50, 10);
		}

		String day = HelperDate.nowFormat("yyyyMMdd");

		File file = new File("test/" + day);
		file.mkdir();

		String filesName = day + HelperDate.nowFormat("Hmmss");

		VGraphic vGraphic = new VGraphic("TEST: " + filesName);

		PrintWriter pw = new PrintWriter(new FileWriter(file.getPath() + "/result" + filesName + ".txt"), true);

		GeneticAlgorithm ag = new GeneticAlgorithm(new SelectionRoulette(), new MutationPerChromosome(), new CrossoverOnePoint(), new FitnessParable(), populationTemp, 100, .001, .5);
		ag.run();

		int i = 0;
		double onlinetemp = 0;
		double average = 0;
		double offlinetemp = 0;
		for (Individual[] population : ag.getGenerations()) {

			System.out.println("GENERATION: " + i);
			pw.println("GENERATION: " + i);

			double sum = 0;
			double probMax = 0;
			Individual indMax = null;
			for (Individual individual : population) {
				System.out.println(individual);
				pw.println(individual);
				sum += individual.getObjetiveValue();
				if (indMax == null) {
					indMax = individual;
					probMax = individual.getSelectionProb();
				} else if (individual.getSelectionProb() >= probMax) {
					indMax = individual;
					probMax = individual.getSelectionProb();
				}
			}

			average = sum / population.length;

			vGraphic.addPoint(i, average, (offlinetemp + indMax.getObjetiveValue()) / (i + 1), (onlinetemp + average) / (i + 1));
			onlinetemp = onlinetemp + average;
			offlinetemp = offlinetemp + indMax.getObjetiveValue();

			System.out.println(String.format("ONLINE: %.15f", onlinetemp / (i + 1)));
			System.out.println(String.format("OFFLINE: %.15f", offlinetemp / (i + 1)));
			System.out.println(String.format("AVERAGE: %.15f", average));

			pw.println(String.format("ONLINE: %.15f", onlinetemp / (i + 1)));
			pw.println(String.format("OFFLINE: %.15f", offlinetemp / (i + 1)));
			pw.println(String.format("AVERAGE: %.15f", average));

			System.out.println();
			pw.println();

			i++;
		}

		vGraphic.exportImage(file.getPath() + "/result" + filesName + ".png");
		pw.close();

	}

}
