package pages.elements;

import pages.wrapper.Element;

public interface TextBox extends Element {
    void sendText(String text);
    void clear();

}
