package ui.components.locators;

import org.openqa.selenium.By;

import java.util.function.Function;

import static java.lang.String.format;

public interface Locators {

    enum HomePage implements Locators {
        TFT_HI(By::cssSelector, "body > p"),
        TXF_USERNAME(By::id, "CovenantUserRegister_UserName"),
        TXF_PASSWORD(By::id, "CovenantUserRegister_Password"),
        TXF_PASSWORD_CONFIRM(By::id, "CovenantUserRegister_ConfirmPassword"),
        BTN_LOGIN(By::cssSelector, "button"),
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
    }

    enum GruntsPage implements Locators {

        LBL_GRUNT_RECORD(By::cssSelector, "#grunts > div.table-responsive > table > tbody > tr:nth-child(%s) > td:nth-child(%s)"),
        LBL_GRUNT_NAMES(By::cssSelector, "#grunts > div.table-responsive > table > tbody td:nth-child(1)")
        ;

        private String id;
        private Function<String, By> function;

        GruntsPage(Function<String, By> function, String id) {
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

    enum LaunchersPage implements Locators {
        BTN_DOWNLOAD(By::id, "download"),
        BTN_GENERATE(By::id, "generate"),
        LBL_LAUNCHERS(By::cssSelector, "div.d-flex.justify-content-between.flex-wrap.flex-md-nowrap.align-items-center.pb-2.mb-3 > h1[text='Launchers']"),
        LNK_LAUNCHER(By::cssSelector, "#covenant-container tr:nth-child(%s) > td:nth-child(1) > a"),
        ;

        private String id;
        private Function<String, By> function;

        LaunchersPage(Function<String, By> function, String id) {
            this.function = function;
            this.id = id;
        }

        public By get() {
            return function.apply(id);
        }
        public By get(String value) {
            return function.apply(format(id, value));
        }

    }

    enum LoginPage implements Locators {
        LBL_REGISTER_INITIAL_USER(By::xpath, "//h1[text()='Register Initial User']"),
        TXF_USERNAME(By::id, "CovenantUserRegister_UserName"),
        TXF_PASSWORD(By::id, "CovenantUserRegister_Password"),
        TXF_PASSWORD_CONFIRM(By::id, "CovenantUserRegister_ConfirmPassword"),
        BTN_LOGIN(By::cssSelector, "button"),
        ;

        private String id;
        private Function<String, By> function;

        LoginPage(Function<String, By> function, String id) {
            this.function = function;
            this.id = id;
        }

        public By get() {
            return function.apply(id);
        }
    }

    enum ListenersPage implements Locators {

        BTN_CREATE_LISTENER(By::cssSelector, "#listeners > a"),
        DDM_BRIDGE_PROFILE(By::xpath, "//*[@id='bridge']/form/div[6]/child::*[@id='ProfileId']"),
        DDM_BRIDGE_PROFILE2(By::cssSelector, "#ProfileId"),
        LNK_BRIDGE_LISTENERS(By::id, "bridge-tab"),
        LNK_LISTENER(By::cssSelector, "#listeners > div.table-responsive tbody > tr:nth-child(%s) a"),
        BTN_CREATE_BRIDGE_LISTENER(By::cssSelector, "#bridge > form > button"),
        //TXF_BIND_PORT(By::id, "BindPort"),
        TXF_BIND_PORT(By::xpath, "//*[@id=\"bridge\"]/form/div[3]/div[2]/child::*[@id='BindPort']"),
       // TXF_CONNECT_PORT(By::id, "ConnectPort"),
       TXF_CONNECT_PORT(By::xpath, "//*[@id=\"bridge\"]/form/div[4]/div/child::*[@id='ConnectPort']"),

        //TXF_NAME(By::id, "Name"),
        TXF_NAME(By::xpath, "//*[@id=\"bridge\"]/form/div[2]/child::*[@id='Name']"),

        ;

        private String id;
        private Function<String, By> function;

        ListenersPage(Function<String, By> function, String id) {
            this.function = function;
            this.id = id;
        }

        public By get() {
            return function.apply(id);
        }
        public By get(String value) {
            return function.apply(format(id, value));
        }
    }

    enum MainPage implements Locators {
        LBL_HEADER(By::xpath, "//*[@id='covenant-container']//h1[text()='%s']"),
        LNK_GRUNTS(By::id, "nav-grunts"),
        LNK_LAUNCHERS(By::id, "nav-launchers"),
        LNK_LISTENERS(By::id, "nav-listeners"),
        LNK_CATEGORY_CARS(By::cssSelector, "ul.categories li:nth-child(2) span a"),
        TXT_SEARCH(By::cssSelector, "#search_value"),
        BTN_DELETE_LISTENER(By::cssSelector, "#info > div > button.btn.btn-danger.ml-2"),
        BTN_SEARCH(By::cssSelector, "input.submit"),
        ;

        private String id;
        private Function<String, By> function;

        MainPage(Function<String, By> function, String id) {
            this.function = function;
            this.id = id;
        }

        public By get() {
            return function.apply(id);
        }
        public By get(String value) {
            return function.apply(format(id, value));
        }

    }

    enum CategoryPage implements  Locators {
        LBL_FILTERS_DIV(By::cssSelector, "#filters"),
        LNK_SUBCATEGORY_ALL_ADS(By::cssSelector, "li.checkAll a"),
        LNK_TMP_ADS_FROM_THE_LIST(By::xpath, "//table/tbody/tr[%s]/td[1]/a"),
        LNK_TMP_ADS_FROM_THE_LIST_ADD_TO_FAV(By::xpath, "//tbody/tr[%s]/td/div/div/a[@class='fav-add']"),
        LNK_FAVOURITES(By::cssSelector, "#favorites-link"),
        LBL_BANNER(By::cssSelector, "body>ins.adsbygoogle"),
        ;

        private String id;
        private Function<String, By> function;

        CategoryPage(Function<String, By> function, String id) {
            this.function = function;
            this.id = id;
        }

        public By get() {
            return function.apply(id);
        }

        public By get(String value) {
            return function.apply(format(id, value));
        }
    }

    enum AdvertisementPage implements Locators {

        BTN_BACK_TO_LIST(By::cssSelector, "#adNav li.backToList"),
        LNK_ADD_TO_FAV(By::cssSelector, "#favs-link"),
        LNK_FAVOURITES(By::cssSelector, "#favorites-link"),
        ;

        private String id;
        private Function<String, By> function;

        AdvertisementPage(Function<String, By> function, String id) {
            this.function = function;
            this.id = id;
        }

        public By get() {
            return function.apply(id);
        }
    }

    enum FavoritesPage implements Locators {

        LBL_YOUR_FAVOURITES(By::cssSelector, "td.left_column div.four a"),
        LNK_TMP_ADS_FROM_THE_LIST(By::xpath, "//table/tbody/tr[%s]/td[1]/a"),
        ;

        private String id;
        private Function<String, By> function;

        FavoritesPage(Function<String, By> function, String id) {
            this.function = function;
            this.id = id;
        }

        public By get() {
            return function.apply(id);
        }

        public By get(String value) {
            return function.apply(format(id, value));
        }
    }
}
