package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.DriverFactory;
import driver.configuration.DriverHolder;

public class Hooks {

    @Before
    public void setUp() {
        DriverHolder.getInstance();
    }

    @After
    public void tearDownScenario() {
        DriverHolder.getInstance().quit();
    }
}
