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

package ucla.ga.test;

import ucla.ga.util.HelperMath;

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
