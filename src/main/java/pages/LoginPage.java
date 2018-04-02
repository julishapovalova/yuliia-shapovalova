package pages;

import driver.DriverFactory;

public class LoginPage extends BasePage {

    public LoginPage() {
        super(DriverFactory.getInstance());
    }

    public LoginPage open() {
        return this;
    }
}
