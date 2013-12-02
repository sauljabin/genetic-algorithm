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

package ucla.ga.element.individual;

import ucla.ga.element.Individual;
import ucla.ga.util.HelperGA;
import ucla.ga.util.HelperMath;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class IndividualReal extends Individual {

	public IndividualReal(double lowerLimit, double upperLimit, int size) {
		super(lowerLimit, upperLimit, size);
		chromosome = HelperGA.randomChromosome(size);
	}

	public IndividualReal(String chromosome, double fitness, double selectionProb, double objetiveValue, double lowerLimit, double upperLimit, int size) {
		super(chromosome, fitness, selectionProb, objetiveValue, lowerLimit, upperLimit, size);
	}

	@Override
	public Individual copy() {
		return new IndividualReal(chromosome, fitness, selectionProb, objetiveValue, lowerLimit, upperLimit, size);
	}

	@Override
	public double[] getPhenotype() {
		return new double[] { HelperGA.convertChromosomeToReal(chromosome, lowerLimit, upperLimit, size) };
	}

	public long getPhenotypeInteger() {
		return HelperMath.binaryStringToLongUnsigned(chromosome);
	}

	@Override
	public String toString() {
		return String.format("%s[phenotypeinteger=%d]", super.toString(), getPhenotypeInteger());
	}

}
