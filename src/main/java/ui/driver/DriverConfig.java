package ui.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.PropertiesReader;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class DriverConfig {
    private static final PropertiesReader propertiesReader = new PropertiesReader();
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final URI remoteUrl = URI.create("");
    static Logger logger = LogManager.getLogger(DriverConfig.class);
    private DriverConfig() {

    }

    public static WebDriver initializeDriver() {
        propertiesReader.readProperties();
        Properties properties = propertiesReader.getProperties();
        if (driver.get() == null) {
            if (PropertiesReader.getTestConfigProperties().browser().equalsIgnoreCase(DriverType.CHROME.toString())) {
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
            } else if (properties.getProperty("browser").equalsIgnoreCase(DriverType.FIREFOX.toString())) {
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
            } else if (PropertiesReader.getTestConfigProperties().browser().equalsIgnoreCase(DriverType.REMOTE.toString())) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("browserName", "chrome");
                try {
                    driver.set( WebDriverManager.chromedriver()
                            .capabilities(capabilities)
                            .remoteAddress(new URL("http://localhost:4444"))
                            .create());
                } catch (MalformedURLException e) {
                    logger.error("Error during remote drive init! "+e.getMessage());
                }
            }
        }
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.get();
    }

    public static void removeDriver() {
        driver.remove();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}
