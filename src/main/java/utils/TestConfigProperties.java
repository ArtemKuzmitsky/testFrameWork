package utils;

import org.aeonbits.owner.Config;
@Config.Sources("file:./resources/testConfig.properties")
public interface TestConfigProperties extends Config {
    @Key("browser")
    String browser();
    String url();

}
