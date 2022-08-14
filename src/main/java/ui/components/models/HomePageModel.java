package ui.components.models;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static support.web.WebElementHelper.*;
import static ui.components.locators.Locators.HomePage.TFT_HI;
import static ui.components.locators.Locators.HomePage.TXT_XYZ;

public class HomePageModel {

    @Step
    public HomePageModel verifyTextIsInLowerCase(String textFromUI) {
        Assertions.assertEquals(textFromUI.toLowerCase(), textFromUI);
        return this;
    }

    @Step
    public HomePageModel verifyTextIsInUpperCase(String textFromUI) {
        Assertions.assertEquals(textFromUI.toUpperCase(), textFromUI);
        return this;
    }

    @Step
    public HomePageModel verifyWebElementIsDisplayed(By locator) {
        Assertions.assertTrue(waitForElement(locator).isDisplayed());
        return this;
    }

    @Step
    public HomePageModel verifyWebElementIsEnabled(By locator) {
        Assertions.assertTrue(waitForElement(locator).isEnabled());
        return this;
    }




}
