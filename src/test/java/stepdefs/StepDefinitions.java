package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.propeprties.BrowserTypes;
import com.DriverFactory;
import driver.WebDriverSingleton;

public class StepDefinitions {
    public WebDriverSingleton driver = null;

    @Before
    public void setUp() {
    }

    @When("^I login as \"([^\"]*)\"$")
    public void iLoginAsAdmin(String role) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^HomePage avaliable$")
    public void homepageAvaliable() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^In \"([^\"]*)\" browser in session '(\\d+)'$")
    public void inChromeBrowserInSession(BrowserTypes browserTypes, int session) throws Throwable {
        driver = DriverFactory.getDriverInstance(browserTypes, 1);
        driver.get("i.ua");
    }


    @After
    public void closeBrowser() {
        driver.quit();
    }

}
