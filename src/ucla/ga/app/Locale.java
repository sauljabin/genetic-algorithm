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

package ucla.ga.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import ucla.ga.util.HelperFile;

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
		properties.load(new FileInputStream(String.format("%s%s.properties", path, language)));
	}

	public String get(String key) {
		return properties.getProperty(key);
	}

	public String[] list() {
		File[] files = HelperFile.files(path);
		String[] filesName = new String[files.length];
		for (int i = 0; i < files.length; i++) {
			filesName[i] = HelperFile.getOnlyName(files[i]);
		}
		return filesName;
	}
}
