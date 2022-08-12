package features;

import config.annotations.Dataset;
import context.TestContext;
import org.junit.jupiter.api.Test;

public class Feature1Test extends TestContext {



    @Test
    void verifyConnectionBetweenGruntAndCovenant() throws  InterruptedException {
        openApp().verifyTextIsInLowerCase();
    }
}
