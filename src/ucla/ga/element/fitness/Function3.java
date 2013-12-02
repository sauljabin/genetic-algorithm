package ucla.ga.element.fitness;

import ucla.ga.element.Fitness;

public class Function3 extends Fitness {

	@Override
	public double getFitness(double... phenotype) {
		return 0;
	}

	@Override
	public double getObjetiveValue(double... phenotype) {
		double[] x = phenotype;
		return 4 * Math.pow(x[0], 2) - 21 / 10 * Math.pow(x[0], 4) + 1 / 3 * Math.pow(x[0], 6) + x[0] * x[1] - 4 * Math.pow(x[1], 2) + 4 * Math.pow(x[1], 4);
	}

}
