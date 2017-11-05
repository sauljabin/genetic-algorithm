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


public class Config {

    public static String configPath = "config.properties";
    private static Properties properties = new Properties();

    public static void load() throws IOException {
        properties.load(new InputStreamReader(ClassLoader.getSystemResourceAsStream(configPath), "UTF-8"));
        properties.put("OS", System.getProperty("os.name"));
        properties.put("OS_ARCH", System.getProperty("os.arch"));
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

}
