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

package ucla.ga.element.fitness;

import ucla.ga.element.Fitness;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class Function3 extends Fitness {

	@Override
	public double getFitness(int populationSize, double populationObjetiveValue, double objetiveValue, double... phenotype) {
		return 10 - objetiveValue * populationSize / populationObjetiveValue;
	}

	@Override
	public double getObjetiveValue(double... phenotype) {
		double[] x = phenotype;
		return 4 * Math.pow(x[0], 2) - 21 / 10 * Math.pow(x[0], 4) + 1 / 3 * Math.pow(x[0], 6) + x[0] * x[1] - 4 * Math.pow(x[1], 2) + 4 * Math.pow(x[1], 4);
	}

}
