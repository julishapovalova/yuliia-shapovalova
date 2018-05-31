package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.wrapper.ElementImpl;

public class TextBoxImpl extends ElementImpl implements TextBox {

    public TextBoxImpl(WebElement emailInput) {
        super(emailInput);
    }

    @Override
    public void sendText(String text) {
        super.sendKeys(text);
    }
}
