package driver.propeprties;

public abstract interface BaseDataProvider {
    String envPropertiesFile = "src/test/resources/properties/instance.properties";
    String URL = "i.ua";
    int timeout_CHROME = 1000;
    int timeout_FIREFOX = 1000;
    int timeout_EDGE = 1000;
}
