package pages;

import driver.configuration.WrapperWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        if (driver.getClass().getName().contains("WrapperWebDriver")) {
            this.driver = ((WrapperWebDriver) driver).getDriver();
        } else {
            this.driver = driver;
        }
        PageFactory.initElements(this.driver, this);
    }

    public boolean checkIsOpen(String expectedTitle) {
        return driver.getTitle().contains(expectedTitle);
    }

}

