package pages;

import driver.configuration.WrapperWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;
    public BasePage(WrapperWebDriver wrapperWebDriver) {
        this.driver = wrapperWebDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public boolean checkIsOpen(String expectedTitle) {
        return driver.getTitle().contains(expectedTitle);
    }

}

