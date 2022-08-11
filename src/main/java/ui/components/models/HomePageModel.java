package ui.components.models;

import org.junit.jupiter.api.Assertions;

import static support.web.WebElementHelper.*;
import static ui.components.locators.Locators.HomePage.TFT_HI;
import static ui.components.locators.Locators.MainPage.*;

public class HomePageModel {

    public HomePageModel verifyTextIsInLowerCase() {
        String textFromUI = getText(TFT_HI.get());
        Assertions.assertEquals(textFromUI.toLowerCase(), textFromUI);
        return this;
    }





}
