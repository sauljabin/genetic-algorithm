/**
 * Copyright (c) 2014 Saúl Piña <sauljabin@gmail.com>.
 * 
 * This file is part of GeneticAlgorithm.
 * 
 * GeneticAlgorithm is licensed under The MIT License.
 * For full copyright and license information please see the LICENSE file.
 */

package geneticalgorithm.app;

import geneticalgorithm.util.HelperFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 */
public class Locale {

	private Properties properties;
	private String path;

	public Locale(String path) {
		this.path = path;
		properties = new Properties();
	}

	public void load(String language) throws FileNotFoundException, IOException {
		properties.load(new FileInputStream(String.format("%s%s", path, language)));
	}

	public String get(String key) {
		return properties.getProperty(key);
	}

	public String[] list() {
		File[] files = HelperFile.files(path);
		String[] filesName = new String[files.length];
		for (int i = 0; i < files.length; i++) {
			filesName[i] = files[i].getName();
		}
		return filesName;
	}
}
