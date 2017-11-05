/**
 * Copyright (c) 2014 Saúl Piña <sauljabin@gmail.com>.
 * <p>
 * This file is part of GeneticAlgorithm.
 * <p>
 * GeneticAlgorithm is licensed under The MIT License.
 * For full copyright and license information please see the LICENSE file.
 */

package geneticalgorithm.app;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 *
 * @author Saul Pina - sauljp07@gmail.com
 */
public class Locale {

    private Properties properties;

    public Locale() {
        properties = new Properties();
    }

    public void load() throws IOException {
        String path = String.format("%s%s", "locale/", Config.get("LOCALE"));
        properties.load(new InputStreamReader(ClassLoader.getSystemResourceAsStream(path), "UTF-8"));
    }

    public String get(String key) {
        return properties.getProperty(key);
    }

}
