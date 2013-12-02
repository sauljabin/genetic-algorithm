package ucla.ga.element.individual;

import ucla.ga.element.Individual;

public class IndividualFunction2 extends IndividualFunction1 {

	public IndividualFunction2(double lowerLimit, double upperLimit, int size) {
		super(lowerLimit, upperLimit, size);
	}

	public IndividualFunction2(String chromosome, double fitness, double selectionProb, double objetiveValue, double lowerLimit, double upperLimit, int size) {
		super(chromosome, fitness, selectionProb, objetiveValue, lowerLimit, upperLimit, size);
	}
	
	@Override
	public Individual copy() {
		return new IndividualFunction2(chromosome, fitness, selectionProb, objetiveValue, lowerLimit, upperLimit, size);
	}

}
