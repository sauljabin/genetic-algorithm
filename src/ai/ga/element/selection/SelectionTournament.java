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

import java.util.ArrayList;
import java.util.List;

import ai.ga.element.Individual;
import ai.ga.element.Selection;
import ai.ga.util.HelperMath;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class SelectionTournament extends Selection {

	@Override
	public Individual selection(Individual[] population) {
		
		int k = 5;// population.length / 2;
		if (k > population.length)
			k = population.length;

		List<Individual> tempList = new ArrayList<Individual>();

		for (int i = 0; i < k;) {
			Individual select = population[HelperMath.random(0, population.length - 1)];
			if (tempList.contains(select))
				continue;
			tempList.add(select);
			i++;
		}

		Individual better = tempList.get(0);
		for (int i = 1; i < tempList.size(); i++) {
			if (tempList.get(i).getFitness() >= better.getFitness())
				better = tempList.get(i);
		}

		return better;
	}
}
