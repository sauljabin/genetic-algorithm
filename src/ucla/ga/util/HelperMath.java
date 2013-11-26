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

import java.util.Random;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public abstract class HelperMath {

	public static int random(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}

	public static double random(double min, double max) {
		Random random = new Random();
		return (random.nextDouble() * (max - min)) + min;
	}

	public static float random(float min, float max) {
		Random random = new Random();
		return (random.nextFloat() * (max - min)) + min;
	}

	public static double random() {
		Random random = new Random();
		return random.nextDouble();
	}

	public static int randomBinary() {
		Random random = new Random();
		return random.nextInt(2);
	}

	public static String doubleToBinaryString(double value) {
		String sign = value < 0 ? "1" : "0";
		return sign + Long.toBinaryString(Double.doubleToLongBits(Math.abs(value)));
	}

	public static String floatToBinaryString(float value) {
		String sign = value < 0 ? "1" : "0";
		return sign + Integer.toBinaryString(Float.floatToIntBits(Math.abs(value)));
	}

	public static String integerToBinaryString(int value) {
		String sign = value < 0 ? "1" : "0";
		return sign + Integer.toBinaryString(Math.abs(value));
	}

	public static String integerToBinaryString(int value, int size) {
		String sign = value < 0 ? "1" : "0";
		return sign + String.format("%" + (size - 1) + "s", Integer.toBinaryString(Math.abs(value))).replace(" ", "0");
	}

	public static double binaryStringToDouble(String value) {
		double sign = value.charAt(0) == '1' ? -1 : 1;
		value = value.substring(1);
		return sign * Double.longBitsToDouble(Long.parseLong(value, 2));
	}

	public static float binaryStringToFloat(String value) {
		float sign = value.charAt(0) == '1' ? -1 : 1;
		value = value.substring(1);
		return sign * Float.intBitsToFloat(Integer.parseInt(value, 2));
	}

	public static int binaryStringToInteger(String value) {
		int sign = value.charAt(0) == '1' ? -1 : 1;
		value = value.substring(1);
		return sign * Integer.parseInt(value, 2);
	}
}
