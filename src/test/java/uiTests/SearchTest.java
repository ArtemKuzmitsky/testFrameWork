package uiTests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemes.TestData;
import utils.JsonReader;

@Epic("Simple google search")
@Feature(value = "Simple search")
public class SearchTest extends BaseTest {

    @Test(testName = "searchItemTest")
    @Description("Simple google search test")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "The link to the test case", url = "http://yandex.ru")
    public void searchItemTest() {
        TestData testData = JsonReader.loadDataObject(TestData.class);
        popUpWindows.clickRejectButton();
        searchPage.enterIntoSearchField(testData.getSearchData());
        keyboardActions.clickEnterButton();
        Assert.assertEquals(driver.getTitle(), "test4");
    }

    @Test(testName = "anotherSearchItemTest")
    @Description("Simple google search test")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "The link to the test case", url = "http://yandex.ru")
    public void anotherSearchItemTest() {
        TestData testData = JsonReader.loadDataObject(TestData.class);
        popUpWindows.clickRejectButton();
        searchPage.enterIntoSearchField(testData.getSearchData());
        keyboardActions.clickEnterButton();
    }
}
