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
public class Function1 extends Fitness {

	@Override
	public double getFitness(double... phenotype) {
		return 0;
	}

	@Override
	public double getObjetiveValue(double... phenotype) {
		double[] x = phenotype;
		int n = x.length;

		double sumj = 0;
		double sumi = 0;

		for (int i = 0; i < n; i++) {
			sumi = 0;
			for (int j = 0; j < i; j++) {
				sumi += x[j];
			}
			sumj += Math.pow(sumi, 2);
		}

		return sumj;
	}

}
