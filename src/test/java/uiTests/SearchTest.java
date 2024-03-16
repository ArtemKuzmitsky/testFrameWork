package uiTests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import schemes.TestData;
import utils.JsonReader;

public class SearchTest extends BaseTest {

    @Test(testName = "searchItemTest")
    @Description("Simple google search test")

    public void searchItemTest() {
        TestData testData = JsonReader.loadDataObject(TestData.class);
        popUpWindows.clickRejectButton();
        searchPage  .enterIntoSearchField(testData.getSearchData());
        keyboardActions.clickEnterButton();
    }

    @Test(testName = "anotherSearchItemTest")
    @Description("Simple google search test")

    public void anotherSearchItemTest() {
        TestData testData = JsonReader.loadDataObject(TestData.class);
        popUpWindows.clickRejectButton();
        searchPage.enterIntoSearchField(testData.getSearchData());
        keyboardActions.clickEnterButton();
    }
}
