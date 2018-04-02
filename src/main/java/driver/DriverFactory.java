package driver;

import driver.propeprties.BrowserTypes;

public class DriverFactory {

    private static final ThreadLocal<Driver> DRIVER = new ThreadLocal<Driver>();

    public static Driver getInstance() {
        return DRIVER.get();
    }

    public static void inititateDriver(BrowserTypes browser, int session) {
        if (DRIVER.get() == null) {
            switch (browser) {
                case CHROME:
                    DRIVER.set(new ChromeDriver(session));
                    break;
                case FIREFOX:
                    DRIVER.set(new FireFoxDriver(session));
                    break;
            }
        }
    }

    public static void removeDriver() {
            DRIVER.get().close();
            DRIVER.remove();
    }
}
