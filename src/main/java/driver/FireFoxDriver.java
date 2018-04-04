package driver;

import driver.propeprties.EnvironmentProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FireFoxDriver extends Driver {

    private DesiredCapabilities capabilities;

    FireFoxDriver(int session) {
        initFireFox();
        System.out.println("Init FireFox browser session " + session);
    }


    public FireFoxDriver() {
        initFireFox();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }


    private void initFireFox() {
        long implicitlyWait = Long.valueOf(EnvironmentProperties.getProperty("implicitly_Wait_FIREFOX"));
        long pageLoadTimeout = Long.valueOf(EnvironmentProperties.getProperty("page_Load_Timeout"));
        long explicityWait = Long.valueOf(EnvironmentProperties.getProperty("explicity_Wait_FIREFOX"));


        capabilities = DesiredCapabilities.firefox();
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, explicityWait);
        driver.manage().window().maximize();
        driver.get(EnvironmentProperties.getProperty("URL"));
    }
}
