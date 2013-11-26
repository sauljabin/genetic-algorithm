package ucla.ga.test;

import java.io.IOException;

import ucla.ga.element.GA;
import ucla.ga.gui.view.VGraphic;
import ucla.ga.interfaces.IIndividual;
import ucla.ga.util.HelperImage;

public class TestSGA {

	public static void main(String[] args) throws IOException {
		IIndividual[] populationTemp = new IIndividual[6];

		for (int i = 0; i < populationTemp.length; i++) {
			populationTemp[i] = new IndividualFloat(-100, 100);
		}

		VGraphic vGraphic = new VGraphic("Experimento 1");

		GA ag = new GA(new SelectionRoulette(), new MutationPerChromosome(), new CrossoverOnePoint(), new FitnessParable(), populationTemp, 100, .01, .5);
		ag.run();

		int i = 0;
		double onlinetemp = 0;
		double average = 0;
		double offlinetemp = 0;
		for (IIndividual[] population : ag.getGenerations()) {

			System.out.println("GENERATION: " + i);

			double sum = 0;
			double probMax = 0;
			IIndividual indMax = null;
			for (IIndividual individual : population) {
				System.out.println(individual);
				sum += individual.getObjetiveValue();
				if (indMax == null) {
					indMax = individual;
					probMax = individual.getSelectionProb();
				} else if (individual.getSelectionProb() >= probMax) {
					indMax = individual;
					probMax = individual.getSelectionProb();
				}
			}
			System.out.println();

			average = sum / population.length;

			vGraphic.addPoint(i, average, (offlinetemp + indMax.getFitness()) / (i + 1), (onlinetemp + average) / (i + 1));
			onlinetemp = onlinetemp + average;
			offlinetemp = offlinetemp + indMax.getFitness();
			i++;
		}

		// vGraphic.exportImage("image.png");

	}

}
