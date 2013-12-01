package ucla.ga.element.individual;

import ucla.ga.element.Individual;
import ucla.ga.util.HelperMath;

public class IndividualInteger extends Individual {

	public IndividualInteger(double lowerLimit, double upperLimit, int size) {
		super(lowerLimit, upperLimit, size);
		chromosome = HelperMath.longToBinaryStringUnsigned(HelperMath.random(0l, HelperMath.pow(2l, size) - 1), size);
	}

	public IndividualInteger(String chromosome, double fitness, double selectionProb, double objetiveValue, double lowerLimit, double upperLimit, int size) {
		super(chromosome, fitness, selectionProb, objetiveValue, lowerLimit, upperLimit, size);
	}

	@Override
	public Individual copy() {
		return new IndividualInteger(chromosome, fitness, selectionProb, objetiveValue, lowerLimit, upperLimit, size);
	}

	@Override
	public double[] getPhenotype() {
		return new double[] { Math.round(HelperMath.binaryStringToLongUnsigned(chromosome) * (upperLimit - lowerLimit) / (HelperMath.pow(2l, size) - 1) + lowerLimit) };
	}

	public long getPhenotypeInteger() {
		return HelperMath.binaryStringToLongUnsigned(chromosome);
	}

	@Override
	public String toString() {
		return String.format("%s[phenotypeinteger=%d]", super.toString(), getPhenotypeInteger());
	}

}
