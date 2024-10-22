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

public class ConstructorTest {

    private final UserClient client = new UserClient();
    private final UserCheck check = new UserCheck();
    User defaultUser = User.randomCreatedUser();
    String userAutToken;

    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    @DisplayName("Тест перехода из личного кабинета в раздел конструктор по клику на кнопку Конструктор")
    public void constructorButtonTest() {

        ValidatableResponse createdResponse = client.createUser(defaultUser);
        userAutToken = check.checkCreatedUser(createdResponse);

        WebDriver driver = factory.getDriver();
        var homePage = new HomePage(driver);

        homePage.open();
        LoginPage loginPage = homePage.clickButtonLogIn();

        loginPage.loginOnClickLogAccountButton(defaultUser.getEmail(), defaultUser.getPassword());

        homePage.checkOpenLoginPage();
        PersonalAccountPage personalPage = homePage.clickButtonPersonalAccount();

        personalPage.checkOpenPersonalPage();
        personalPage.clickLinkConstructor();

        homePage.checkOpenBurgerConstructor();
    }

    @Test
    @DisplayName("Тест перехода из личного кабинета в раздел конструктор по клику на логотип")
    public void logotypeButtonTest() {

        ValidatableResponse createdResponse = client.createUser(defaultUser);
        userAutToken = check.checkCreatedUser(createdResponse);

        WebDriver driver = factory.getDriver();
        var homePage = new HomePage(driver);

        homePage.open();
        LoginPage loginPage = homePage.clickButtonLogIn();

        loginPage.loginOnClickLogAccountButton(defaultUser.getEmail(), defaultUser.getPassword());

        homePage.checkOpenLoginPage();
        PersonalAccountPage personalPage = homePage.clickButtonPersonalAccount();

        personalPage.checkOpenPersonalPage();
        personalPage.clickLogotype();

        homePage.checkOpenBurgerConstructor();
    }

    @Test
    @DisplayName("Тест перехода в раздел Начинки по клику на кнопку Начинки")
    public void fillingButtonTest() {

        WebDriver driver = factory.getDriver();
        var homePage = new HomePage(driver);

        homePage.checkConstructorFillingSection();

    }

    @Test
    @DisplayName("Тест перехода в раздел Соусы по клику на кнопку Соусы")
    public void sauceButtonTest() {
        WebDriver driver = factory.getDriver();
        var homePage = new HomePage(driver);

        homePage.checkConstructorSauceSection();
    }

    @Test
    @DisplayName("Тест перехода в раздел Булки по клику на кнопку Булки")
    public void bunButtonTest() {
        WebDriver driver = factory.getDriver();
        var homePage = new HomePage(driver);

        homePage.checkConstructorBunSection();
    }

    @After
    @DisplayName("Удаление пользователя")
    public void deleteUser() {
        if (userAutToken != null)
            client.delete(StringUtils.substringAfter(userAutToken, " "));
    }
}