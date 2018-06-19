package pages;

import driver.configuration.DriverHolder;
import driver.configuration.WrapperWebDriver;
import driver.propeprties.EnvironmentProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.Button;
import pages.elements.ButtonImpl;
import pages.elements.TextBox;
import pages.elements.TextBoxImpl;

public class HomePage extends BasePage {

    final static String URL = EnvironmentProperties.getProperty("URL");
    @FindBy(xpath = "//*[@name='login']")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@name='pass']")
    private WebElement passwordInput;

    @FindBy(xpath = "//form[@name='lform']/p/input")
    private WebElement loginButton;

    @FindBy(xpath = "li[class=first] b")
    private WebElement usernameLabel;

    @FindBy(id = "bmcounter")
    private WebElement usernameLabel1;

    public HomePage() {
        super( DriverHolder.getInstance());
    }

    public MailPage login() {
        TextBox wrappedEmailInput = new TextBoxImpl(emailInput);
        TextBox wrappedPasswordInput = new TextBoxImpl(passwordInput);
        Button wrappedLoginButton = new ButtonImpl(loginButton);
        wrappedEmailInput.sendKeys(EnvironmentProperties.getProperty("email"));
        wrappedPasswordInput.sendKeys(EnvironmentProperties.getProperty("password"));
        wrappedLoginButton.click();
        return new MailPage();
    }

    public String getUserName() {
        return usernameLabel.getText();
    }

    public static HomePage open() {
        DriverHolder.getInstance().get(URL);
        return new HomePage();
    }
}
