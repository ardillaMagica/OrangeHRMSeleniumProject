package TestCases;

import Core.BaseDriver;
import Mapping.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UsersPageTestCases extends BaseDriver {
    @BeforeTest
    public void UsersTestCases(){
        startSession();
        PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, MainMenu.class);
        PageFactory.initElements(driver, AdminPage.class);
        PageFactory.initElements(driver, UsersPage.class);
        PageFactory.initElements(driver, EditUserPage.class);
        try {
            Login();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void changeUserRole() throws InterruptedException{
        Thread.sleep(2000);
        MainMenu.adminPageButton.click();
        Thread.sleep(2000);
        UsersPage.usernameField.sendKeys("MiloQA");
        UsersPage.searchButton.click();
        Thread.sleep(2000);
        UsersPage.editUserButton.click();
        Thread.sleep(2000);
        EditUserPage.userRoleMenu.click();
        Thread.sleep(2000);
        EditUserPage.essRole.click();
        EditUserPage.saveButton.click();
    }
}
