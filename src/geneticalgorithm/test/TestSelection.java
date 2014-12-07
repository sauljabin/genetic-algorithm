/**
 * 
 * TestSelection.java
 * 
 * Copyright (c) 2014, Saúl Piña <sauljabin@gmail.com>.
 * 
 * This file is part of GeneticAlgorithm.
 * 
 * GeneticAlgorithm is licensed under The MIT License.
 * For full copyright and license information please see the LICENSE.txt file.
 *
 */

package geneticalgorithm.test;

import geneticalgorithm.element.Selection;
import geneticalgorithm.element.individual.IndividualReal;
import geneticalgorithm.element.selection.SelectionTournament;

import java.util.Iterator;
import java.util.Set;

import org.reflections.Reflections;

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
