package pages.wrapper;

import driver.Driver;
import driver.propeprties.EnvironmentProperties;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebElementAdaptee {
    WebDriver driver;
    private final long explicitlyTimeout = Long.valueOf(EnvironmentProperties.getProperty("explicitly.timeout"));

    public WebElementAdaptee(WebDriver driver) {
        this.driver = driver;
    }

    public void click(WebElement element) {
        new WebDriverWait(driver, explicitlyTimeout).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }


    public void submit() {

    }

    public void sendKeys(CharSequence... charSequences) {

    }

    public void clear() {

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

    public String getText() {
        return null;
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public boolean isDisplayed() {
        return false;
    }

}
