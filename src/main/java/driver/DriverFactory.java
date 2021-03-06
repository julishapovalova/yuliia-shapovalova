package driver;

import driver.propeprties.BrowserTypes;
import driver.propeprties.EnvironmentProperties;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static final ThreadLocal<Driver> DRIVER = new ThreadLocal<Driver>();

    public static synchronized Driver getInstance() {
        if (DRIVER.get() == null) {
            switch (BrowserTypes.valueOf(EnvironmentProperties.getProperty("browser"))) {
                case CHROME:
                    DRIVER.set(new ChromeDriver());
                    break;
                case FIREFOX:
                    DRIVER.set(new FireFoxDriver());
                    break;
                case EDGE:
                    DRIVER.set(new EdgeDriver());
                    break;
            }
        }
        return DRIVER.get();
    }

    public static void removeDriver() {
        DRIVER.get().wrapperWebDriver.quit();
        DRIVER.remove();
    }

    public static void refresh() {
        DRIVER.get().wrapperWebDriver.refresh();
    }

}
