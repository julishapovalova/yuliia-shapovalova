package driver.configuration;

import driver.propeprties.EnvironmentProperties;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WrapperWebDriver implements WebDriver {
    private WebDriver driver;
    private WebDriverWait wait;

    WrapperWebDriver(WebDriver driver) {
        this.driver = driver;

        long implicitlyWait = Long.valueOf(EnvironmentProperties.getProperty("implicitly_Wait_FIREFOX"));
        long pageLoadTimeout = Long.valueOf(EnvironmentProperties.getProperty("browser.timeout.pageLoadTimeout"));

        wait = new WebDriverWait(this.driver, Long.valueOf(EnvironmentProperties.getProperty("implicitly_Wait_FIREFOX")));
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(implicitlyWait, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(implicitlyWait, TimeUnit.SECONDS);

    }

    public void get(String url) {
        try {
            driver.get(url);
            wait.until(ExpectedConditions.urlToBe(url));
        } catch (TimeoutException e) {
            DriverHolder.restart();
            driver.get(url);
            wait.until(ExpectedConditions.urlToBe(url));
        }
        Assert.assertEquals("Current url isn't equals", url, driver.getCurrentUrl());
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public WebElement findElement(By by) {
        return null;
    }

    public String getPageSource() {
        return null;
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    public Set<String> getWindowHandles() {
        return null;
    }

    public String getWindowHandle() {
        return null;
    }

    public TargetLocator switchTo() {
        return null;
    }

    public Navigation navigate() {
        return null;
    }

    public Options manage() {
        return null;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
