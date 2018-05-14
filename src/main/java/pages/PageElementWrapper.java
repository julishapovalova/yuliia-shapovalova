package pages;

import driver.Driver;
import driver.propeprties.EnvironmentProperties;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageElementWrapper {
    WebDriver driver;


    public PageElementWrapper(WebDriver driver) {
        this.driver = driver;

    }

    public void click(WebElement element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void submit() {

    }

    public void sendKeys(WebElement element, String charSequences) {
        if ("input".equals(element.getTagName())) {
            element.sendKeys(charSequences);
        } else {
            new Actions(driver).moveToElement(element).perform();

        }
//        Assert.assertEquals(charSequences, element.getText());
    }

    public String getTagName() {
        return null;
    }

    public String getAttribute(String s) {
        return null;
    }

    public boolean isSelected() {
        return false;
    }

    public boolean isEnabled() {
        return false;
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public List<WebElement> findElements(By by) {
        return null;
    }

    public WebElement findElement(By by) {
        return null;
    }

    public boolean isDisplayed() {
        return false;
    }

    public Point getLocation() {
        return null;
    }

    public Dimension getSize() {
        return null;
    }

    public Rectangle getRect() {
        return null;
    }

    public String getCssValue(String s) {
        return null;
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }
}
