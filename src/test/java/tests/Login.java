package tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @BeforeMethod
    public void preconditions() {
    if (app.getUser().isLogged()) {
    app.getUser().logOut();

}
    }
    @Test
    public void loginPositive() throws InterruptedException {
        app.getUser().initLogin();
        //Thread.sleep(10);
        app.getUser().fillLoginform("juliakliot.jk@gmail.com", "misha240613");
        app.getUser().submitLogin();

    }


}
