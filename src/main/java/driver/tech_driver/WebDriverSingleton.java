package driver.tech_driver;

import driver.ApplicationManager;
import driver.propeprties.BaseDataProvider;
import driver.propeprties.BrowserTypes;
import driver.propeprties.EnvironmentProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;


public class WebDriverSingleton implements BaseDataProvider {

    private WebDriver driver;
    private final ApplicationManager manager;
    private DesiredCapabilities capabilities;


    public WebDriverSingleton(ApplicationManager manager) {
        String browser = ApplicationManager.getBrowserType();
        switch (BrowserTypes.valueOf(browser)) {
            case FIREFOX:
                initFireFox();
                break;
            case CHROME:
                initChrome();
                break;
            case EDGE:
                break;
            case IE:
                break;
            case SAFARI:
                break;
        }
        this.manager = manager;
    }

    private void initFireFox() {
        capabilities = DesiredCapabilities.firefox();
        driver = new FirefoxDriver();
        ApplicationManager.getInstance().setBrowserInfo(getBrowserInfo());
        long timer = Long.valueOf(EnvironmentProperties.getProperty("timeout_FIREFOX"));
        driver.manage().timeouts().implicitlyWait(timer, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(EnvironmentProperties.getProperty("URL"));

    }

    private void initChrome() {
        capabilities = DesiredCapabilities.chrome();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        ApplicationManager.getInstance().setBrowserInfo(getBrowserInfo());
        long timer = Long.valueOf(EnvironmentProperties.getProperty("timeout_CHROME"));
        driver.manage().timeouts().implicitlyWait(timer, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(EnvironmentProperties.getProperty("URL"));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getBrowserInfo() {
        return "";
    }
}
