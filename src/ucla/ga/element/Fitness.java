package ucla.ga.element;

public abstract class Fitness {
	public abstract double getFitness(double... phenotype);

	public abstract double getObjetiveValue(double... phenotype);
}
