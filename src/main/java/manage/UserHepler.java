package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHepler extends HelperBase{
    public UserHepler(WebDriver wd) {
        super(wd);
    }
    public void fillLoginform(String email, String password) throws InterruptedException {
        type(By.cssSelector("#user"), email);
        click(By.cssSelector("#login"));
        Thread.sleep(5000);
        type(By.cssSelector("#password"), password);
    }
    public void initLogin() {
        click(By.cssSelector("[href='/login']"));

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
