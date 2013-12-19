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

package ai.ga.util;

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
