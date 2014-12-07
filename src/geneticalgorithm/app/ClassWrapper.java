/**
 * 
 * ClassWrapper.java
 * 
 * Copyright (c) 2014, Saúl Piña <sauljabin@gmail.com>.
 * 
 * This file is part of GeneticAlgorithm.
 * 
 * GeneticAlgorithm is licensed under The MIT License.
 * For full copyright and license information please see the LICENSE.txt file.
 *
 */

package geneticalgorithm.app;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class ClassWrapper {
	private Class<?> clazz;

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public ClassWrapper(Class<?> clazz) {
		this.clazz = clazz;
	}

	public ClassWrapper() {

	}

	@Override
	public String toString() {
		return clazz.getSimpleName();
	}

}
