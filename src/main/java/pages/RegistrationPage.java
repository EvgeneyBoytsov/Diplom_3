package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class RegistrationPage {
    private final WebDriver driver;

    private final By fieldName = By.cssSelector("input[name='name']"); // поле Имя
    private final By fieldEmail = By.cssSelector(".Auth_fieldset__1QzWN:nth-child(2) input.text_type_main-default"); // поле Почта
    private final By fieldPassword = By.cssSelector("input[name='Пароль']"); // поле Пароль
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");// кнопка Зарегистрироваться
    private final By errorMessage = By.xpath(".//p[text()='Некорректный пароль']"); // сообщение об неверном пароле
    private final By linkLogInAccount = By.className("Auth_link__1fOlj"); // ссылка Войти

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввод в поле Имя на странице регистрации")
    public void inputFieldName(String name) {
        driver.findElement(fieldName).sendKeys(name);
    }

    @Step("Ввод в поле Email на странице регистрации")
    public void inputFieldEmail(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
    }

    @Step("Ввод в поле Password на странице регистрации")
    public void inputFieldPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
    }

    @Step("Ввод в поле Password невалидного пароля на странице регистрации")
    public void inputFieldPasswordError() {
        driver.findElement(fieldPassword).sendKeys("123");
    }

    @Step("Клик по кнопке Зарегистрироваться")
    public void clickRegButton() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(registerButton));

        driver.findElement(registerButton).click();
    }

    @Step("Проверка отображения сообщения при вводе невалидного пароля")
    public void checkError() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(errorMessage));

        assertTrue(driver.findElement(errorMessage).isDisplayed());
    }

    @Step("Регистрация пользователя с валидными данными")
    public void registrationUser(String name, String email, String password) {
        inputFieldName(name);
        inputFieldEmail(email);
        inputFieldPassword(password);
        clickRegButton();
    }

    @Step("Регистрация пользователя с невалидными данными")
    public void checkErrorPassword(String name, String email) {
        inputFieldName(name);
        inputFieldEmail(email);
        inputFieldPasswordError();
        clickRegButton();
        checkError();
    }

    @Step("Клик по ссылке Войти на странице регистрации")
    public void clickLinkIn() {
        driver.findElement(linkLogInAccount).click();
    }
}