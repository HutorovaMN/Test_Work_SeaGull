import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static utils.WebDriverManager.getDriver;


public class BaseTest {

    protected StartPage startPage;
    protected WebDriver driver;

    @Getter
    private static final String BASE_URL = "https://www.goodreads.com";

    @BeforeClass
    @Parameters("browser")
    public void load(@Optional("edge") String browser) {
        switch (browser) {
            case "firefox" -> {
                driver = getDriver("firefox");
                driver.manage().window().maximize();
            }

            case "chrome" -> {
                driver = getDriver("chrome");
                driver.manage().window().maximize();
            }

            case "edge" -> {
                driver = getDriver("edge");
                driver.manage().window().maximize();
            }
        }
    }


    @BeforeMethod
    public void openBaseUrl() {
        driver.get(BASE_URL);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}