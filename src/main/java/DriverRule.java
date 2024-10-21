import io.github.bonigarcia.wdm.WebDriverManager;

import io.qameta.allure.Step;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverRule extends ExternalResource {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @Override
    protected void before() {
        initDriver();
    }

    @Override
    protected void after() {
        driver.quit();
    }

    @Step("Выбор браузера")
    public void initDriver() {
        if ("firefox".equals(System.getProperty("browser"))) {
            startFireFox();
        }
        else {
            startChrome();
        }
    }

    @Step("Запуск ChromeDriver")
    public void startChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Step("Запуск FirefoxDriver")
    public void startFireFox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
}