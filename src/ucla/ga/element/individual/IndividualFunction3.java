package ucla.ga.element.individual;

import ucla.ga.element.Individual;
import ucla.ga.util.HelperGA;

public class IndividualFunction3 extends Individual {

	public IndividualFunction3(double lowerLimit, double upperLimit, int size) {
		super(lowerLimit, upperLimit, size);
		chromosome = HelperGA.randomChromosome(size) + HelperGA.randomChromosome(size);
	}

	public IndividualFunction3(String chromosome, double fitness, double selectionProb, double objetiveValue, double lowerLimit, double upperLimit, int size) {
		super(chromosome, fitness, selectionProb, objetiveValue, lowerLimit, upperLimit, size);
	}

	@Override
	public Individual copy() {
		return new IndividualFunction3(chromosome, fitness, selectionProb, objetiveValue, lowerLimit, upperLimit, size);
	}

	@Override
	public double[] getPhenotype() {
		return new double[] { HelperGA.convertChromosomeToReal(chromosome.substring(0, size), lowerLimit, upperLimit, size), HelperGA.convertChromosomeToReal(chromosome.substring(size, size * 2), lowerLimit, upperLimit, size) };
	}

}
