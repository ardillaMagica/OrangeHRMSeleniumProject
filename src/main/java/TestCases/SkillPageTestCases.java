package TestCases;

import Core.BaseDriver;
import Mapping.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

public class SkillPageTestCases extends BaseDriver {
    @Parameters({"browser"})
    @BeforeClass(groups = {"Sanity", "Regression"})
    public void SkillsTestCases(String browser){
        startSession(browser);
        PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, MainMenu.class);
        PageFactory.initElements(driver, AdminPage.class);
        PageFactory.initElements(driver, SkillsPage.class);
        PageFactory.initElements(driver, AddSkillPage.class);
        try {
            Login();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(groups = {"Regression"}, priority = 1)
    public void addNewSkill() throws InterruptedException{
        Thread.sleep(5000);
        MainMenu.adminPageButton.click();
        Thread.sleep(5000);
        AdminPage.qualificationsMenu.click();
        Thread.sleep(5000);
        AdminPage.skillsLinkButton.click();
        Thread.sleep(5000);
        SkillsPage.addButton.click();
        Thread.sleep(5000);
        AddSkillPage.nameField.sendKeys("   aaab");
        AddSkillPage.saveButton.click();
    }

    @Test(groups = {"Regression"}, priority = 2)
    public void deleteSkill() throws InterruptedException{
        Thread.sleep(5000);
        MainMenu.adminPageButton.click();
        Thread.sleep(5000);
        AdminPage.qualificationsMenu.click();
        Thread.sleep(5000);
        AdminPage.skillsLinkButton.click();
        Thread.sleep(5000);
        WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[4]/div/button[1]"));
        deleteButton.click();
        Thread.sleep(5000);
        WebElement confirmDelete = driver.findElement(By.xpath("//*[@id=\'app\']/div[3]/div/div/div/div[3]/button[2]"));
        confirmDelete.click();
    }

    @AfterClass(groups = {"Sanity", "Regression"})
    public void quitSession(){
        stopSession();
    }
}
