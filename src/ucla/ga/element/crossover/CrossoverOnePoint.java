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

package ucla.ga.element.crossover;

import ucla.ga.element.Crossover;
import ucla.ga.element.Individual;
import ucla.ga.util.HelperMath;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class CrossoverOnePoint extends Crossover {

	@Override
	public void crossover(Individual a, Individual b) {
		int chromosomeSize = a.getChromosome().length();
		int rand = HelperMath.random(1, a.getChromosome().length() - 1);
		String tempA1 = a.getChromosome().substring(0, rand);
		String tempA2 = a.getChromosome().substring(rand, chromosomeSize);
		String tempB1 = b.getChromosome().substring(0, rand);
		String tempB2 = b.getChromosome().substring(rand, chromosomeSize);
		a.setChromosome(tempB1 + tempA2);
		b.setChromosome(tempA1 + tempB2);
	}

}
