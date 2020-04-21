package Helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class FileReader {

    private static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        Properties properties = new Properties();
        properties.load(fis);

        return properties;
    }

    public static String getValue(String key) throws IOException {
        return readPropertiesFile("./src/main/resources/properties.properties").getProperty(key);
    }
}
