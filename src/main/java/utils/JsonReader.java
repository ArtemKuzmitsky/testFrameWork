package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codehaus.plexus.logging.LoggerManager;

import java.io.File;
import java.io.IOException;

public class JsonReader {
    protected static ObjectMapper objectMapper = new ObjectMapper();
    protected static Logger logger = LogManager.getLogger(JsonReader.class);

    public static  <T> T loadDataObject(final Class<T> clazz) {
        T  objValue = null;
        try {
            objValue = (T) objectMapper.readValue(new File(System.getProperty("user.dir") + "/resources/testDataFiles/SearchTest.json"),clazz);
        } catch (IOException e) {
           logger.error("Error during jsonData loading" +e.getMessage());
        }
        return objValue;
    }
}
