package Utils;

import java.util.Properties;
import java.io.FileInputStream;

public class ConfigReader {

    static Properties prop;

    public static Properties initProp() {
        prop = new Properties();

        try {
            FileInputStream ip = new FileInputStream("src/test/resources/config.properties");
            prop.load(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return prop;
    }
}