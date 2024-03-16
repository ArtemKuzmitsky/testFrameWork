package uiTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ui.driver.DriverConfig;
import ui.pages.PopUpWindows;
import ui.pages.SearchPage;
import utils.KeyboardActions;
import utils.PropertiesReader;

import java.util.Properties;

@Listeners(listeners.ListenerClass.class)
public class BaseTest {

    public static WebDriver driver = null;
    protected Properties properties = new Properties();
    protected PropertiesReader propertiesReader = new PropertiesReader();
    PopUpWindows popUpWindows;
    SearchPage searchPage;
    KeyboardActions keyboardActions;

    @BeforeTest
    public void setUp() {
        propertiesReader.readProperties();
        properties = propertiesReader.getProperties();
        driver = DriverConfig.initializeDriver();
        popUpWindows = new PopUpWindows(driver);
        searchPage = new SearchPage(driver);
        keyboardActions = new KeyboardActions(driver);

    }

    @BeforeMethod
    public void lunch() {
        driver.get(properties.getProperty("url"));
    }



    @AfterTest
    public void close() {
            driver.quit();
        DriverConfig.removeDriver();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }


}
