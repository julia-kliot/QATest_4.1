package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.navigate().to("https://trello.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        wd.close();
        wd.quit();
    }




    public void click(By locator) {
        wd.findElement(locator).click();
    }
    public void initLogin() {
        click(By.cssSelector("[href='/login']"));

    }

    public void fillLoginform(String email, String password) throws InterruptedException {
        type(By.cssSelector("#user"), email);
        click(By.cssSelector("#login"));
        Thread.sleep(5000);
        type(By.cssSelector("#password"), password);
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }
    public void submitLogin() {
        click(By.cssSelector("#login-submit"));
    }

    public void logOut() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
        click(By.cssSelector("#logout-submit"));
    }
    public boolean isLogged() {
        return wd.findElements(By.cssSelector("[data-test-id='header-member-menu-button']")).size() > 0;
    }
}
