package nearsoft.general;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public final class Setup {

    private static WebDriver driver;
    private static WaitingObject waitingObject;
    private static HashMap<String, Object> store = new HashMap<>();
    private static JavascriptExecutor jsExecutor;
    private static Actions actions;

    @Before
    /**
     *  Initialize a new driver basic on browser driver.
     */
    public void InitSetup() {
        String browser = System.getProperty("browser");
        if (browser == null) {
            browser = "chrome";
        }

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C://Users//Jessell//Documents//NearSoft//chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                driver = new ChromeDriver(options);

                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C://Users//Jessell//Documents//NearSoft//geckodriver.exe");
                DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
                desiredCapabilities.setCapability("marionette", true);
                driver = new FirefoxDriver(desiredCapabilities);

                break;
            default:
                throw new IllegalArgumentException("Not driver found for browser " + browser);
        }
        driver.manage().window().maximize();
        initObject();

    }
    private static void initObject(){
        waitingObject = new WaitingObject(driver);
        jsExecutor = (JavascriptExecutor) driver;
        waitingObject.implicityWait(20);
        actions = new Actions(driver);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    /**
     *
     * @param key
     * @return
     */
    public static Object getValueStore(String key) {
        return store.get(key);
    }

    /**
     *
     * @param key
     * @param value
     */
    public static void setKeyValueStore(String key, Object value) {
        store.put(key, value);
    }

    /**
     * Open new url
     * @param url
     */
    public static void openUrl(String url) {

        driver.get(url);
        waitingObject.waitForLoading(3600);

    }

    /**
     *
     * @return Return an instance of wait.
     */
    public static WaitingObject getWait() {
        return waitingObject;
    }

    /**
     *
     * @param script
     * @param arg
     * @return return an Object after execute the javascript expresion.
     */
    public static Object javascriptExecutor(String script, Object... arg) {
        return jsExecutor.executeScript(script, arg);
    }

    /**
     *
     * @param script
     * @return return an Object after execute the javascript expresion.
     */
    public static Object javascriptExecutor(String script) {
        return jsExecutor.executeScript(script);
    }

    /**
     *
     * @param script
     * @return return an Object after execute the javascript expresion.
     */
    public static Object javascriptExecutorAsync(String script) {
        return jsExecutor.executeAsyncScript(script);
    }

    /**
     *
     * @return Return an instance of Action object.
     */
    public static Actions getActions() {
        return actions;
    }

     @After
    public void close() {
        driver.close();
    }
}
