import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

@Owner("Хуторова Марина")
@Epic("Epic-1 Регистрация / Авторизация / Безопасность (WEB)")
@Feature("US-1 Авторизация")
public class Authorization extends BaseTest {

    private StartPage startPage;
    private final String INVALID_EMAIL = "asd@mail.ru";
    private final String VALID_EMAIL = "teacher-507@mail.ru";
    private final String VALID_PASSWORD = "StarWars123";

    @BeforeClass
    void setPage() {
        startPage = new StartPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
    }

    @Test(description = "Вход с неверными данными")
    public void checkLoginWithInvalidDate() {
        startPage.clickButtonAmason();
        startPage.enterFieldEmail(INVALID_EMAIL);
        Assert.assertEquals(startPage.textInvalidMessage(),"Password reset required");
    }

    @Test(description = "Вход с верными данными и выход")
    public void checkLoginWithValidDate() {
        startPage.clickEnterWithEmail(VALID_EMAIL,VALID_PASSWORD);
        startPage.exit();
    }

}
