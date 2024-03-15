package uiTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
import schemes.TestData;
import utils.JsonReader;

import static org.testng.Assert.assertEquals;

public class SearchTest extends BaseTest {

    @Test(testName = "searchItemTest", priority = 1)
    @Description("Simple google search test")

    public void searchItemTest(ITestContext context) {
        TestData testData = JsonReader.loadDataObject(TestData.class);
        popUpWindows.clickRejectButton()
                .enterIntoSearchField(testData.getSearchData());
        keyboardActions.clickEnterButton();
    }

    @Test(testName = "anotherSearchItemTest", priority = 2)
    @Description("Simple google search test")

    public void anotherSearchItemTest(ITestContext context) {
        TestData testData = JsonReader.loadDataObject(TestData.class);
        popUpWindows.clickRejectButton();
        searchPage.enterIntoSearchField(testData.getSearchData());
        keyboardActions.clickEnterButton();
    }
}
