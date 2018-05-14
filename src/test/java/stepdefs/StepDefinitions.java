package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverFactory;
import driver.propeprties.BrowserTypes;
import org.junit.Assert;
import pages.HomePage;
import pages.MailPage;

public class StepDefinitions extends DriverFactory {

    @When("^I login as \"([^\"]*)\"$")
    public void iLoginAsAdmin(String USER) {
        MailPage mailPage = new HomePage().login();

        Assert.assertEquals(mailPage.getUserName(), USER);

        mailPage.goToHomePage();
    }

    @Then("^HomePage avaliable$")
    public void homepageAvaliable() {

        HomePage homePage = new HomePage();
    }

    @Given("^In \"([^\"]*)\" browser in session '(\\d+)'$")
    public void inChromeBrowserInSession(BrowserTypes browserType, int session) {
        getInstance();
    }

}
