package ucla.ga.element.individual;

import ucla.ga.element.Individual;
import ucla.ga.util.HelperGA;

public class IndividualFunction1 extends Individual {

	private int n;

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public IndividualFunction1(double lowerLimit, double upperLimit, int size) {
		super(lowerLimit, upperLimit, size);
		n = 6;
		chromosome = "";
		for (int i = 0; i < n; i++) {
			chromosome += HelperGA.randomChromosome(size);
		}
	}

	public IndividualFunction1(String chromosome, double fitness, double selectionProb, double objetiveValue, double lowerLimit, double upperLimit, int size) {
		super(chromosome, fitness, selectionProb, objetiveValue, lowerLimit, upperLimit, size);
	}

	@Override
	public Individual copy() {
		return new IndividualFunction1(chromosome, fitness, selectionProb, objetiveValue, lowerLimit, upperLimit, size);
	}

	@Override
	public double[] getPhenotype() {
		double[] x = new double[n];
		for (int i = 0; i < n; i++) {
			x[i] = HelperGA.convertChromosomeToReal(chromosome.substring(size * i, size * i + size), lowerLimit, upperLimit, size);
		}
		return x;
	}

}
