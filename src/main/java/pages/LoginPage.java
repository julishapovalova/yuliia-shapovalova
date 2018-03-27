package pages;

import driver.ApplicationManager;

public class LoginPage extends BasePage {

    public LoginPage() {
        super(ApplicationManager.getInstance());
    }

    public LoginPage open() {
        return new LoginPage();
    }
}
