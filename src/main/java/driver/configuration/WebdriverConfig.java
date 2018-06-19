package driver.configuration;

import driver.propeprties.BrowserTypes;
import driver.propeprties.EnvironmentProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class WebdriverConfig {


    private static final String RESOLUTION = EnvironmentProperties.getProperty("browser.resolution");
    private static final String CHROME_VERSION = EnvironmentProperties.getProperty("drivermanager.chrome.version");
    private static final String EDGE_VERSION = EnvironmentProperties.getProperty("browserstack.edge.version");
    private static final String FIREFOX_VERSION = EnvironmentProperties.getProperty("browserstack.firefox.version");
    private static final String USERNAME = EnvironmentProperties.getProperty("browserstack.username");
    private static final String AUTOMATE_KEY = EnvironmentProperties.getProperty("browserstack.automated.key");
    private static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver webDriver() {
        WebDriver driver = null;
        switch (BrowserTypes.valueOf(EnvironmentProperties.getProperty("browser"))) {
            case CHROME:
                driver = initChrome();
                break;
            case FIREFOX:
                driver = initFireFox();
                break;
            case EDGE:
                driver = initEdge();
                break;
            default:
                driver = initChrome();
                break;
        }
        return driver;
    }


    private static WebDriver initEdge() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        WebDriverManager.edgedriver().version(EDGE_VERSION).setup();
        WebDriver driver = new org.openqa.selenium.edge.EdgeDriver();
        driver.manage().window().maximize();

        return new WrapperWebDriver(driver);
    }


    private static WebDriver initFireFox() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        WebDriverManager.firefoxdriver().version(FIREFOX_VERSION).setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return new WrapperWebDriver(driver);
    }


    private static WebDriver initChrome() {
        ChromeOptions option = new ChromeOptions();
//        option.addArguments("--headless");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("resolution", RESOLUTION);
        capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        WebDriverManager.chromedriver().version(CHROME_VERSION).setup();
        WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver(option);

        driver.manage().window().maximize();
        return new WrapperWebDriver(driver);
    }

    private static WebDriver initRemoteEdge() {
        // BrowserStackLocal.startInstance(AUTOMATE_KEY);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "WINDOWS");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "edge");
        caps.setCapability("browser_version", EDGE_VERSION);
        caps.setCapability("resolution", RESOLUTION);
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("browserstack.local", "true");
        //caps.setCapability("browserstack.forceLocal", "true");
        caps.setCapability("browserstack.networkLogs", "true");
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
            driver.manage().window().maximize();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("*** Failed to init remote BrowserStack driver! ***");
        }
        return (driver);
    }
}
