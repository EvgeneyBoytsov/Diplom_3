import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.PersonalAccountPage;

public class LogOutTest {
    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    @DisplayName("Тест выхода из аккаунта при клике на кнопку Выход в личном кабинете")
    public void logOutAccountTest() {

        WebDriver driver = factory.getDriver();
        var homePage = new HomePage(driver);

        homePage.open();
        LoginPage loginPage = homePage.clickButtonLogIn();

        loginPage.loginOnClickLogAccountButton();

        homePage.checkLogIn();
        PersonalAccountPage personalPage = homePage.clickButtonPersonalAccount();

        personalPage.checkPersonal();
        personalPage.clickButtonOutAccount();

        loginPage.checkPageLogInAccount();
    }
}