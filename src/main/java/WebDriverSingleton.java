import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton() {
    }

    public static synchronized WebDriver getInstance(OS os, BROWSER browser) {
        if (driver == null) {
            switch (os) {
                case WINDOWS:
                    if (browser == BROWSER.CHROME) {
                        System.setProperty("webdriver.chrome.driver", "/src/main/resources/chromedriver.exe");
                        driver = new ChromeDriver();
                    } else if (browser == BROWSER.FIREFOX) {
//                        System.setProperties("webdriver.gecko.driver", "/src/main/resources/geckodriver.exe");
                        driver = new FirefoxDriver();
                    } else if (browser == BROWSER.EDGE) {
                        driver = new EdgeDriver();
                    } else if (browser == BROWSER.IE) {
                        driver = new EdgeDriver();
                    }
                    break;
                case MAC:
                    if (browser == BROWSER.CHROME) {
                        System.setProperty("webdriver.chrome.driver", "/src/main/resources/chromedriver");
                        driver = new ChromeDriver();
                    } else if (browser == BROWSER.SAFARI) {
                        driver = new SafariDriver();
                    }
                    break;
            }
        }
        return driver;
    }

}
