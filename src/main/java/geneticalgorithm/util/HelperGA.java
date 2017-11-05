/**
 * Copyright (c) 2014 Saúl Piña <sauljabin@gmail.com>.
 * <p>
 * This file is part of GeneticAlgorithm.
 * <p>
 * GeneticAlgorithm is licensed under The MIT License.
 * For full copyright and license information please see the LICENSE file.
 */

package geneticalgorithm.util;

/**
 *
 * @author Saul Pina - sauljp07@gmail.com
 */
public class HelperGA {

    public static double convertChromosomeToReal(String chromosome, double lowerLimit, double upperLimit, int size) {
        return convertIntegerToReal(HelperMath.binaryStringToLongUnsigned(chromosome), lowerLimit, upperLimit, size);
    }

    public static double convertIntegerToReal(long i, double lowerLimit, double upperLimit, int size) {
        return (i * (upperLimit - lowerLimit) / (HelperMath.pow(2l, size) - 1) + lowerLimit);
    }

    public static String convertRealToChromosome(double i, double lowerLimit, double upperLimit, int size) {
        return HelperMath.longToBinaryString(convertRealToInteger(i, lowerLimit, upperLimit, size), size);
    }

    public static long convertRealToInteger(double i, double lowerLimit, double upperLimit, int size) {
        return Math.round((i - lowerLimit) / (upperLimit - lowerLimit) * (HelperMath.pow(2l, size) - 1));
    }

    public static String randomChromosome(int size) {
        // return HelperMath.longToBinaryStringUnsigned(HelperMath.random(0l, HelperMath.pow(2l, size) - 1), size);
        return HelperMath.randomBinary(size);
    }
}
