import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class PlaywrightTitleTest {

    private WebDriver driver;

    private void setUp(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
    }

    @Test
    public void testTitleInChrome() {
        setUp("chrome");

        driver.get("https://playwright.dev/");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Fast and reliable end-to-end testing for modern web apps | Playwright";

        Assertions.assertEquals(expectedTitle, actualTitle);

        driver.quit();
    }

    @Test
    public void testTitleInFirefox() {
        setUp("firefox");

        driver.get("https://playwright.dev/");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Fast and reliable end-to-end testing for modern web apps | Playwright";

        Assertions.assertEquals(expectedTitle, actualTitle);

        driver.quit();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


