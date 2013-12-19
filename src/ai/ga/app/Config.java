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

package ai.ga.app;

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

	public Config(String path) {
		this.path = path;
		properties = new Properties();
	}

	public void load() throws FileNotFoundException, IOException {
		properties.load(new FileInputStream(String.format("%sconfig.properties", path)));
	}

	public String get(String key) {
		return properties.getProperty(key);
	}

	public void set(String key, String value) {
		properties.put(key, value);
	}

	public void save() throws FileNotFoundException, IOException {
		properties.store(new FileOutputStream(String.format("%sconfig.properties", path)), "GENETIC_ALGORITHM");
	}
}
