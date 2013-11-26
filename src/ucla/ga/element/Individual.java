package ucla.ga.element;

import ucla.ga.interfaces.IIndividual;

public abstract class Individual implements IIndividual {

	protected String chromosome;
	protected double fitness;
	protected double selectionProb;
	protected double objetiveValue;

	@Override
	public double getObjetiveValue() {
		return objetiveValue;
	}

	@Override
	public void setObjetiveValue(double objetiveValue) {
		this.objetiveValue = objetiveValue;
	}

	@Override
	public double getSelectionProb() {
		return selectionProb;
	}

	@Override
	public void setSelectionProb(double selectionProb) {
		this.selectionProb = selectionProb;
	}

	@Override
	public String getChromosome() {
		return chromosome;
	}

	@Override
	public void setChromosome(String chromosome) {
		this.chromosome = chromosome;
	}

	@Override
	public double getFitness() {
		return fitness;
	}

	@Override
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	public Individual(String chromosome, double fitness) {
		this.chromosome = chromosome;
		this.fitness = fitness;
	}

	public Individual() {

	}

	@Override
	public String toString() {
		return String.format("[chromosome=%s,phenotype=%f,fitness=%.2f,selectionprob=%f]", chromosome, getPhenotype(), fitness, selectionProb);
	}
}
