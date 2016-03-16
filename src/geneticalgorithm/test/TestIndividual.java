/**
 * Copyright (c) 2014 Saúl Piña <sauljabin@gmail.com>.
 * 
 * This file is part of GeneticAlgorithm.
 * 
 * GeneticAlgorithm is licensed under The MIT License.
 * For full copyright and license information please see the LICENSE file.
 */

package geneticalgorithm.test;

import geneticalgorithm.element.individual.IndividualReal;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class TestIndividual {

	public static void main(String[] args) {
		IndividualReal i = new IndividualReal(-100, 100, 63);
		System.out.println(i);
	}

}
