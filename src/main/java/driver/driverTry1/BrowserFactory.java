package driver.driverTry1;

import driver.propeprties.BrowserTypes;

public class BrowserFactory {

    public static synchronized Browser getInstance(BrowserTypes type) {
        switch (type) {
            case CHROME:
                return new ChromeBrowser();
            case FIREFOX:
                return new FireFoxBrowser();
        }
        return null;
    }
}
