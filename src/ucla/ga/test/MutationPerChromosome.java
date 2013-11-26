package ucla.ga.test;

import ucla.ga.interfaces.IIndividual;
import ucla.ga.interfaces.IMutation;

public class MutationPerChromosome implements IMutation {

	@Override
	public void mutation(double probability, IIndividual a) {
		StringBuilder temp = new StringBuilder(a.getChromosome());
		for (int i = 0; i < a.getChromosome().length(); i++) {
			if (Math.random() <= probability) {
				temp.setCharAt(i, temp.charAt(i) == '0' ? '1' : '0');
			}
		}
		a.setChromosome(temp.toString());
	}

}
