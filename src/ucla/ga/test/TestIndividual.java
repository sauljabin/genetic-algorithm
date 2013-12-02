package ucla.ga.test;

import ucla.ga.element.fitness.Function1;
import ucla.ga.element.fitness.Function2;
import ucla.ga.element.fitness.Function3;
import ucla.ga.element.individual.IndividualFunction1;
import ucla.ga.element.individual.IndividualFunction2;
import ucla.ga.element.individual.IndividualFunction3;
import ucla.ga.element.individual.IndividualReal;

public class TestIndividual {

	public static void main(String[] args) {
		IndividualReal i = new IndividualReal(-100, 100, 63);
		System.out.println(i);

		// TEST INDIVIDUAL 1

		IndividualFunction1 if1 = new IndividualFunction1(-2, 2, 4);
		System.out.println(if1);
		Function1 f1 = new Function1();

		double[] xf1 = new double[30];

		for (int j = 0; j < 30; j++) {
			xf1[j] = 0;
		}

		System.out.println(f1.getObjetiveValue(xf1));

		// TEST INDIVIDUAL 2

		IndividualFunction2 if2 = new IndividualFunction2(-2, 2, 4);
		System.out.println(if2);
		Function2 f2 = new Function2();

		double[] xf2 = new double[30];

		for (int j = 0; j < 30; j++) {
			xf2[j] = 420.29;
		}

		System.out.println(f2.getObjetiveValue(xf2));

		// TEST INDIVIDUAL 3

		IndividualFunction3 if3 = new IndividualFunction3(-2, 2, 5);
		System.out.println(if3);
		Function3 f3 = new Function3();

		for (int j = -5; j <= 5; j++) {
			for (int k = -5; k <= 5; k++) {
				System.out.println(j + " " + k + " " + f3.getObjetiveValue(new double[] { j, k }));
			}
		}
	}

}
