package pages;

import driver.DriverFactory;
import driver.configuration.DriverHolder;
import driver.configuration.WrapperWebDriver;

public class LoginPage extends BasePage {

    public LoginPage() {
        super(DriverHolder.getInstance());
    }

    public LoginPage open() {
        return this;
    }
}
