package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions extends Hooks {

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
    public void inChromeBrowserInSession(String browser, int session) throws Throwable {
        // getDriverInstance(browser,session);
        driver.navigate().to("http://www.i.ua/");
    }

}
