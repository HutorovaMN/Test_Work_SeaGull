import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class StartPage extends BaseTest {
    protected WebDriver driver;

    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@class='gr-button gr-button--amazon gr-button--fullWidth gr-button--auth']")
    private WebElement buttonAmason;

    @Step("Кликнуть по кнопке Войти")
    public void clickButtonAmason() {
        buttonAmason.click();
    }

    @FindBy(xpath = "//input[@type='email']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement buttonContinue;

    @FindBy(xpath = "//h2[@class='a-text-normal']")
    private WebElement invalidMessage;

    @FindBy(xpath = "//a[@class='gr-button gr-button--fullWidth gr-button--auth gr-button--dark']")
    private WebElement enterWithEmail;

    @FindBy(xpath = "//a[@class='a-link-emphasis']")
    private WebElement enterLink;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//span[@class='headerPersonalNav__icon']")
    private WebElement user;

    @FindBy(xpath = "(//li[@role='menuitem Sign out'])[1]")
    private WebElement signOut;

    @FindBy(xpath = "//button[@class=\"gr-iconButton\"]\n")
    private WebElement buttonClose;

    @Step("Выход из приложения")
    public void exit() {
        buttonClose.click();
        user.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        signOut.click();
    }

    @Step("Ввод валидных данных")
    public void clickEnterWithEmail(String email, String password) {
        enterWithEmail.click();
        enterLink.click();
        fieldEmail.sendKeys(email);
        passwordField.sendKeys(password);
        buttonSubmit.click();
    }

    @Step("Текст сообщения об ошибке")
    public String textInvalidMessage() {
        return invalidMessage.getText();
    }

    @Step("Ввести Email")
    public void enterFieldEmail(String email) {
        fieldEmail.click();
        fieldEmail.sendKeys(email);
        buttonContinue.click();
    }
}
