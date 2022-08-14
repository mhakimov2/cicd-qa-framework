package features;

import context.TestContext;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static support.web.WebElementHelper.getText;
import static ui.components.locators.Locators.HomePage.TXT_XYZ;

public class FeatureXYZTest extends TestContext {

    static {
        System.setProperty("application.env", "remote");
    }

    @Test
    @DisplayName("Test case verifies feature XYZ function output is in upper case")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("XYZ")
    void verifyFeatureXyzIsInUpperCase() throws InterruptedException {
        openApp().verifyTextIsInUpperCase(getText(TXT_XYZ.get()));
    }

    @Test
    @DisplayName("Test case verifies feature XYZ function output is displayed")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("XYZ")
    void verifyFeatureXyzIsDisplayed() throws InterruptedException {
        openApp().verifyWebElementIsDisplayed(TXT_XYZ.get());
    }

    @Test
    @DisplayName("Test case verifies feature XYZ function output is enabled in UI")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("XYZ")
    void verifyFeatureXyzIsEnabled() throws InterruptedException {
        openApp().verifyWebElementIsEnabled(TXT_XYZ.get());
    }
}
