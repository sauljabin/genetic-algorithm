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

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class IndividualFunction2 extends IndividualFunction1 {

	public IndividualFunction2(double lowerLimit, double upperLimit, int size) {
		super(lowerLimit, upperLimit, size);
	}

	public IndividualFunction2(String chromosome, double fitness, double selectionProb, double objetiveValue, double lowerLimit, double upperLimit, int size) {
		super(chromosome, fitness, selectionProb, objetiveValue, lowerLimit, upperLimit, size);
	}
	
	@Override
	public Individual copy() {
		IndividualFunction2 copy = new IndividualFunction2(chromosome, fitness, selectionProb, objetiveValue, lowerLimit, upperLimit, size);
		copy.setN(n);
		return copy;
	}

}
