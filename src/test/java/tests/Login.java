package tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @BeforeMethod
    public void preconditions() {
    if (isLogged()) {
    logOut();

}
    }
    @Test
    public void loginPositive() throws InterruptedException {
        initLogin();
        //Thread.sleep(10);
        fillLoginform("juliakliot.jk@gmail.com", "misha240613");
        submitLogin();

    }


}
