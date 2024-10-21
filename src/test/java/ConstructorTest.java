import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.PersonalAccountPage;

public class ConstructorTest {
    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    @DisplayName("Тест перехода из личного кабинета в раздел конструктор по клику на кнопку Конструктор")
    public void constructorButtonTest() {
        WebDriver driver = factory.getDriver();
        var homePage = new HomePage(driver);

        homePage.open();
        LoginPage loginPage = homePage.clickButtonLogIn();

        loginPage.loginOnClickLogAccountButton();

        homePage.checkLogIn();
        PersonalAccountPage personalPage = homePage.clickButtonPersonalAccount();

        personalPage.checkPersonal();
        personalPage.clickLinkConstructor();

        homePage.checkBurgerConstructor();
    }

    @Test
    @DisplayName("Тест перехода из личного кабинета в раздел конструктор по клику на логотип")
    public void logotypeButtonTest() {

        WebDriver driver = factory.getDriver();
        var homePage = new HomePage(driver);

        homePage.open();
        LoginPage loginPage = homePage.clickButtonLogIn();

        loginPage.loginOnClickLogAccountButton();

        homePage.checkLogIn();
        PersonalAccountPage personalPage = homePage.clickButtonPersonalAccount();

        personalPage.checkPersonal();
        personalPage.clickLogotype();

        homePage.checkBurgerConstructor();
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
}