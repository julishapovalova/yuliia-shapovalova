package pages;

import driver.DriverFactory;
import driver.configuration.DriverHolder;
import driver.configuration.WrapperWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailPage extends BasePage {
    @FindBy(css = ".user_name")
    private WebElement usernameLabel;

    @FindBy(css = ".ho_logo")
    private WebElement logoImage;

    public MailPage() {
        super(DriverHolder.getInstance());
    }

    public String getUserName() {
        return usernameLabel.getText();
    }

    public HomePage goToHomePage() {
        logoImage.click();
        return new HomePage();
    }
}
