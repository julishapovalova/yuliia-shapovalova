package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Driver {
    public WebDriverWait wait;

    public abstract WebDriver getDriver();

    public abstract void close();

}
