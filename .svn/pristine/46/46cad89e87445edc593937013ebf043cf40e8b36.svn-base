package ua.org.oa._dani4_.properties;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by _dani on 30.03.2016.
 */
public class PropertyUtils {
    private static Properties properties = null;

    public static Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            try (InputStream in = PropertyUtils.class.getClassLoader().getResourceAsStream("App.properties")) {
                properties.load(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }
}