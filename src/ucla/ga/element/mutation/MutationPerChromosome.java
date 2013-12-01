package ucla.ga.element.mutation;

import ucla.ga.element.Individual;
import ucla.ga.element.Mutation;

public class MutationPerChromosome extends Mutation {

	@Override
	public void mutation(double probability, Individual a) {
		StringBuilder temp = new StringBuilder(a.getChromosome());
		for (int i = 0; i < a.getChromosome().length(); i++) {
			if (Math.random() <= probability) {
				temp.setCharAt(i, temp.charAt(i) == '0' ? '1' : '0');
			}
		}
		a.setChromosome(temp.toString());
	}

}
