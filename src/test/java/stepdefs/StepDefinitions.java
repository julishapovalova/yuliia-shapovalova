package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.ApplicationManager;
import driver.driverTry1.Browser;
import driver.driverTry1.BrowserFactory;
import driver.propeprties.BrowserTypes;
import pages.HomePage;
import pages.LoginPage;

public class StepDefinitions {
//    protected ApplicationManager app;
//
//    @Before
//    public void setUp() {
//        app = new ApplicationManager();
//        ApplicationManager.getThreadApplicationManager().set(app);
//
//    }
//
//    @When("^I login as \"([^\"]*)\"$")
//    public void iLoginAsAdmin(String role) {
//        LoginPage loginPage = new LoginPage();
//    }
//
//    @Then("^HomePage avaliable$")
//    public void homepageAvaliable() {
//        HomePage homePage = new HomePage();
//    }
//
//    @Given("^In \"([^\"]*)\" browser in session '(\\d+)'$")
//    public void inChromeBrowserInSession(String browserType, int session) {
//        app.setUpPropeties(browserType);
//        app = ApplicationManager.getInstance();
//    }
//
//    @After
//    public void closeBrowser() {
//        app.getWebDriverSingleton().getDriver().quit();
//    }

    Browser driver;

    @Before
    public void setUp() {

    }

    @When("^I login as \"([^\"]*)\"$")
    public void iLoginAsAdmin(String role) {
        driver.getInstance().get("https://www.journaldev.com/1392/factory-design-pattern-in-java");
      //  LoginPage loginPage = new LoginPage();
    }

    @Then("^HomePage avaliable$")
    public void homepageAvaliable() {
       // HomePage homePage = new HomePage();
    }

    @Given("^In \"([^\"]*)\" browser in session '(\\d+)'$")
    public void inChromeBrowserInSession(BrowserTypes browserType, int session) {
        driver = BrowserFactory.getInstance(browserType);

    }

    @After
    public void closeBrowser() {
   //     app.getWebDriverSingleton().getDriver().quit();
    }

}
