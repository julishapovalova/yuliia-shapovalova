package driver;

import driver.propeprties.EnvironmentProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

import java.util.List;
import java.util.Set;

class WrapperWebDriver implements WebDriver {
    private WebDriver driver;
    private WebDriverWait wait;

    WrapperWebDriver(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Long.valueOf(EnvironmentProperties.getProperty("explicity_Wait_CHROME")));
    }

    public void get(String url) {
        try {
            driver.get(url);
            wait.until(ExpectedConditions.urlToBe(url));
        } catch (TimeoutException e) {
            driver.quit();

        }
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

    }

    public void quit() {

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
}
