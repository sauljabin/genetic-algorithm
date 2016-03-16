/**
 * Copyright (c) 2014 Saúl Piña <sauljabin@gmail.com>.
 * 
 * This file is part of GeneticAlgorithm.
 * 
 * GeneticAlgorithm is licensed under The MIT License.
 * For full copyright and license information please see the LICENSE file.
 */

package geneticalgorithm.util;

import java.io.File;
import java.io.FileFilter;

/**
 * 
 * @author Saul Pina - sauljp07@gmail.com
 * 
 */
public class HelperFile {
	private static FileFilter isFile = new FileFilter() {
		@Override
		public boolean accept(File file) {
			return file.isFile();
		}
	};

	private static FileFilter isDirectory = new FileFilter() {
		@Override
		public boolean accept(File file) {
			return file.isDirectory();
		}
	};

	public static File[] files(String path) {
		return new File(path).listFiles(isFile);
	}

	public static File[] directories(String path) {
		return new File(path).listFiles(isDirectory);
	}

	public static String getOnlyName(File file) {
		return getOnlyName(file.getName());
	}

	public static String getOnlyName(String name) {
		return name.substring(0, name.lastIndexOf('.'));
	}

	public static String getExtension(File file) {
		return getExtension(file.getName());
	}

	public static String getExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf('.') + 1, fileName.length());
	}

	public static boolean isFileType(File file, String... extensions) {
		return isFileType(file.getName(), extensions);
	}

	public static boolean isFileType(String fileName, String... extensions) {
		for (String extension : extensions) {
			if (fileName.toUpperCase().endsWith(extension.toUpperCase()))
				return true;
		}
		return false;
	}
}
