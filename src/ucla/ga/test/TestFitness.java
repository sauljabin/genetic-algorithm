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

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class TestFitness {

	public static double getFitness(double... phenotype) {
		return 0;
	}

	public static double getObjetiveValue(double... phenotype) {
		double[] x = phenotype;
		int n = x.length;

		double sum = 0;

		for (int i = 0; i < n; i++) {
			sum += (-x[i] * Math.sin(Math.sqrt(Math.abs(x[i]))));
		}

		return sum;
	}

	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter("test.txt"), true);

		double[][] p = new double[1001][30];

		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[i].length; j++) {
				p[i][j] = -p.length / 2 + i;				
			}
			System.out.println(p[i][0]);
		}
		
		double sum = 0;
		for (int j = 0; j < p.length; j++) {
			double ob = getObjetiveValue(p[j]);
			sum += ob;			
		}

		for (int i = 0; i < p.length; i++) {			
			pw.printf("%6.0f  %10.3f  %10.3f\n", p[i][0], getObjetiveValue(p[i]), (Long.MAX_VALUE-getObjetiveValue(p[i])*p.length/sum)/Long.MAX_VALUE);

		}
		pw.close();
	}

}
