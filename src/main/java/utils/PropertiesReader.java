package utils;

import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private final Properties properties = new Properties();
    protected static TestConfigProperties testConfigProperties;
    Logger logger = LogManager.getLogger(getClass());

    //Classic variant
    public void readProperties() {
        try {
            properties.load(new FileInputStream(System.getProperty("user.dir") + "/resources/testConfig.properties"));
        } catch (IOException e) {
            logger.error("Exception in PropertiesReader class" + e.getMessage());
        }
    }

    //Using Owner
    public static TestConfigProperties getTestConfigProperties(){
       return testConfigProperties = ConfigFactory.create(TestConfigProperties.class);
    }


    public Properties getProperties() {
        return properties;
    }
}
