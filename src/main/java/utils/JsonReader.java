package utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;

public class JsonReader {
    protected static ObjectMapper objectMapper = new ObjectMapper();
    protected static Logger logger = LogManager.getLogger(JsonReader.class);

    public static <T> T loadDataObject(final Class<T> clazz) {
        T objValue = null;
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String className = Reporter.getCurrentTestResult().getInstance().getClass().getName();
        String testName = Reporter.getCurrentTestResult().getMethod().getConstructorOrMethod().getMethod().getName();
        String path = String.format(PropertiesReader.testConfigProperties.testDataFilePath(), className.substring(className.indexOf(".") + 1));
        JsonNode node = parse(new File(path)).get(testName).get("data").get(0);
        if (node != null) {
            try {
                objValue = objectMapper.treeToValue(node, clazz);
            } catch (IOException e) {
                logger.error("Error during jsonData loading" + e.getMessage());
            }
        } else {
            logger.error("No data found for the test: ");
        }
        return objValue;
    }

    public static JsonNode parse(File file) {
        JsonNode node = null;
        try {
            node = objectMapper.readTree(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return node;
    }
}
