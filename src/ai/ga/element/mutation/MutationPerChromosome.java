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

package ai.ga.element.mutation;

import ai.ga.element.Individual;
import ai.ga.element.Mutation;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class MutationPerChromosome extends Mutation {

	@Override
	public void mutation(double probability, Individual a) {
		StringBuilder temp = new StringBuilder(a.getChromosome());
		for (int i = 0; i < a.getChromosome().length(); i++) {
			if (Math.random() <= probability) {
				temp.setCharAt(i, temp.charAt(i) == '0' ? '1' : '0');
			}
		}
		a.setChromosome(temp.toString());
	}

}
