/**
 * Copyright (c) 2014 Saúl Piña <sauljabin@gmail.com>.
 * 
 * This file is part of GeneticAlgorithm.
 * 
 * GeneticAlgorithm is licensed under The MIT License.
 * For full copyright and license information please see the LICENSE file.
 */

package geneticalgorithm.element.crossover;

import geneticalgorithm.element.Crossover;
import geneticalgorithm.element.Individual;
import geneticalgorithm.util.HelperMath;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class CrossoverOnePoint extends Crossover {

	@Override
	public void crossover(Individual a, Individual b) {
		int chromosomeSize = a.getChromosome().length();
		int rand = HelperMath.random(1, a.getChromosome().length() - 1);
		String tempA1 = a.getChromosome().substring(0, rand);
		String tempA2 = a.getChromosome().substring(rand, chromosomeSize);
		String tempB1 = b.getChromosome().substring(0, rand);
		String tempB2 = b.getChromosome().substring(rand, chromosomeSize);
		a.setChromosome(tempB1 + tempA2);
		b.setChromosome(tempA1 + tempB2);
	}

}
