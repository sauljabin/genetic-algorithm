/**
 * 
 * TestGeneticAlgorithm.java
 * 
 * Copyright (c) 2014, Saúl Piña <sauljabin@gmail.com>.
 * 
 * This file is part of GeneticAlgorithm.
 * 
 * GeneticAlgorithm is licensed under The MIT License.
 * For full copyright and license information please see the LICENSE.txt file.
 *
 */

package geneticalgorithm.test;

import geneticalgorithm.element.GeneticAlgorithm;
import geneticalgorithm.element.Individual;
import geneticalgorithm.element.crossover.CrossoverOnePoint;
import geneticalgorithm.element.fitness.FitnessParable;
import geneticalgorithm.element.individual.*;
import geneticalgorithm.element.mutation.MutationPerChromosome;
import geneticalgorithm.element.selection.SelectionRoulette;
import geneticalgorithm.gui.view.VGraphic;
import geneticalgorithm.util.HelperDate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class TestGeneticAlgorithm {

	public static void main(String[] args) throws IOException {
		Individual[] populationTemp = new Individual[10];

		for (int i = 0; i < populationTemp.length; i++) {
			populationTemp[i] = new IndividualReal(-50, 50, 10);
		}

		String day = HelperDate.nowFormat("yyyyMMdd");

		File file = new File("RESULTS-TEST-" + day);
		file.mkdir();

		String filesName = day + HelperDate.nowFormat("Hmmss");

		VGraphic vGraphic = new VGraphic("TEST: " + filesName, "Generations", "Values");
		vGraphic.setVisible(true);
		PrintWriter pw = new PrintWriter(new FileWriter(file.getPath() + "/" + filesName + ".txt"), true);

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

		vGraphic.exportImage(file.getPath() + "/" + filesName + ".png");
		pw.close();

	}

}
