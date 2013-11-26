package ucla.ga.element;

import java.util.Vector;

import ucla.ga.interfaces.ICrossover;
import ucla.ga.interfaces.IFitness;
import ucla.ga.interfaces.IIndividual;
import ucla.ga.interfaces.IMutation;
import ucla.ga.interfaces.ISelection;

public class GA {

	private ISelection selection;
	private IMutation mutation;
	private ICrossover crossover;
	private IFitness fitness;
	private Vector<IIndividual[]> generations;
	private IIndividual[] population;
	private int generationMax;
	private double mutationProb;
	private double crossoverProb;

	public GA(ISelection selection, IMutation mutation, ICrossover crossover, IFitness fitness, IIndividual[] population, int generationMax, double mutationProb, double crossoverProb) {
		this.selection = selection;
		this.mutation = mutation;
		this.crossover = crossover;
		this.fitness = fitness;
		this.population = population;
		this.generationMax = generationMax;
		this.mutationProb = mutationProb;
		this.crossoverProb = crossoverProb;
		generations = new Vector<IIndividual[]>();
	}

	public void run() {
		addPopulation();
		evaluatePopulation();
		for (int i = 0; i < generationMax; i++) {
			IIndividual[] populationTemp = new IIndividual[population.length];
			for (int j = 0; j < population.length; j += 2) {
				IIndividual a = selection.selection(population).copy();
				IIndividual b = selection.selection(population).copy();
				if (Math.random() <= crossoverProb) {
					crossover.crossover(a, b);
				}
				mutation.mutation(mutationProb, a);
				mutation.mutation(mutationProb, b);

				populationTemp[j] = a;
				populationTemp[j + 1] = b;
			}
			population = populationTemp;
			addPopulation();
			evaluatePopulation();
		}

	}

	private void evaluatePopulation() {
		for (int i = 0; i < population.length; i++) {
			IIndividual a = population[i];
			a.setFitness(fitness.evaluate(a.getPhenotype()));
			a.setObjetiveValue(fitness.objetive(a.getPhenotype()));
		}
	}

	private void addPopulation() {
		generations.add(population);
	}

	@Override
	public String toString() {
		return String.format("[population=%d;generations=%d,crossoverProb=%.2f,mutationProb=%.2f]", population.length, generations.size(), crossoverProb, mutationProb);
	}

	public ISelection getSelection() {
		return selection;
	}

	public void setSelection(ISelection selection) {
		this.selection = selection;
	}

	public IMutation getMutation() {
		return mutation;
	}

	public void setMutation(IMutation mutation) {
		this.mutation = mutation;
	}

	public ICrossover getCrossover() {
		return crossover;
	}

	public void setCrossover(ICrossover crossover) {
		this.crossover = crossover;
	}

	public IFitness getFitness() {
		return fitness;
	}

	public void setFitness(IFitness fitness) {
		this.fitness = fitness;
	}

	public Vector<IIndividual[]> getGenerations() {
		return generations;
	}

	public void setGenerations(Vector<IIndividual[]> generations) {
		this.generations = generations;
	}

	public IIndividual[] getPopulation() {
		return population;
	}

	public void setPopulation(IIndividual[] population) {
		this.population = population;
	}

	public int getGenerationMax() {
		return generationMax;
	}

	public void setGenerationMax(int generationMax) {
		this.generationMax = generationMax;
	}

	public double getMutationProb() {
		return mutationProb;
	}

	public void setMutationProb(double mutationProb) {
		this.mutationProb = mutationProb;
	}

	public double getCrossoverProb() {
		return crossoverProb;
	}

	public void setCrossoverProb(double crossoverProb) {
		this.crossoverProb = crossoverProb;
	}

}
