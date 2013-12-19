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

package ai.ga.element.individual;

import ai.ga.element.Individual;
import ai.ga.util.HelperGA;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class IndividualFunction1 extends Individual {

	protected int n;

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public IndividualFunction1(double lowerLimit, double upperLimit, int size) {
		super(lowerLimit, upperLimit, size);
		n = 30;
		chromosome = "";
		for (int i = 0; i < n; i++) {
			chromosome += HelperGA.randomChromosome(size);
		}
	}

	public IndividualFunction1(String chromosome, double fitness, double selectionProb, double objetiveValue, double lowerLimit, double upperLimit, int size) {
		super(chromosome, fitness, selectionProb, objetiveValue, lowerLimit, upperLimit, size);
	}

	@Override
	public Individual copy() {
		IndividualFunction1 copy = new IndividualFunction1(chromosome, fitness, selectionProb, objetiveValue, lowerLimit, upperLimit, size);
		copy.setN(n);
		return copy;
	}

	@Override
	public double[] getPhenotype() {
		double[] x = new double[n];
		for (int i = 0; i < n; i++) {
			x[i] = HelperGA.convertChromosomeToReal(chromosome.substring(size * i, size * i + size), lowerLimit, upperLimit, size);
		}
		return x;
	}

}
