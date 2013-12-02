package ucla.ga.element.fitness;

import ucla.ga.element.Fitness;

public class Function1 extends Fitness {

	@Override
	public double getFitness(double... phenotype) {
		return 0;
	}

	@Override
	public double getObjetiveValue(double... phenotype) {
		double[] x = phenotype;
		int n = x.length;

		double sumj = 0;
		double sumi = 0;

		for (int i = 0; i < n; i++) {
			sumi = 0;
			for (int j = 0; j < i; j++) {
				sumi += x[j];
			}
			sumj += Math.pow(sumi, 2);
		}

		return sumj;
	}

}
