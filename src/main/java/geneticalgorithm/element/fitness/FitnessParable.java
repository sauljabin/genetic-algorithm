/**
 * Copyright (c) 2014 Saúl Piña <sauljabin@gmail.com>.
 * <p>
 * This file is part of GeneticAlgorithm.
 * <p>
 * GeneticAlgorithm is licensed under The MIT License.
 * For full copyright and license information please see the LICENSE file.
 */

package geneticalgorithm.element.fitness;

import geneticalgorithm.element.Fitness;

public class FitnessParable extends Fitness {

    @Override
    public double getFitness(double objetiveValue) {
        return 1. / (1. + objetiveValue);
    }

    @Override
    public double getObjetiveValue(double phenotype) {
        return Math.pow(phenotype, 2);
    }

}
