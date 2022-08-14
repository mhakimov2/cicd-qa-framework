package ui.components.locators;

import org.openqa.selenium.By;

import java.util.function.Function;

import static java.lang.String.format;

public interface Locators {

    enum HomePage implements Locators {
        TFT_HI(By::cssSelector, "body > p"),
        TXT_XYZ(By::id, "feat-xyz"),
        ;

        private String id;
        private Function<String, By> function;

        HomePage(Function<String, By> function, String id) {
            this.function = function;
            this.id = id;
        }

        public By get() {
            return function.apply(id);
        }
        public By get(String value) {
            return function.apply(format(id, value));
        }
        public By get(String value1, String value2) {
            return function.apply(format(id, value1, value2));
        }
    }


}
