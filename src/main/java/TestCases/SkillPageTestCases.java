package TestCases;

import Core.BaseDriver;
import Mapping.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SkillPageTestCases extends BaseDriver {
    @BeforeTest
    public void SkillsTestCases(){
        startSession();
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

    @Test
    public void addNewSkill() throws InterruptedException{
        Thread.sleep(2000);
        MainMenu.adminPageButton.click();
        Thread.sleep(2000);
        AdminPage.qualificationsMenu.click();
        Thread.sleep(2000);
        AdminPage.skillsLinkButton.click();
        Thread.sleep(2000);
        SkillsPage.addButton.click();
        Thread.sleep(2000);
        AddSkillPage.nameField.sendKeys("   aaab");
        AddSkillPage.saveButton.click();
    }

    @Test
    public void deleteSkill() throws InterruptedException{
        Thread.sleep(2000);
        MainMenu.adminPageButton.click();
        Thread.sleep(2000);
        AdminPage.qualificationsMenu.click();
        Thread.sleep(2000);
        AdminPage.skillsLinkButton.click();
        Thread.sleep(2000);
        WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[4]/div/button[1]"));
        deleteButton.click();
        Thread.sleep(2000);
        WebElement confirmDelete = driver.findElement(By.xpath("//*[@id=\'app\']/div[3]/div/div/div/div[3]/button[2]"));
        confirmDelete.click();
    }
}
