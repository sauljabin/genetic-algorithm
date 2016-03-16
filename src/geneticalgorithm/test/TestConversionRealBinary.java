/**
 * Copyright (c) 2014 Saúl Piña <sauljabin@gmail.com>.
 * 
 * This file is part of GeneticAlgorithm.
 * 
 * GeneticAlgorithm is licensed under The MIT License.
 * For full copyright and license information please see the LICENSE file.
 */

package geneticalgorithm.test;

import geneticalgorithm.util.HelperMath;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class TestConversionRealBinary {

	public static void main(String[] args) {

		double lin = -45;
		double lsu = 50;
		int n = 7;

		for (long i = 0; i <= (HelperMath.pow(2l, n) - 1); i++) {
			double x = (i * (lsu - lin) / (HelperMath.pow(2l, n) - 1) + lin);
			int itemp = (int) Math.round((((x - lin) / (lsu - lin)) * (HelperMath.pow(2l, n) - 1)));
			// System.out.println(String.format("i: %4d -> %s; val: %.16f; intval: %d ", i, HelperMath.longToBinaryStringUnsigned(i, n), x, itemp));
			System.out.println(String.format("i: %4d -> %s; val: %d; intval: %d ", i, HelperMath.longToBinaryStringUnsigned(i, n), Math.round(x), itemp));
		}

	}

}
