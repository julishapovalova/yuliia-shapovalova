package pages;

import driver.DriverFactory;

public class HomePage extends BasePage {
    public HomePage() {
        super(DriverFactory.getInstance());
    }
}
