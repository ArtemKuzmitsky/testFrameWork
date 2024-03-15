package utils;

import org.aeonbits.owner.Config;

@Config.Sources("file:./resources/testConfig.properties")
public interface TestConfigProperties extends Config {

    String browser();

    String url();

    @Key("test_data_file_path")
    String testDataFilePath();

    @Key("screenshot_path")
    String screenshotFolder();

}
