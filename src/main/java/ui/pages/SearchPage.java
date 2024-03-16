package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    protected  WebDriver driver;
    @FindBy(xpath = ".//textarea[@class='gLFyf']")
    WebElement searchField;


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchPage enterIntoSearchField(String text) {
        searchField.sendKeys(text);
        return this;
    }


}
