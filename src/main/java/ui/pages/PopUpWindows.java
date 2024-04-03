package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PopUpWindows {
    private WebDriver driver = null;
    @FindAll(@FindBy(xpath = "//div[contains(text(), \"Reject all\") and @class='QS5gu sy4vM']"))
    List<WebElement> rejectButton;

    public PopUpWindows(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Step("Close pop up window")
    public SearchPage clickRejectButton() {
        if (rejectButton.size() > 0) {
            rejectButton.get(0).click();
        }
        return new SearchPage(driver);
    }

    public WebElement getRejectButton() {
        return rejectButton.get(0);
    }
}
