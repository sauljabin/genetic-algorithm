package ucla.ga.element.individual;

import ucla.ga.element.Individual;

public class IndividualFuction1 extends Individual {

	public IndividualFuction1(double lowerLimit, double upperLimit, int size) {
		super(lowerLimit, upperLimit, size);
		
	}

	public IndividualFuction1(String chromosome, double fitness, double selectionProb, double objetiveValue, double lowerLimit, double upperLimit, int size) {
		super(chromosome, fitness, selectionProb, objetiveValue, lowerLimit, upperLimit, size);
	}

	@Override
	public Individual copy() {
		return new IndividualFuction1(chromosome, fitness, selectionProb, objetiveValue, lowerLimit, upperLimit, size);
	}

	@Override
	public double[] getPhenotype() {
		return null;
	}

}
