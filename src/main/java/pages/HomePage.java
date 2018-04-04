package pages;

import driver.DriverFactory;
import driver.propeprties.EnvironmentProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@name='login']")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@name='pass']")
    private WebElement passwordInput;

    @FindBy(xpath = "//form[@name='lform']/p/input")
    private WebElement loginButton;

    @FindBy(xpath = "li[class=first] b")
    private WebElement usernameLabel;

    public HomePage() {
        super(DriverFactory.getInstance());
    }

    public MailPage login() {
        emailInput.sendKeys(EnvironmentProperties.getProperty("email"));
        passwordInput.sendKeys(EnvironmentProperties.getProperty("password"));
        loginButton.click();
        return new MailPage();
    }

    public String getUserName() {
        return usernameLabel.getText();
    }
}
