package features;

import context.TestContext;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

public class Feature1Test extends TestContext {

    static {
        System.setProperty("application.env", "default");
    }

    @Test
    @Description("this test case verifies feature1 function output is in lower case")
    void verifyFeature1() throws InterruptedException {
        openApp().verifyTextIsInLowerCase();
    }

}
