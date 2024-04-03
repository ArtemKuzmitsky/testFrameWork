package utils;

import org.aeonbits.owner.Config;

@Config.Sources("file:./src/main/resources/testConfig.properties")
public interface TestConfigProperties extends Config {

    String browser();

    String url();

    String baseURL();

    String basePath();

    @Key("test_data_file_path")
    String testDataFilePath();

    @Key("screenshot_path")
    String screenshotFolder();

}
