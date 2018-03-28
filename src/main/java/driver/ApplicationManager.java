package driver;

import driver.tech_driver.WebDriverSingleton;

public class ApplicationManager {

    private final String defaultBrowser = "FIREFOX";
    private final String defaultSite = "i.ua"; //EnvironmentProperties.getProperty(BaseDataProvider.URL);
    private static ThreadLocal<ApplicationManager> applicationManager = new ThreadLocal<ApplicationManager>();
    private static String browserType;
    private static String osType;
    private static String browserInfo;
    private WebDriverSingleton webDriverSingleton;

    public static ThreadLocal<ApplicationManager> getThreadApplicationManager() {
        return applicationManager;
    }

    public static ApplicationManager getInstance() {
        return applicationManager.get();
    }


    public WebDriverSingleton getWebDriverSingleton() {
        if (webDriverSingleton == null) {
            webDriverSingleton = new WebDriverSingleton(this);

        }
        return webDriverSingleton;
    }

    public void setUpPropeties() {
        browserType = System.getProperty("browser", defaultBrowser).trim();
    }

    public void setUpPropeties(String browserType) {
       this. browserType = System.getProperty("browser", browserType).trim();
    }

    public static String getBrowserType() {
        return browserType;
    }

    public static String getOsType() {
        return osType;
    }

    public static String getBrowserInfo() {
        return browserInfo;
    }

    public static void setBrowserInfo(String browserInfo) {
        ApplicationManager.browserInfo = browserInfo;
    }

}

