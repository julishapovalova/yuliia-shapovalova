package driver;

import driver.propeprties.EnvironmentProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class EdgeDriver extends Driver {

    private DesiredCapabilities capabilities;

    EdgeDriver(int session) {
        initChrome();
        System.out.println("Init Chrome browser session " + session);
    }

    EdgeDriver() {
        initChrome();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    private void initChrome() {
        long implicitlyWait = Long.valueOf(EnvironmentProperties.getProperty("implicitly_Wait_EDGE"));
        long pageLoadTimeout = Long.valueOf(EnvironmentProperties.getProperty("page_Load_Timeout"));
        long explicityWait = Long.valueOf(EnvironmentProperties.getProperty("explicity_Wait_EDGE"));
        String url=EnvironmentProperties.getProperty("URL");

        capabilities = DesiredCapabilities.chrome();
        System.setProperty("webdriver.edge.driver", "src/main/resources/MicrosoftWebDriver.exe");
        driver = new org.openqa.selenium.edge.EdgeDriver();

        driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, explicityWait);

        driver.manage().window().maximize();
        driver.get(url);
    }
}
