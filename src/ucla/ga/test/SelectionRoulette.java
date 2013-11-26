package ucla.ga.test;

import ucla.ga.interfaces.IIndividual;
import ucla.ga.interfaces.ISelection;
import ucla.ga.util.HelperMath;

public class SelectionRoulette implements ISelection {

	@Override
	public IIndividual selection(IIndividual[] population) {
		double sum = 0;
		double[] probs = new double[population.length];

		for (int j = 0; j < population.length; j++) {
			sum += population[j].getFitness();
		}

		for (int j = 0; j < population.length; j++) {
			probs[j] = (population[j].getFitness()) / sum;
		}

		double rand = HelperMath.random();

		double temp = probs[0];

		for (int j = 0; j < population.length - 1; j++) {
			if (rand <= temp) {
				return population[j];
			} else {
				temp += probs[j + 1];
			}
		}

		return population[probs.length - 1];
	}

}
