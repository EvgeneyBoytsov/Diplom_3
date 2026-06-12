import api.User;
import api.UserClient;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegisterTest {

    private final UserClient client = new UserClient();
    String userAutToken;

    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    @DisplayName("Тест регистрации пользователя при вводе валидных данных")
    public void checkUserRegistration() {
        User defaultUser = User.randomCreatedUser();

        WebDriver driver = factory.getDriver();
        var homePage = new HomePage(driver);

        homePage.openStellarBurger();
        LoginPage loginPage = homePage.clickButtonLogIn();

        RegistrationPage registerPage = loginPage.clickLinkRegister();
        registerPage.registrationUser(defaultUser.getName(),defaultUser.getEmail(),defaultUser.getPassword());

        loginPage.checkOpenPageLogInAccount();
        loginPage.loginOnClickLogAccountButton(defaultUser.getEmail(), defaultUser.getPassword());

        homePage.checkOpenLoginPage();

        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        userAutToken = localStorage.getItem("accessToken");
    }

    @Test
    @DisplayName("Тест регистрации пользователя при вводе невалидных данных")
    public void checkUserRegistrationWithInvalidedData() {

        User defaultUser = User.randomCreatedUser();

        WebDriver driver = factory.getDriver();
        var homePage = new HomePage(driver);

        homePage.openStellarBurger();
        LoginPage loginPage = homePage.clickButtonLogIn();

        RegistrationPage registerPage = loginPage.clickLinkRegister();
        registerPage.checkErrorPassword(defaultUser.getName(),defaultUser.getEmail());
    }

    @After
    @DisplayName("Удаление пользователя")
    public void deleteUser() {
        if (userAutToken != null)
            client.deleteUser(StringUtils.substringAfter(userAutToken, " "));
    }
}