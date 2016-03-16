/**
 * Copyright (c) 2014 Saúl Piña <sauljabin@gmail.com>.
 * 
 * This file is part of GeneticAlgorithm.
 * 
 * GeneticAlgorithm is licensed under The MIT License.
 * For full copyright and license information please see the LICENSE file.
 */

package geneticalgorithm.element.individual;

import geneticalgorithm.element.Individual;
import geneticalgorithm.util.HelperGA;
import geneticalgorithm.util.HelperMath;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class IndividualInteger extends Individual {

	public IndividualInteger(double lowerLimit, double upperLimit, int size) {
		super(lowerLimit, upperLimit, size);
		chromosome = HelperGA.randomChromosome(size);
	}

	public IndividualInteger(String chromosome, double fitness, double selectionProb, double objetiveValue, double lowerLimit, double upperLimit, int size) {
		super(chromosome, fitness, selectionProb, objetiveValue, lowerLimit, upperLimit, size);
	}

	@Override
	public Individual copy() {
		return new IndividualInteger(chromosome, fitness, selectionProb, objetiveValue, lowerLimit, upperLimit, size);
	}

	@Override
	public double getPhenotype() {
		return Math.round(HelperGA.convertChromosomeToReal(chromosome, lowerLimit, upperLimit, size));
	}

	public long getPhenotypeInteger() {
		return HelperMath.binaryStringToLongUnsigned(chromosome);
	}

	@Override
	public String toString() {
		return String.format("%s[phenotypeinteger=%d]", super.toString(), getPhenotypeInteger());
	}

}
