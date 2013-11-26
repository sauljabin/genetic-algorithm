package ucla.ga.test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import ucla.ga.element.GA;
import ucla.ga.gui.view.VGraphic;
import ucla.ga.interfaces.IIndividual;
import ucla.ga.util.HelperImage;

public class TestSGA {

	public static void main(String[] args) throws IOException {
		IIndividual[] populationTemp = new IIndividual[6];

		for (int i = 0; i < populationTemp.length; i++) {
			populationTemp[i] = new IndividualInteger(-100, 100);
		}

		VGraphic vGraphic = new VGraphic("Experimento 1");
		PrintWriter pw = new PrintWriter(new FileWriter("resultado.txt"), true);

		GA ag = new GA(new SelectionRoulette(), new MutationPerChromosome(), new CrossoverOnePoint(), new FitnessParable(), populationTemp, 300, .01, .5);
		ag.run();

		int i = 0;
		double onlinetemp = 0;
		double average = 0;
		double offlinetemp = 0;
		for (IIndividual[] population : ag.getGenerations()) {

			System.out.println("GENERATION: " + i);
			pw.println("GENERATION: " + i);

			double sum = 0;
			double probMax = 0;
			IIndividual indMax = null;
			for (IIndividual individual : population) {
				System.out.println(individual);
				pw.println(individual);
				sum += individual.getObjetiveValue();
				if (indMax == null) {
					indMax = individual;
					probMax = individual.getSelectionProb();
				} else if (individual.getSelectionProb() >= probMax) {
					indMax = individual;
					probMax = individual.getSelectionProb();
				}
			}

			average = sum / population.length;

			vGraphic.addPoint(i, average, (offlinetemp + indMax.getObjetiveValue()) / (i + 1), (onlinetemp + average) / (i + 1));
			onlinetemp = onlinetemp + average;
			offlinetemp = offlinetemp + indMax.getObjetiveValue();

			System.out.println(String.format("ONLINE: %.15f", onlinetemp / (i + 1)));
			System.out.println(String.format("OFFLINE: %.15f", offlinetemp / (i + 1)));
			System.out.println(String.format("AVERAGE: %.15f", average));

			pw.println(String.format("ONLINE: %.15f", onlinetemp / (i + 1)));
			pw.println(String.format("OFFLINE: %.15f", offlinetemp / (i + 1)));
			pw.println(String.format("AVERAGE: %.15f", average));

			System.out.println();
			pw.println();

			i++;
		}

		vGraphic.exportImage("image.png");
		pw.close();

	}

}
