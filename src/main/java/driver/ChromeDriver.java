package driver;

import driver.propeprties.EnvironmentProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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
        String url=EnvironmentProperties.getProperty("URL");

        capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "none");

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        wrapperWebDriver=new WrapperWebDriver(driver);
        wrapperWebDriver.get(url);
    }
}
