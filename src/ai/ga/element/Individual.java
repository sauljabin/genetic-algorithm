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

	@Override
	public String toString() {
		String phenotype = "";
		double[] x = getPhenotype();
		for (int i = 0; i < x.length; i++) {
			phenotype += String.format("%.15f", x[i]);
			if (i != x.length - 1)
				phenotype += "|";
		}
		return String.format("[class=%s;chromosome=%s;phenotype=(%s);objetivevalue=%.15f;fitness=%.15f;selectionprob=%.15f;lowerlimit=%.3f;upperlimit=%.3f;size=%d]", this.getClass().getSimpleName(), chromosome, phenotype, objetiveValue, fitness, selectionProb, lowerLimit, upperLimit, size);
	};

	public abstract Individual copy();

	public abstract double[] getPhenotype();

}
