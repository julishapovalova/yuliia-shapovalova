package pages.wrapper;

import driver.configuration.DriverHolder;
import driver.configuration.WrapperWebDriver;
import driver.propeprties.EnvironmentProperties;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.util.List;

public class ElementImpl extends BasePage implements Element {

    private final long TIMEOUT = Long.valueOf(EnvironmentProperties.getProperty("explicitly.timeout"));
    private final WebElement element;

    protected ElementImpl(final WebElement element) {
        super(DriverHolder.getInstance());
        this.element = element;
    }

    @Override
    public boolean elementWired() {
        return false;
    }

    @Override
    public void click() {
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }


    @Override
    public void submit() {

    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        if ("input".equals(element.getTagName())) {
            element.sendKeys(charSequences);
        } else {
            new Actions(driver).moveToElement(element).perform();

        }
    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String s) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return element.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String s) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }

    @Override
    public Coordinates getCoordinates() {
        return null;
    }

    @Override
    public WebElement getWrappedElement() {
        return null;
    }
}
