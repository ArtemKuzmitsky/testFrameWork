package uiTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import ui.driver.DriverConfig;
import ui.pages.SearchPage;
import utils.KeyboardActions;
import utils.PropertiesReader;

import java.util.Properties;
@Listeners(listeners.ListenerClass.class)
public class BaseTest {

    public static WebDriver driver = null;
    protected Properties properties = new Properties();
    protected PropertiesReader propertiesReader = new PropertiesReader();
    SearchPage searchPage;
    KeyboardActions keyboardActions;

    @BeforeTest
    public void setUp() {
        propertiesReader.readProperties();
        properties = propertiesReader.getProperties();
        driver = DriverConfig.initializeDriver();
        searchPage = new SearchPage(driver);
        keyboardActions = new KeyboardActions(driver);
    }
    @AfterTest
    public void close() {
        driver.close();
        DriverConfig.removeDriver();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }



}
