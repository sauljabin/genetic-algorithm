package ucla.ga.test;

import ucla.ga.interfaces.IFitness;

public class FitnessParable implements IFitness {

	@Override
	public double evaluate(double phenotype) {
		double den = 1. + objetive(phenotype);
		if (den == 0.)
			return 1;
		else
			return 1. / den;
	}

	@Override
	public double objetive(double phenotype) {
		return Math.pow(phenotype, 2);
	}

}
