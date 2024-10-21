import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegisterTest {

    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    @DisplayName("Тест регистрации пользователя при вводе валидных данных")
    public void userRegistrationTest() {

        WebDriver driver = factory.getDriver();
        var homePage = new HomePage(driver);

        homePage.open();
        LoginPage loginPage = homePage.clickButtonLogIn();

        RegistrationPage registerPage = loginPage.clickLinkRegister();
        registerPage.registrationUser();

        loginPage.checkPageLogInAccount();
    }

    @Test
    @DisplayName("Тест регистрации пользователя при вводе невалидных данных")
    public void userRegistrationWithInvalidedData() {

        WebDriver driver = factory.getDriver();
        var homePage = new HomePage(driver);

        homePage.open();
        LoginPage loginPage = homePage.clickButtonLogIn();

        RegistrationPage registerPage = loginPage.clickLinkRegister();
        registerPage.checkErrorPassword();
    }
}