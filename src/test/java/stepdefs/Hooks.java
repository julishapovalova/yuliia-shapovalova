package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.DriverFactory;

public class Hooks extends DriverFactory {

    @Before
    public void setUp() {
        getInstance();
    }

    @After
    public void tearDownScenario() {
        removeDriver();
    }
}
