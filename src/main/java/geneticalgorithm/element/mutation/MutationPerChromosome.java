/**
 * Copyright (c) 2014 Saúl Piña <sauljabin@gmail.com>.
 * <p>
 * This file is part of GeneticAlgorithm.
 * <p>
 * GeneticAlgorithm is licensed under The MIT License.
 * For full copyright and license information please see the LICENSE file.
 */

package geneticalgorithm.element.mutation;

import geneticalgorithm.element.Individual;
import geneticalgorithm.element.Mutation;

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
