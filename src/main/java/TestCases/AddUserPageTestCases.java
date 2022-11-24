package TestCases;

import Core.BaseDriver;
import Mapping.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddUserPageTestCases extends BaseDriver {
    @Parameters({"browser"})
    @BeforeTest
    public void AddUserTestCases(String browser){
        startSession(browser);
        PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, MainMenu.class);
        PageFactory.initElements(driver, AdminPage.class);
        PageFactory.initElements(driver, UsersPage.class);
        PageFactory.initElements(driver, AddUserPage.class);
        try {
            Login();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void addUser() throws InterruptedException{
        Thread.sleep(2000);
        MainMenu.adminPageButton.click();
        Thread.sleep(2000);
        UsersPage.addUserButton.click();
        Thread.sleep(2000);
        AddUserPage.userRoleMenu.click();
        Thread.sleep(2000);
        AddUserPage.adminRole.click();
        AddUserPage.employeeName.sendKeys("Milo");
        Thread.sleep(2000);
        WebElement employee = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div"));
        employee.click();
        AddUserPage.statusMenu.click();
        Thread.sleep(2000);
        AddUserPage.enabledStatus.click();
        AddUserPage.usernameField.sendKeys("MiloQA");
        AddUserPage.passwordField.sendKeys("Mqa@2022");
        AddUserPage.confirmPasswordField.sendKeys("Mqa@2022");
        Thread.sleep(1000);
        AddUserPage.saveUserButton.click();
    }
}
