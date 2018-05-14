package driver;

import driver.propeprties.EnvironmentProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FireFoxDriver extends Driver {

    private DesiredCapabilities capabilities;

    FireFoxDriver(int session) {
        initFireFox();
        System.out.println("Init FireFox browser session " + session);
    }


    public FireFoxDriver() {
        initFireFox();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }


    private void initFireFox() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wrapperWebDriver = new WrapperWebDriver(driver);

        driver.manage().window().maximize();

        driver.get(EnvironmentProperties.getProperty("URL"));
    }
}
