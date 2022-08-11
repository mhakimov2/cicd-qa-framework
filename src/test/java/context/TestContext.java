package context;

import config.ApplicationProperties;
import config.annotations.Dataset;
import config.webdriver.DriverBase;
import exception.IncorrectTestDataException;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static config.ApplicationProperties.ApplicationProperty.*;
import static config.ApplicationProperties.getBoolean;
import static config.ApplicationProperties.getString;
import static support.web.WebElementHelper.click;
import static support.web.WebElementHelper.navigateToPage;
import static ui.components.locators.Locators.ListenersPage.LNK_LISTENER;
import static ui.components.locators.Locators.MainPage.BTN_DELETE_LISTENER;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.components.models.HomePageModel;
import utils.DataProvider;

import java.io.*;


@ExtendWith(TestContext.AfterTestExecution.class)
public class TestContext {

    protected WebDriver driver;
    protected DataProvider data;

    private static final Logger logger = LoggerFactory.getLogger(LoginModel.class);


    @BeforeAll
    public static void instantiateDriverObject() {

    }

    @BeforeEach
    public void setUp(TestInfo testInfo) throws IOException {
//        Runtime.getRuntime().exec(String.format("docker run -t -p 7443:7443 -p 80:80 -p 443:443 --net=selenoid --name covenant -v" +
//                        " %s:/app/Data covenant --username AdminUser --computername 0.0.0.0 --password %s",
//                getString(PATH_TO_COVENANT_DATA), getString(HOST_MACHINE_PASSWORD)));
        driver = DriverBase.getDriver();
        setupTestData(testInfo);
    }

    @AfterAll
    public static void closeDriverObjects() {

    }

    @AfterEach
    public void clearCookies() throws Exception {
//        deleteListener();
//
//        Runtime.getRuntime().exec("docker stop covenant");
//        Thread.sleep(500);
//        Runtime.getRuntime().exec("docker rm covenant");

        DriverBase.clearCookies();
        DriverBase.closeCurrentDriver();

    }

    public HomePageModel openApp() throws InterruptedException {
        navigateToPage(ApplicationProperties.getString(APP_URL));
        return new HomePageModel();
    }

    public LoginModel openApp2() throws InterruptedException {
        navigateToPage(ApplicationProperties.getString(APP_URL));
        return new LoginModel();
    }

    public void deleteListener() {
        try {
            new MainModel().navigateToListenersPage();
            click(LNK_LISTENER.get("1"));
            click(BTN_DELETE_LISTENER.get());
        } catch (Exception e) {
            logger.info("No listeners to delete");
        }

    }


    private void setupTestData(TestInfo testInfo) {
        boolean isAnnotated = testInfo.getTestMethod().get().isAnnotationPresent(Dataset.class);
        if (isAnnotated) {
            String datasetName = testInfo.getTestMethod().get().getAnnotation(Dataset.class).value();
            if (new File("./src/test/resources/" + datasetName + ".json").exists()) {
                data = new DataProvider(datasetName);
            } else {
                throw new IncorrectTestDataException(String.format("Dataset with name '%s.json' does not exist in resources", datasetName));
            }
        }
    }

    public static class AfterTestExecution implements AfterTestExecutionCallback {

        @Override
        public void afterTestExecution(ExtensionContext context) throws Exception {
            Boolean isFailed = context.getExecutionException().isPresent();

            if (isFailed) {
                captureScreen(context.getTestMethod().get().getName() + context.getDisplayName());
            }
            if (new File("log.log").exists())
                attachLog();

            if (getBoolean(ApplicationProperties.ApplicationProperty.ENABLE_VIDEO) &&
                    getBoolean(ApplicationProperties.ApplicationProperty.REMOTE_DRIVER)) {
                attachVideoLink();
            }
        }

        public String captureScreen(String testName) {
            String path;
            try {
                WebDriver driver = DriverBase.getDriver();
                byte[] source = makeScreenshotOnFailure(driver);
                path = "./target/screenshots/" + testName + System.currentTimeMillis() + ".png";
                FileUtils.writeByteArrayToFile(new File(path), source);
            } catch (IOException e) {
                path = "Failed to capture screenshot: " + e.getMessage();
            }
            return path;
        }

        public byte[] makeScreenshotOnFailure(WebDriver driver) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }

        public byte[] attachLog() throws IOException {
            byte[] log = FileUtils.readFileToByteArray(new File("log.log"));
            FileUtils.forceDeleteOnExit(new File("log.log"));
            return log;
        }

        public byte[] attachVideoLink() throws IOException {
            String gridURL = getString(ApplicationProperties.ApplicationProperty.SELENIUM_GRID_URL);
            String sessionId = ((RemoteWebDriver) DriverBase.getDriver()).getSessionId().toString();
            String videoUrl = gridURL + "/video/" + sessionId + ".mp4";
            byte[] video = videoUrl.getBytes();
            return video;
        }
    }

}
