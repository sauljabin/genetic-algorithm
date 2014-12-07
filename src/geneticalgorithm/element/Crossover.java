/**
 * 
 * Crossover.java
 * 
 * Copyright (c) 2014, Saúl Piña <sauljabin@gmail.com>.
 * 
 * This file is part of GeneticAlgorithm.
 * 
 * GeneticAlgorithm is licensed under The MIT License.
 * For full copyright and license information please see the LICENSE.txt file.
 *
 */

package geneticalgorithm.element;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public abstract class Crossover {
	public abstract void crossover(Individual a, Individual b);
}