package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverFactory;
import driver.propeprties.BrowserTypes;
import pages.HomePage;
import pages.LoginPage;

public class StepDefinitions {

    @Before
    public void setUp() {

    }

    @When("^I login as \"([^\"]*)\"$")
    public void iLoginAsAdmin(String role) {
        LoginPage loginPage = new LoginPage();
    }

    @Then("^HomePage avaliable$")
    public void homepageAvaliable() {
        HomePage homePage = new HomePage();
    }

    @Given("^In \"([^\"]*)\" browser in session '(\\d+)'$")
    public void inChromeBrowserInSession(BrowserTypes browserType, int session) {
        DriverFactory.inititateDriver(browserType,session);

    }


    @After
    public void closeBrowser() {
        DriverFactory.removeDriver();
    }

}
