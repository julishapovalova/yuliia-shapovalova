package driver.propeprties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentProperties {

    private static Properties prop;

    private EnvironmentProperties() {
    }

    private static void init(String configName) {
        prop = new Properties();
        try {
            prop.load(new FileInputStream(configName));
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    public static String getProperty(String propertyName) {
        if (prop == null) {
            init("src/test/resources/properties/instance.properties");
        }
        return prop.getProperty(propertyName);
    }
}
