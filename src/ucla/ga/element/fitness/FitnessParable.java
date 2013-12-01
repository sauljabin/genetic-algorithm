package ucla.ga.element.fitness;

import ucla.ga.element.Fitness;

public class FitnessParable extends Fitness {

	@Override
	public double getFitness(double... phenotype) {
		return 1 / (1 + getObjetiveValue(phenotype));
	}

	@Override
	public double getObjetiveValue(double... phenotype) {
		return Math.pow(phenotype[0], 2);
	}

}
