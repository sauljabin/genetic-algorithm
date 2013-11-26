package ucla.ga.test;

import ucla.ga.element.Individual;
import ucla.ga.interfaces.IIndividual;
import ucla.ga.util.HelperMath;

public class IndividualInteger extends Individual {

	public IndividualInteger(int a, int b) {
		int high = 0;
		if (Math.abs(a) >= Math.abs(b)) {
			high = a;
		} else {
			high = b;
		}
		chromosome = HelperMath.integerToBinaryString(HelperMath.random(a, b), HelperMath.integerToBinaryString(high).length());
	}

	public IndividualInteger() {

	}

	public IndividualInteger(String chromosome, double fitness) {
		super(chromosome, fitness);
	}

	@Override
	public IIndividual copy() {
		return new IndividualInteger(chromosome, fitness);
	}

	@Override
	public double getPhenotype() {
		return HelperMath.binaryStringToInteger(chromosome);
	}

	@Override
	public String toString() {
		return String.format("[chromosome=%s,phenotype=%.0f,fitness=%.15f,selectionprob=%.15f,objetivevalue=%.0f]", chromosome, getPhenotype(), fitness, selectionProb, objetiveValue);
	}

}
