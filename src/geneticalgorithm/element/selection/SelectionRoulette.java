/**
 * Copyright (c) 2014 Saúl Piña <sauljabin@gmail.com>.
 * 
 * This file is part of GeneticAlgorithm.
 * 
 * GeneticAlgorithm is licensed under The MIT License.
 * For full copyright and license information please see the LICENSE file.
 */

package geneticalgorithm.element.selection;

import geneticalgorithm.element.Individual;
import geneticalgorithm.element.Selection;
import geneticalgorithm.util.HelperMath;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class SelectionRoulette extends Selection {

	@Override
	public Individual selection(Individual[] population) {
		double sum = 0;
		double[] probs = new double[population.length];

		for (int j = 0; j < population.length; j++) {
			sum += population[j].getFitness();
		}

		for (int j = 0; j < population.length; j++) {
			probs[j] = (population[j].getFitness()) / sum;
			population[j].setSelectionProb(probs[j]);
		}

		double rand = HelperMath.random();

		double temp = probs[0];

		for (int j = 0; j < population.length - 1; j++) {
			if (rand <= temp) {
				return population[j];
			} else {
				temp += probs[j + 1];
			}
		}

		return population[probs.length - 1];
	}

}
