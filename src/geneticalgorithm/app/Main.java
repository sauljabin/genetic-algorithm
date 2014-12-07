/**
 * 
 * Main.java
 * 
 * Copyright (c) 2014, Saúl Piña <sauljabin@gmail.com>.
 * 
 * This file is part of GeneticAlgorithm.
 * 
 * GeneticAlgorithm is licensed under The MIT License.
 * For full copyright and license information please see the LICENSE.txt file.
 *
 */

package geneticalgorithm.app;

import geneticalgorithm.gui.controller.CExperiment;

import javax.swing.JOptionPane;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class Main {

	public static void main(String[] args) {
		try {
			new CExperiment();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

}
