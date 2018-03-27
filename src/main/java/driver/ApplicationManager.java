package driver;

import driver.propeprties.BaseDataProvider;
import driver.propeprties.BrowserTypes;
import driver.propeprties.EnvironmentProperties;

import static driver.propeprties.BrowserTypes.FIREFOX;

public class ApplicationManager {

    private final BrowserTypes defaultBrowserTypes = FIREFOX;
    private final String defaultSite = EnvironmentProperties.getProperty(BaseDataProvider.URL);
    private static ThreadLocal<ApplicationManager> applicationManager = new ThreadLocal<ApplicationManager>();

}

