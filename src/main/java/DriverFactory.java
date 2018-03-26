import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public static WebDriverSingleton getDriverInstance(BROWSER browserType, int session){
        WebDriver driver;
        switch (browserType)
        {
            case CHROME:
                driver= WebDriverSingleton.getInstance();
                break;
            case FIREFOX:
                return WebDriverSingleton.getInstance();
            break;

        }
        return driver;
    }
}
