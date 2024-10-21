package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class HomePage {

    private final WebDriver driver;

    private final By orderButton = By.className("button_button_size_large__G21Vg"); // кнопка оформить заказа
    private final By burgerConstructor = By.className("BurgerIngredients_ingredients__1N8v2"); // раздел конструктора бургера
    private final By sauceButton = By.xpath(".//span[text()='Соусы']"); //  кнопка Соусы
    private final By bunButton = By.xpath(".//span[text()='Булки']"); //  кнопка Булки
    private final By fillingButton = By.xpath(".//span[text()='Начинки']"); //  кнопка Начинки
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']"); // кнопка личный кабинет
    private final By fieldFilling = By.xpath(".//h2[text()='Начинки']"); // ссылка на раздел Начинки в конструкторе бургера
    private final By lastFilling = By.cssSelector("img[alt='Сыр с астероидной плесенью']"); // ссылка на последний элемент раздела Начинки в конструкторе бургера
    private final By fieldSauce = By.xpath(".//h2[text()='Соусы']"); // ссылка на раздел Соусы в конструкторе бургера
    private final By fieldBun = By.xpath(".//h2[text()='Булки']"); // ссылка на раздел Булки в конструкторе бургера
    private final By buttonEnterAccount = By.xpath(".//button[text()='Войти в аккаунт']"); // кнопка Войти в аккаунт
    private final By loadingPage = By.className("Modal_modal_overlay__x2ZCr"); // модальное окно ожидания загрузки страницы

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Переход на сайт Stellar Burger")
    public void open() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.invisibilityOfElementLocated(loadingPage));

        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.invisibilityOfElementLocated(loadingPage));
        driver.get(EnvConfig.BASE_URL);
    }

    @Step("Клик на кнопку Войти в аккаунт")
    public LoginPage clickButtonLogIn() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.invisibilityOfElementLocated(loadingPage));

        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(buttonEnterAccount));

        driver.findElement(buttonEnterAccount).click();

        return new LoginPage(driver);
    }

    @Step("Клик на кнопку Личный кабинет")
    public PersonalAccountPage clickButtonPersonalAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.invisibilityOfElementLocated(loadingPage));

        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(personalAccountButton));

        driver.findElement(personalAccountButton).click();

        return new PersonalAccountPage(driver);
    }

    @Step("Клик на кнопку Булки")
    public void clickBun() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.invisibilityOfElementLocated(loadingPage));

        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(bunButton));

        driver.findElement(bunButton).click();
    }

    @Step("Клик на кнопку Соусы")
    public void clickSauce() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.invisibilityOfElementLocated(loadingPage));

        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(sauceButton));

        driver.findElement(sauceButton).click();
    }

    @Step("Клик на кнопку Начинки")
    public void clickFilling() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.invisibilityOfElementLocated(loadingPage));

        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(fillingButton));

        driver.findElement(fillingButton).click();
    }

    @Step("Проверка открытия главной страницы после авторизации")
    public void checkLogIn() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.invisibilityOfElementLocated(loadingPage));

        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));

        assertTrue(driver.findElement(orderButton).isDisplayed());
    }

    @Step("Проверка открытия конструктора бургера")
    public void checkBurgerConstructor() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.invisibilityOfElementLocated(loadingPage));

        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(burgerConstructor));

        assertTrue(driver.findElement(burgerConstructor).isDisplayed());
    }

    @Step("Проверка открытия в раздел Булки")
    public void checkBunSection() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.invisibilityOfElementLocated(loadingPage));

        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(fieldBun));

        assertTrue(driver.findElement(fieldBun).isDisplayed());
    }

    @Step("Проверка открытия в раздел Соусы")
    public void checkSauceSection() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.invisibilityOfElementLocated(loadingPage));

        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(fieldSauce));

        assertTrue(driver.findElement(fieldSauce).isDisplayed());
    }

    @Step("Скролл до последнего элемента в разделе Начинки")
    public void scrollLastFilling() {
        WebElement element = driver.findElement(By.cssSelector("img[alt='Сыр с астероидной плесенью']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    @Step("Проверка открытия в раздел Начинки")
    public void checkFillingSection() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.invisibilityOfElementLocated(loadingPage));

        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(fieldFilling));

        assertTrue(driver.findElement(fieldFilling).isDisplayed());
    }

    @Step("Проверка отображения  последнего элемента в разделе Начинки")
    public void checkLastFilling() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.invisibilityOfElementLocated(loadingPage));

        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(lastFilling));

        assertTrue(driver.findElement(lastFilling).isDisplayed());
    }

    @Step("Проверка перехода в раздел Начинки")
    public void checkConstructorFillingSection() {
        open();
        clickFilling();
        checkFillingSection();
        scrollLastFilling();
        checkLastFilling();
    }

    @Step("Проверка перехода в раздел Соусы")
    public void checkConstructorSauceSection() {
        open();
        clickFilling();
        clickSauce();
        checkSauceSection();
    }

    @Step("Проверка перехода в раздел Булки")
    public void checkConstructorBunSection() {
        open();
        clickFilling();
        clickBun();
        checkBunSection();
    }
}