package driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropetyReader {
    Properties properties = new Properties();
    InputStream input = null;

    public PropetyReader() throws IOException {
        try {
            input = new FileInputStream("config.properties");
            properties.load(input);
            System.out.println(properties.getProperty("browser"));
            System.out.println(properties.getProperty("timeout"));
            System.out.println(properties.getProperty("email"));
            System.out.println(properties.getProperty("password"));
            System.out.println(properties.getProperty("os"));
            System.out.println(properties.getProperty("url"));
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
