package ucla.ga.element.fitness;

import ucla.ga.element.Fitness;

public class Function2 extends Fitness {

	@Override
	public double getFitness(double... phenotype) {
		return 0;
	}

	@Override
	public double getObjetiveValue(double... phenotype) {
		double[] x = phenotype;
		int n = x.length;

		double sum = 0;

		for (int i = 0; i < n; i++) {
			sum += (-x[i] * Math.sin(Math.sqrt(Math.abs(x[i]))));
		}

		return sum;
	}
}
