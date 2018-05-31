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
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new org.openqa.selenium.edge.EdgeDriver();
        driver.manage().window().maximize();

        return new WrapperWebDriver(driver);
    }


    private static WebDriver initFireFox() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return new WrapperWebDriver(driver);
    }


    private static WebDriver initChrome() {
        ChromeOptions option = new ChromeOptions();
//        option.addArguments("--headless");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver(option);

        driver.manage().window().maximize();
        return new WrapperWebDriver(driver);
    }

    private static WebDriver initRemoteEdge() {
        // BrowserStackLocal.startInstance(AUTOMATE_KEY);
        String URL = "";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "WINDOWS");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "edge");
        caps.setCapability("browser_version", "16.0");
        caps.setCapability("resolution", "1600x1200");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("browserstack.local", "true");
        //caps.setCapability("browserstack.forceLocal", "true");
        caps.setCapability("browserstack.networkLogs", "true");
        caps.setCapability("build", "First build");
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
