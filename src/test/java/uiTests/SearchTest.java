package uiTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemes.TestData;
import utils.JsonReader;

public class SearchTest extends BaseTest {

    @Test
    @Description("Test")
    public void searchItemTest() {
        TestData testData = JsonReader.loadDataObject(TestData.class);
        driver.get(properties.getProperty("url"));
        searchPage.clickRejectButton()
                .enterIntoSearchField(testData.getSearchData());
        keyboardActions.clickEnterButton();
        Assert.assertTrue(driver.getCurrentUrl().equals("Test"));
        close();
    }
}
