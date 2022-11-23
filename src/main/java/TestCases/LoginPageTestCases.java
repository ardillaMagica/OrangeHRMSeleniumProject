package TestCases;

import Core.BaseDriver;
import Mapping.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginPageTestCases extends BaseDriver {
    @BeforeTest
    public void LoginTestCases(){
        startSession();
        PageFactory.initElements(driver, LoginPage.class);
    }

    @Test(groups ={"Regression"}, priority = 1)
    public void emptyCredLoginTest() throws InterruptedException{
        Thread.sleep(5000);
        LoginPage.loginButton.click();
        Thread.sleep(5000);
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(LoginPage.usernameRequiredMessage.getText(), "Required");
        softAssertion.assertEquals(LoginPage.passwordRequiredMessage.getText(), "Required");
    }

    @Test(groups ={"Regression"}, priority = 2)
    public void InvalidUsernameTest() throws InterruptedException{
        Thread.sleep(5000);
        LoginPage.usernameField.sendKeys("OMG");
        Thread.sleep(5000);
        LoginPage.passwordField.sendKeys("admin123");
        Thread.sleep(5000);
        LoginPage.loginButton.click();
        Thread.sleep(5000);
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(LoginPage.loginErrorMessage.getText(), "Invalid credentials");
    }

    @Test(groups ={"Regression"}, priority = 3)
    public void InvalidPasswordTest() throws InterruptedException{
        Thread.sleep(5000);
        LoginPage.usernameField.sendKeys("Admin");
        Thread.sleep(5000);
        LoginPage.passwordField.sendKeys("now_what");
        Thread.sleep(5000);
        LoginPage.loginButton.click();
        Thread.sleep(5000);
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(LoginPage.loginErrorMessage.getText(), "Invalid credentials");
    }

    @Test(groups ={"Sanity", "Regression"}, priority = 4)
    public void SuccessfulLoginTest() throws InterruptedException{
        Thread.sleep(5000);
        LoginPage.usernameField.sendKeys("Admin");
        Thread.sleep(5000);
        LoginPage.passwordField.sendKeys("admin123");
        Thread.sleep(5000);
        LoginPage.loginButton.click();
    }

}
