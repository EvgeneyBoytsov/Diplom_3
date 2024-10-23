import api.User;
import api.UserCheck;
import api.UserClient;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.RecoverPasswordPage;
import pages.RegistrationPage;

public class LogInTest {

    private final UserClient client = new UserClient();
    private final UserCheck check = new UserCheck();
    User defaultUser = User.randomCreatedUser();
    String userAutToken;

    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    @DisplayName("Тест авторизации при клике на кнопку Войти в аккаунт на главной странице")
    public void checkLoginUserWithClickButtonLogin() {

        ValidatableResponse createdResponse = client.createUser(defaultUser);
        userAutToken = check.checkCreateUser(createdResponse);

        WebDriver driver = factory.getDriver();
        var homePage = new HomePage(driver);

        homePage.openStellarBurger();
        LoginPage loginPage = homePage.clickButtonLogIn();

        loginPage.loginOnClickLogAccountButton(defaultUser.getEmail(), defaultUser.getPassword());

        homePage.checkOpenLoginPage();
    }

    @Test
    @DisplayName("Тест авторизации при клике на кнопку Личный кабинет на главной странице")
    public void checkLoginUserWithClickButtonPersonalAccount() {

        ValidatableResponse createdResponse = client.createUser(defaultUser);
        userAutToken = check.checkCreateUser(createdResponse);

        WebDriver driver = factory.getDriver();
        var homePage = new HomePage(driver);
        var loginPage = new LoginPage(driver);

        homePage.openStellarBurger();
        homePage.clickButtonPersonalAccount();

        loginPage.loginOnClickLogAccountButton(defaultUser.getEmail(), defaultUser.getPassword());

        homePage.checkOpenLoginPage();
    }

    @Test
    @DisplayName("Тест авторизации при клике на кнопку Войти в аккаунт на странице регистрации")
    public void checkLoginUserWithClickRegistrationLink() {
        WebDriver driver = factory.getDriver();
        var homePage = new HomePage(driver);

        ValidatableResponse createdResponse = client.createUser(defaultUser);
        userAutToken = check.checkCreateUser(createdResponse);

        homePage.openStellarBurger();
        LoginPage loginPage = homePage.clickButtonLogIn();

        RegistrationPage registerPage = loginPage.clickLinkRegister();

        registerPage.clickLinkIn();

        loginPage.loginOnClickLogAccountButton(defaultUser.getEmail(), defaultUser.getPassword());

        homePage.checkOpenLoginPage();
    }

    @Test
    @DisplayName("Тест авторизации при клике на кнопку Войти в аккаунт на странице восстановления пароля")
    public void checkLoginUserWithClickRecoverPasswordLink() {
        WebDriver driver = factory.getDriver();
        var homePage = new HomePage(driver);

        ValidatableResponse createdResponse = client.createUser(defaultUser);
        userAutToken = check.checkCreateUser(createdResponse);

        homePage.openStellarBurger();
        LoginPage loginPage = homePage.clickButtonLogIn();

        RecoverPasswordPage passwordPage =  loginPage.clickLinkPassword();
        passwordPage.clickLinkInAccount();

        loginPage.loginOnClickLogAccountButton(defaultUser.getEmail(), defaultUser.getPassword());

        homePage.checkOpenLoginPage();
    }

    @After
    @DisplayName("Удаление пользователя")
    public void deleteUser() {
        if (userAutToken != null)
            client.deleteUser(StringUtils.substringAfter(userAutToken, " "));
    }
}