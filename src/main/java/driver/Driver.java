package driver;

import driver.propeprties.EnvironmentProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public abstract class Driver {
    public WebDriverWait wait;
    protected WebDriver driver;
    protected WrapperWebDriver wrapperWebDriver;
    public abstract WebDriver getDriver();

    public void webDriverStatred() {
        Assert.assertTrue("Browser started", getDriver().getCurrentUrl().contains(EnvironmentProperties.getProperty("URL")));
    }

    public void refresh() {
        getDriver().navigate().refresh();
    }

    public abstract void close();
}
