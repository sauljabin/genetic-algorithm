/**
 * 
 * FitnessParable.java
 * 
 * Copyright (c) 2014, Saúl Piña <sauljabin@gmail.com>.
 * 
 * This file is part of GeneticAlgorithm.
 * 
 * GeneticAlgorithm is licensed under The MIT License.
 * For full copyright and license information please see the LICENSE.txt file.
 *
 */

package geneticalgorithm.element.fitness;

import geneticalgorithm.element.Fitness;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class FitnessParable extends Fitness {

	@Override
	public double getFitness(double objetiveValue) {
		return 1. / (1. + objetiveValue);
	}

	@Override
	public double getObjetiveValue(double phenotype) {
		return Math.pow(phenotype, 2);
	}

}
