package ucla.ga.test;

import ucla.ga.interfaces.IFitness;

public class FitnessParable implements IFitness {

	@Override
	public double evaluate(double phenotype) {
		return 1 / (1 + objetive(phenotype));
	}

	@Override
	public double objetive(double phenotype) {
		return Math.pow(phenotype, 2);
	}

}
