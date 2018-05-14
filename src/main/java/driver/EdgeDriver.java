package driver;

import driver.propeprties.EnvironmentProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class EdgeDriver extends Driver {

    private DesiredCapabilities capabilities;

    EdgeDriver(int session) {
        initChrome();
        System.out.println("Init Chrome browser session " + session);
    }

    EdgeDriver() {
        initChrome();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    private void initChrome() {

        String url=EnvironmentProperties.getProperty("URL");


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        WebDriverManager.edgedriver().setup();
        driver = new org.openqa.selenium.edge.EdgeDriver();
        wrapperWebDriver = new WrapperWebDriver(driver);

        driver.manage().window().maximize();
        driver.get(url);
    }
}
