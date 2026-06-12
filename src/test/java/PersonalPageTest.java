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
import pages.PersonalAccountPage;

public class PersonalPageTest {
    private final UserClient client = new UserClient();
    private final UserCheck check = new UserCheck();
    User defaultUser = User.randomCreatedUser();
    String userAutToken;

    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    @DisplayName("Тест перехода в личный кабинет авторизованного пользователя")
    public void checkSwitchPersonalPage() {

        ValidatableResponse createdResponse = client.createUser(defaultUser);
        userAutToken = check.checkCreateUser(createdResponse);

        WebDriver driver = factory.getDriver();
        var homePage = new HomePage(driver);

        homePage.openStellarBurger();
        LoginPage loginPage = homePage.clickButtonLogIn();

        loginPage.loginOnClickLogAccountButton(defaultUser.getEmail(), defaultUser.getPassword());

        homePage.checkOpenLoginPage();
        PersonalAccountPage personalPage = homePage.clickButtonPersonalAccount();

        personalPage.checkOpenPersonalPage();
    }

    @After
    @DisplayName("Удаление пользователя")
    public void deleteUser() {
        if (userAutToken != null)
            client.deleteUser(StringUtils.substringAfter(userAutToken, " "));
    }
}
