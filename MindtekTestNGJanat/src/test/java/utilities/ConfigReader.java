package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    /**
     * This class is used to get the values from Configuration.properties file.
     * .getProperty(key) method accepts key as String and returns the value of that
     * key from the properties file.
     * @param String key
     * @return String value
     */

    static String path=System.getProperty("user.dir")+"/src/test/resources/configurations/Configuration.properties";

    private static FileInputStream inputStream;
    private static Properties properties;

    static {
        try {
            inputStream = new FileInputStream(path);
            properties=new Properties();
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            System.out.println("Path for properties file is invalid");
        } catch (IOException e) {
            System.out.println("Failed to load the properties file");
        }finally {
            try {
                assert inputStream != null;
                inputStream.close();
            } catch (IOException e) {
                System.out.println("Exception occurred when trying to close input object");
            }
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
