package ucla.ga.test;

import ucla.ga.element.Individual;
import ucla.ga.interfaces.IIndividual;
import ucla.ga.util.HelperMath;

public class IndividualFloat extends Individual {

	public IndividualFloat(float a, float b) {
		chromosome = HelperMath.floatToBinaryString(HelperMath.random(a, b));
	}

	public IndividualFloat(String chromosome, double fitness) {
		super(chromosome, fitness);
	}

	@Override
	public IIndividual copy() {
		return new IndividualFloat(chromosome, fitness);
	}

	@Override
	public double getPhenotype() {
		return HelperMath.binaryStringToFloat(chromosome);
	}

}
