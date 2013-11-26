package ucla.ga.interfaces;

public interface IIndividual {
	public String getChromosome();

	public void setChromosome(String chromosome);

	public IIndividual copy();

	public double getPhenotype();

	public double getFitness();

	public void setFitness(double fitness);

	public void setSelectionProb(double prob);

	public double getSelectionProb();
	
	public double getObjetiveValue();
	
	public void setObjetiveValue(double value);
	
}
