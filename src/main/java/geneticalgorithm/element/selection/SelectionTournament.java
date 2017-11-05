/**
 * Copyright (c) 2014 Saúl Piña <sauljabin@gmail.com>.
 * <p>
 * This file is part of GeneticAlgorithm.
 * <p>
 * GeneticAlgorithm is licensed under The MIT License.
 * For full copyright and license information please see the LICENSE file.
 */

package geneticalgorithm.element.selection;

import geneticalgorithm.element.Individual;
import geneticalgorithm.element.Selection;
import geneticalgorithm.util.HelperMath;

import java.util.ArrayList;
import java.util.List;

public class SelectionTournament extends Selection {

    @Override
    public Individual selection(Individual[] population) {

        int k = 5;// population.length / 2;
        if (k > population.length)
            k = population.length;

        List<Individual> tempList = new ArrayList<Individual>();

        for (int i = 0; i < k; ) {
            Individual select = population[HelperMath.random(0, population.length - 1)];
            if (tempList.contains(select))
                continue;
            tempList.add(select);
            i++;
        }

        Individual better = tempList.get(0);
        for (int i = 1; i < tempList.size(); i++) {
            if (tempList.get(i).getFitness() >= better.getFitness())
                better = tempList.get(i);
        }

        return better;
    }
}
