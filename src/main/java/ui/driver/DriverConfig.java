package ui.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.PropertiesReader;

import java.time.Duration;
import java.util.Properties;

public class DriverConfig {
    private static final PropertiesReader propertiesReader = new PropertiesReader();
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

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
            }
        }
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver.get();
    }

    public static void removeDriver(){
        driver.remove();
    }

}
