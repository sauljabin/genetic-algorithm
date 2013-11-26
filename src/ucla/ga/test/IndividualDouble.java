package ucla.ga.test;

import ucla.ga.element.Individual;
import ucla.ga.interfaces.IIndividual;
import ucla.ga.util.HelperMath;

public class IndividualDouble extends Individual {

	public IndividualDouble(double a, double b) {
		chromosome = HelperMath.doubleToBinaryString(HelperMath.random(a, b));
	}

	public IndividualDouble(String chromosome, double fitness) {
		super(chromosome, fitness);
	}

	@Override
	public IIndividual copy() {
		return new IndividualDouble(chromosome, fitness);
	}

	@Override
	public double getPhenotype() {
		return HelperMath.binaryStringToDouble(chromosome);
	}
	

	@Override
	public String toString() {
		return String.format("[chromosome=%s,phenotype=%.15f,fitness=%.15f,selectionprob=%.15f,objetivevalue=%.15f]", chromosome, getPhenotype(), fitness, selectionProb, objetiveValue);
	}

}
