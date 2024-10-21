package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class PersonalAccountPage {
    private final WebDriver driver;
    private final By buttonOutAccount = By.className("Account_button__14Yp3"); // кнопка Выход
    private final By linkConstructor = By.xpath(".//p[text()='Конструктор']"); // ссылка на раздел Конструктор
    private final By logotype = By.className("AppHeader_header__logo__2D0X2"); // логотип на главной странице
    private final By loadingPage = By.className("Modal_modal_overlay__x2ZCr"); // модальное окно ожидания загрузки страницы

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке Выход в личном кабинете")
    public void clickButtonOutAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.invisibilityOfElementLocated(loadingPage));

        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(buttonOutAccount));

        driver.findElement(buttonOutAccount).click();
    }

    @Step("Клик по кнопке Конструктор в личном кабинете")
    public void clickLinkConstructor() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.invisibilityOfElementLocated(loadingPage));

        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(linkConstructor));

        driver.findElement(linkConstructor).click();
    }

    @Step("Клик по логотипу в личном кабинете")
    public void clickLogotype() {

        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.invisibilityOfElementLocated(loadingPage));

        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(logotype));

        driver.findElement(logotype).click();
    }

    @Step("Проверка отображения личного кабинета после авторизации")
    public void checkPersonal() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.invisibilityOfElementLocated(loadingPage));

        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonOutAccount));

        assertTrue(driver.findElement(buttonOutAccount).isDisplayed());
    }
}