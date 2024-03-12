package utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {
    Actions actions;
    WebDriver driver;

    public KeyboardActions(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public void clickEnterButton() {
        actions.keyDown(Keys.ENTER).perform();
    }
}
