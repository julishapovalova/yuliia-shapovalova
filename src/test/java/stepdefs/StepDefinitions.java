package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.ApplicationManager;
import pages.HomePage;
import pages.LoginPage;
import sun.rmi.runtime.Log;

public class StepDefinitions {
    protected ApplicationManager app;

    @Before
    public void setUp() {
        app = new ApplicationManager();
        ApplicationManager.getThreadApplicationManager().set(app);

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
    public void inChromeBrowserInSession(String browserType, int session) {
        app.setUpPropeties(browserType);
        app = ApplicationManager.getInstance();
    }


    @After
    public void closeBrowser() {
        app.getWebDriverSingleton().getDriver().quit();
    }

}
