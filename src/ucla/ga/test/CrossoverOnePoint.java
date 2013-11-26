package ucla.ga.test;

import ucla.ga.interfaces.ICrossover;
import ucla.ga.interfaces.IIndividual;
import ucla.ga.util.HelperMath;

public class CrossoverOnePoint implements ICrossover {

	@Override
	public void crossover(IIndividual a, IIndividual b) {
		int chromosomeSize =  a.getChromosome().length();		
		int rand = HelperMath.random(1, a.getChromosome().length() - 1);
		String tempA1 = a.getChromosome().substring(0, rand);
		String tempA2 = a.getChromosome().substring(rand, chromosomeSize);
		String tempB1 = b.getChromosome().substring(0, rand);
		String tempB2 = b.getChromosome().substring(rand, chromosomeSize);
		a.setChromosome(tempB1 + tempA2);
		b.setChromosome(tempA1 + tempB2);
	}

}
