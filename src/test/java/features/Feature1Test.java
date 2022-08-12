package features;

import context.TestContext;
import org.junit.jupiter.api.Test;

public class Feature1Test extends TestContext {

    @Test
    void verifyFeature1() throws  InterruptedException {
        openApp().verifyTextIsInLowerCase();
    }
}
