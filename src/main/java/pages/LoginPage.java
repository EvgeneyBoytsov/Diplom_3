package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class LoginPage {

    private final WebDriver driver;
    private final By fieldEmail = By.cssSelector("input[name='name']"); // поле почта
    private final By fieldPassword = By.cssSelector("input[name='Пароль']"); // поле пароль
    private final By buttonLogIn = By.xpath(".//button[text()='Войти']"); // кнопка войти
    private final By registerLink = By.xpath(".//a[text()='Зарегистрироваться']"); // ссылка на страницу регистрации
    private final By passwordLink = By.xpath(".//a[text()='Восстановить пароль']"); // ссылка на старицу восстановления пароля
    private final By loadingPage = By.className("Modal_modal_overlay__x2ZCr"); // модальное окно ожидания загрузки страницы

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввод в поле email")
    public void inputEmail(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
    }

    @Step("Ввод в поле password")
    public void inputPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
    }

    @Step("Клик по кнопке Войти на странице входа в аккаунт")
    public void clickButtonLogIn() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(buttonLogIn));

        driver.findElement(buttonLogIn).click();
    }

    @Step("Клик по ссылке Зарегистрироваться на странице входа в аккаунт")
    public RegistrationPage clickLinkRegister() {
        driver.findElement(registerLink).click();

        return new RegistrationPage(driver);
    }

    @Step("Клик по ссылке Восстановить пароль на странице входа в аккаунт")
    public RecoverPasswordPage clickLinkPassword() {
        driver.findElement(passwordLink).click();

        return new RecoverPasswordPage(driver);
    }

    @Step("Проверка отображения страницы входа в аккаунт")
    public void checkOpenPageLogInAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.invisibilityOfElementLocated(loadingPage));

        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonLogIn));

        assertTrue(driver.findElement(buttonLogIn).isDisplayed());
    }

    @Step("Авторизация пользователя")
    public void loginOnClickLogAccountButton(String email, String password) {
        inputEmail(email);
        inputPassword(password);
        clickButtonLogIn();
    }
}