import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.RecoverPasswordPage;
import pages.RegistrationPage;

public class LogInTest {
    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    @DisplayName("Тест авторизации при клике на кнопку Войти в аккаунт на главной странице")
    public void logInButtonLogTest() {

        WebDriver driver = factory.getDriver();
        var homePage = new HomePage(driver);

        homePage.open();
        LoginPage loginPage = homePage.clickButtonLogIn();

        loginPage.loginOnClickLogAccountButton();

        homePage.checkLogIn();
    }

    @Test
    @DisplayName("Тест авторизации при клике на кнопку Личный кабинет на главной странице")
    public void logInButtonPersonalCab() {

        WebDriver driver = factory.getDriver();
        var homePage = new HomePage(driver);
        var loginPage = new LoginPage(driver);

        homePage.open();
        homePage.clickButtonPersonalAccount();

        loginPage.loginOnClickLogAccountButton();

        homePage.checkLogIn();
    }

    @Test
    @DisplayName("Тест авторизации при клике на кнопку Войти в аккаунт на странице регистрации")
    public void logInRegPageTest() {
        WebDriver driver = factory.getDriver();
        var homePage = new HomePage(driver);

        homePage.open();
        LoginPage loginPage = homePage.clickButtonLogIn();

        RegistrationPage registerPage = loginPage.clickLinkRegister();

        registerPage.clickLinkIn();

        loginPage.loginOnClickLogAccountButton();

        homePage.checkLogIn();
    }

    @Test
    @DisplayName("Тест авторизации при клике на кнопку Войти в аккаунт на странице восстановления пароля")
    public void logInPasswordPageTest() {
        WebDriver driver = factory.getDriver();
        var homePage = new HomePage(driver);

        homePage.open();
        LoginPage loginPage = homePage.clickButtonLogIn();

        RecoverPasswordPage passwordPage =  loginPage.clickLinkPassword();
        passwordPage.clickLinkInAccount();

        loginPage.loginOnClickLogAccountButton();

        homePage.checkLogIn();
    }
}