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

package ai.ga.element.selection;

import ai.ga.element.Individual;
import ai.ga.element.Selection;
import ai.ga.util.HelperMath;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class SelectionRoulette extends Selection {

	@Override
	public Individual selection(Individual[] population) {
		double sum = 0;
		double[] probs = new double[population.length];

		for (int j = 0; j < population.length; j++) {
			sum += population[j].getFitness();
		}

		for (int j = 0; j < population.length; j++) {
			probs[j] = (population[j].getFitness()) / sum;
			population[j].setSelectionProb(probs[j]);
		}

		double rand = HelperMath.random();

		double temp = probs[0];

		for (int j = 0; j < population.length - 1; j++) {
			if (rand <= temp) {
				return population[j];
			} else {
				temp += probs[j + 1];
			}
		}

		return population[probs.length - 1];
	}

}
