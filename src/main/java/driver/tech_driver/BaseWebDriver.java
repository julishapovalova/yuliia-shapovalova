package driver.tech_driver;

import driver.ApplicationManager;
import org.openqa.selenium.WebDriver;

public class BaseWebDriver {

    protected ApplicationManager manager;
    private WebDriver driver;

    public BaseWebDriver(ApplicationManager manager) {
        this.manager = manager;
        driver = manager.getWebDriverSingleton().getDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
