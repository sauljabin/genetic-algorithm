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

package ai.ga.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import ai.ga.element.GeneticAlgorithm;
import ai.ga.element.Individual;
import ai.ga.element.crossover.CrossoverOnePoint;
import ai.ga.element.fitness.FitnessParable;
import ai.ga.element.individual.*;
import ai.ga.element.mutation.MutationPerChromosome;
import ai.ga.element.selection.SelectionRoulette;
import ai.ga.gui.view.VGraphic;
import ai.ga.util.HelperDate;

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
