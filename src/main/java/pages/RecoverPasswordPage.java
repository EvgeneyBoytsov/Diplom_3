package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPage {

    private final WebDriver driver;

    private final By linkLogInAccount = By.className("Auth_link__1fOlj"); // ссылка Войти

    public RecoverPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по ссылке Войти на странице восстановления пароля")
    public void clickLinkInAccount() {
        driver.findElement(linkLogInAccount).click();
    }
}