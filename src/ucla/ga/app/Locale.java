package ucla.ga.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import ucla.ga.util.HelperFile;

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
