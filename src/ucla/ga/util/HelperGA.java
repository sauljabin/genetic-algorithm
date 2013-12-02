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

package ucla.ga.util;

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
