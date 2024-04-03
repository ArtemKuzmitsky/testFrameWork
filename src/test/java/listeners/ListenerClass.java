package listeners;

import io.qameta.allure.Allure;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ui.driver.DriverConfig;
import uiTests.BaseTest;
import utils.PropertiesReader;

import java.io.File;
import java.io.FileInputStream;

public class ListenerClass implements ITestListener, TestLifecycleListener {
    private final Logger logger = LogManager.getLogger(ListenerClass.class);

    @Override
    public void onTestFailure(ITestResult testResult) {
        logger.error(testResult.getName() + " Test Failed!!!");
    }

    public void takeScreenShot(String testName, WebDriver driver) {
       String filePath =  PropertiesReader.testConfigProperties.screenshotFolder();
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
           File file=FileUtils.getFile(filePath, testName + ".png");
            if (file.exists()) {
                file.delete();
            }
            FileUtils.copyFile(scrFile, new File(filePath + testName + ".png"));
            Allure.addAttachment(testName, new FileInputStream(file));
        } catch (Exception e) {
            logger.error("Error in Listener class: " + e.getMessage());
        }

    }
    @Override
    public void beforeTestStop(TestResult result) {
        String testName = result.getName().trim();
        if(DriverConfig.getDriver()!=null) {
            takeScreenShot(testName, DriverConfig.getDriver());
        }
        }

}
