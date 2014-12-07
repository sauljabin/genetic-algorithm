/**
 * 
 * Config.java
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class Config {
	private Properties properties;
	private String path;
	private String stringPathFormat = "%sconfig.props";

	public Config(String path) {
		this.path = path;
		properties = new Properties();
	}

	public void load() throws FileNotFoundException, IOException {
		properties.load(new FileInputStream(String.format(stringPathFormat, path)));
	}

	public String get(String key) {
		return properties.getProperty(key);
	}

	public void set(String key, String value) {
		properties.put(key, value);
	}

	public void save() throws FileNotFoundException, IOException {
		properties.store(new FileOutputStream(String.format(stringPathFormat, path)), "GENETIC_ALGORITHM");
	}
}
