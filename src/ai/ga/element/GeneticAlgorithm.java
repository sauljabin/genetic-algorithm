/**
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *  
 */

package ai.ga.element;

import java.util.Vector;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class GeneticAlgorithm {

	private Selection selection;
	private Mutation mutation;
	private Crossover crossover;
	private Fitness fitness;
	private Vector<Individual[]> generations;
	private Individual[] population;
	private int generationMax;
	private double mutationProb;
	private double crossoverProb;

	public GeneticAlgorithm(Selection selection, Mutation mutation, Crossover crossover, Fitness fitness, Individual[] population, int generationMax, double mutationProb, double crossoverProb) {
		this.selection = selection;
		this.mutation = mutation;
		this.crossover = crossover;
		this.fitness = fitness;
		this.population = population;
		this.generationMax = generationMax;
		this.mutationProb = mutationProb;
		this.crossoverProb = crossoverProb;
		generations = new Vector<Individual[]>();
	}

	public void run() {
		addPopulation();
		evaluatePopulation();
		for (int i = 0; i < generationMax; i++) {
			Individual[] populationTemp = new Individual[population.length];
			for (int j = 0; j < population.length; j += 2) {
				Individual a = selection.selection(population).copy();
				Individual b = selection.selection(population).copy();
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
		double populationObjetiveValue = 0;

		for (int i = 0; i < population.length; i++) {
			Individual a = population[i];
			double f = fitness.getObjetiveValue(a.getPhenotype());
			a.setObjetiveValue(f);
			populationObjetiveValue += f;
		}

		for (int i = 0; i < population.length; i++) {
			Individual a = population[i];
			a.setFitness(fitness.getFitness(population.length, populationObjetiveValue, a.getObjetiveValue(), a.getPhenotype()));
		}
	}

	private void addPopulation() {
		generations.add(population);
	}

	@Override
	public String toString() {
		return String.format("[population=%d;generations=%d;crossoverprob=%.2f;mutationprob=%.2f]", population.length, generations.size(), crossoverProb, mutationProb);
	}

	public Selection getSelection() {
		return selection;
	}

	public void setSelection(Selection selection) {
		this.selection = selection;
	}

	public Mutation getMutation() {
		return mutation;
	}

	public void setMutation(Mutation mutation) {
		this.mutation = mutation;
	}

	public Crossover getCrossover() {
		return crossover;
	}

	public void setCrossover(Crossover crossover) {
		this.crossover = crossover;
	}

	public Fitness getFitness() {
		return fitness;
	}

	public void setFitness(Fitness fitness) {
		this.fitness = fitness;
	}

	public Vector<Individual[]> getGenerations() {
		return generations;
	}

	public void setGenerations(Vector<Individual[]> generations) {
		this.generations = generations;
	}

	public Individual[] getPopulation() {
		return population;
	}

	public void setPopulation(Individual[] population) {
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
