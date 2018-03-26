package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public WebDriver driver;

    public Hooks() {
        driver = null;
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
}


    @After
    public void closeBrowser() {
        driver.quit();
    }
}
