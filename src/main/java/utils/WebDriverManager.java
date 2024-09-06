package utils;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {

    // Метод для получения экземпляра WebDriver в зависимости от имени браузера
    public static WebDriver getDriver(String browserName) {
        return switch (browserName.toLowerCase()) {
            case "firefox" -> Driver.getFirefoxDriver();
            case "chrome" -> Driver.getChromeDriver();
            case "edge" -> Driver.getEdgeDriver();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browserName);
        };
    }
}