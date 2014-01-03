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

package ai.ga.test;

import java.util.Iterator;
import java.util.Set;

import org.reflections.Reflections;

import ai.ga.element.Selection;
import ai.ga.element.individual.IndividualReal;
import ai.ga.element.selection.SelectionTournament;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class TestSelection {

	public static void main(String[] args) {

		IndividualReal[] population = new IndividualReal[20];

		for (int i = 0; i < population.length; i++) {
			population[i] = new IndividualReal(100, 200, 30);
		}

		SelectionTournament selection = new SelectionTournament();

		selection.selection(population);

		Reflections reflections = new Reflections("ai.ga.element");

		Set<Class<? extends Selection>> subTypes = reflections.getSubTypesOf(Selection.class);
		
		Iterator<Class<? extends Selection>> iterator= subTypes.iterator();
		while (iterator.hasNext()) {
			Class<?> class1 = (Class<?>) iterator.next();
			System.out.println(class1);
		}
	}

}
