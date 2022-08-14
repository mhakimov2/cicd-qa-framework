package features;

import context.TestContext;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static support.web.WebElementHelper.getText;
import static ui.components.locators.Locators.HomePage.TFT_HI;
import static ui.components.locators.Locators.HomePage.TXT_XYZ;

public class FeatureATest extends TestContext {

    static {
        System.setProperty("application.env", "remote");
    }

    @Test
    @Description("this test case verifies feature1 function output is in lower case")
    void verifyFeature1() throws InterruptedException {
        openApp().verifyTextIsInLowerCase(getText(TFT_HI.get()));
    }

    @Test
    @DisplayName("Test case verifies feature A function output is displayed")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("A")
    void verifyFeatureXyzIsDisplayed() throws InterruptedException {
        openApp().verifyWebElementIsDisplayed(TFT_HI.get());
    }

    @Test
    @DisplayName("Test case verifies feature A function output is enabled in UI")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("A")
    void verifyFeatureXyzIsEnabled() throws InterruptedException {
        openApp().verifyWebElementIsEnabled(TFT_HI.get());
    }
}
