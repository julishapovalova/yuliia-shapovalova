package pages;

import driver.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailPage extends BasePage {
    @FindBy(css = ".user_name")
    private WebElement usernameLabel;

    @FindBy(css = ".ho_logo")
    private WebElement logoImage;

    public MailPage() {
        super(DriverFactory.getInstance());
    }

    public String getUserName() {
        return usernameLabel.getText();
    }

    public HomePage goToHomePage(){
        logoImage.click();
        return new HomePage();
    }
}
