package driver;

import driver.propeprties.EnvironmentProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class ChromeDriver extends Driver {
    private DesiredCapabilities capabilities;

    ChromeDriver(int session) {
        initChrome();
        System.out.println("Init Chrome browser session " + session);
    }

    ChromeDriver() {
        initChrome();
        webDriverStatred();

    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    private void initChrome() {
        String url = EnvironmentProperties.getProperty("URL");
        ChromeOptions option = new ChromeOptions();
//        option.addArguments("--headless");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        WebDriverManager.chromedriver().setup();
        driver = new org.openqa.selenium.chrome.ChromeDriver(option);
        wrapperWebDriver = new WrapperWebDriver(driver);

        driver.manage().window().maximize();
        wrapperWebDriver.get(url);
    }
}
