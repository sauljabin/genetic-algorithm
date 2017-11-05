/**
 * Copyright (c) 2014 Saúl Piña <sauljabin@gmail.com>.
 * <p>
 * This file is part of GeneticAlgorithm.
 * <p>
 * GeneticAlgorithm is licensed under The MIT License.
 * For full copyright and license information please see the LICENSE file.
 */

package geneticalgorithm.element;

/**
 *
 * @author Saul Pina - sauljp07@gmail.com
 */
public abstract class Individual {

    protected String chromosome;
    protected double fitness;
    protected double selectionProb;
    protected double objetiveValue;
    protected double lowerLimit;
    protected double upperLimit;
    protected int size;

    public Individual(double lowerLimit, double upperLimit, int size) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.size = size;
    }

    public Individual(String chromosome, double fitness, double selectionProb, double objetiveValue, double lowerLimit, double upperLimit, int size) {
        this.chromosome = chromosome;
        this.fitness = fitness;
        this.selectionProb = selectionProb;
        this.objetiveValue = objetiveValue;
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.size = size;
    }

    public double getObjetiveValue() {
        return objetiveValue;
    }

    public void setObjetiveValue(double objetiveValue) {
        this.objetiveValue = objetiveValue;
    }

    public double getSelectionProb() {
        return selectionProb;
    }

    public void setSelectionProb(double selectionProb) {
        this.selectionProb = selectionProb;
    }

    public String getChromosome() {
        return chromosome;
    }

    public void setChromosome(String chromosome) {
        this.chromosome = chromosome;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(double lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public double getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(double upperLimit) {
        this.upperLimit = upperLimit;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("[class=%s;chromosome=%s;phenotype=%s;objetivevalue=%.15f;fitness=%.15f;selectionprob=%.15f;lowerlimit=%.3f;upperlimit=%.3f;size=%d]", this.getClass().getSimpleName(), chromosome, getPhenotype(), objetiveValue, fitness, selectionProb, lowerLimit, upperLimit, size);
    }

    ;

    public abstract Individual copy();

    public abstract double getPhenotype();

}
