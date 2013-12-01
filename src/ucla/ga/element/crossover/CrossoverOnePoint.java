package ucla.ga.element.crossover;

import ucla.ga.element.Crossover;
import ucla.ga.element.Individual;
import ucla.ga.util.HelperMath;

public class CrossoverOnePoint extends Crossover {

	@Override
	public void crossover(Individual a, Individual b) {
		int chromosomeSize = a.getChromosome().length();
		int rand = HelperMath.random(1, a.getChromosome().length() - 1);
		String tempA1 = a.getChromosome().substring(0, rand);
		String tempA2 = a.getChromosome().substring(rand, chromosomeSize);
		String tempB1 = b.getChromosome().substring(0, rand);
		String tempB2 = b.getChromosome().substring(rand, chromosomeSize);
		a.setChromosome(tempB1 + tempA2);
		b.setChromosome(tempA1 + tempB2);
	}

}
