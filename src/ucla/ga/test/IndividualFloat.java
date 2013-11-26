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

	@Override
	public String toString() {
		return String.format("[chromosome=%s,phenotype=%.15f,fitness=%.15f,selectionprob=%.15f,objetivevalue=%.15f]", chromosome, getPhenotype(), fitness, selectionProb, objetiveValue);
	}

}
