package driver.driverTry1;

import driver.propeprties.EnvironmentProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class FireFoxBrowser extends Browser {

    private WebDriver driver;
    private DesiredCapabilities capabilities;

    @Override
    public WebDriver getInstance() {
        if (driver == null) {
            initFireFox();
        }
        return driver;
    }

    private void initFireFox() {
        capabilities = DesiredCapabilities.chrome();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        long timer = Long.valueOf(EnvironmentProperties.getProperty("timeout_CHROME"));
        driver.manage().timeouts().implicitlyWait(timer, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(EnvironmentProperties.getProperty("URL"));
    }
}
