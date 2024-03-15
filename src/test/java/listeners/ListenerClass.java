package listeners;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import uiTests.BaseTest;
import utils.PropertiesReader;

import java.io.File;

public class ListenerClass extends BaseTest implements ITestListener {
    private final Logger logger = LogManager.getLogger(ListenerClass.class);
    String filePath = PropertiesReader.testConfigProperties.screenshotFolder();

    @Override
    public void onTestFailure(ITestResult testResult) {
        logger.error(testResult.getName() + " Test Failed!!!");
        String testName = testResult.getName().trim();
        takeScreenShot(testName, driver);
    }

    public void takeScreenShot(String testName, WebDriver driver) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
           File file=FileUtils.getFile(filePath, testName + ".png");
            if (file.exists()) {
                file.delete();
            }
            FileUtils.copyFile(scrFile, new File(filePath + testName + ".png"));
        } catch (Exception e) {
            logger.error("Error in Listener class: " + e.getMessage());
        }

    }
}
