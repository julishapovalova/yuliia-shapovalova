package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.Driver;
import driver.DriverFactory;
import driver.configuration.DriverHolder;
import driver.propeprties.BrowserTypes;
import org.junit.Assert;
import pages.HomePage;
import pages.MailPage;

public class StepDefinitions extends BaseSteps {
    MailPage mailPage;

    @When("^I login as \"([^\"]*)\"$")
    public void iLoginAsAdmin(String USER) {
        HomePage homePage = HomePage.open();

        mailPage = homePage.login();

        Assert.assertEquals(mailPage.getUserName(), USER);
    }

    @Then("^HomePage avaliable$")
    public void homepageAvaliable() {
        mailPage.goToHomePage();
    }

    @Given("^In \"([^\"]*)\" browser in session '(\\d+)'$")
    public void inChromeBrowserInSession(BrowserTypes browserType, int session) {
        DriverHolder.getInstance();
    }

    @When("^I send mail \"([^\"]*)\" for '([^\"]*)'$")
    public void iSendMailForSmb(String message,String whom) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
