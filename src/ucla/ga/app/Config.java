package ucla.ga.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

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
		properties.store(new FileOutputStream(String.format("%sconfig.properties", path)), "");
	}
}
