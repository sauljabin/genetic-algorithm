package ucla.ga.element.fitness;

import ucla.ga.element.Fitness;

public class Function1 extends Fitness {

	private int n = 30;

	@Override
	public double getFitness(double... phenotype) {

		return 0;
	}

	@Override
	public double getObjetiveValue(double... phenotype) {
		double[] x = phenotype;

		double sumj = 0;
		double sumi = 0;

		for (int i = 1; i <= 30; i++) {
			sumi = 0;
			for (int j = 1; j <= i; j++) {
				sumi += x[j];
			}
			sumj += Math.pow(sumi, 2);
		}
		return sumj;
	}

}
