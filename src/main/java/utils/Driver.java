package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private static WebDriver firefoxDriver;
    private static WebDriver chromeDriver;
    private static WebDriver edgeDriver;

    // Приватный конструктор, чтобы запретить создание экземпляров класса извне
    private Driver() {
    }

    // Метод для получения экземпляра WebDriver для браузера Firefox
    public static WebDriver getFirefoxDriver() {
        if (firefoxDriver == null) {
            firefoxDriver = new FirefoxDriver();
            firefoxDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        }
        return firefoxDriver;
    }

    // Метод для получения экземпляра WebDriver для браузера Chrome
    public static WebDriver getChromeDriver() {
        if (chromeDriver == null) {
            chromeDriver = new ChromeDriver();
            chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        }
        return chromeDriver;
    }

    // Метод для получения экземпляра WebDriver для браузера Edge
    public static WebDriver getEdgeDriver() {
        if (edgeDriver == null) {
            edgeDriver = new EdgeDriver();
            edgeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        }
        return edgeDriver;
    }
}