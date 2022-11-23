package TestCases;

import Core.BaseDriver;
import Mapping.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddCandidatePageTestCases extends BaseDriver {
    @BeforeTest
    public void AddCandidateTestCases(){
        startSession();
        PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, MainMenu.class);
        PageFactory.initElements(driver, RecruitmentPage.class);
        PageFactory.initElements(driver, CandidatesPage.class);
        PageFactory.initElements(driver, AddCandidatePage.class);
        try {
            Login();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void AddNewCandidate() throws InterruptedException{
        Thread.sleep(3000);
        MainMenu.recruitmentPageButton.click();
        Thread.sleep(2000);
        RecruitmentPage.candidatesButton.click();
        Thread.sleep(2000);
        CandidatesPage.addCandidateButton.click();
        Thread.sleep(2000);
        AddCandidatePage.firstNameInputField.sendKeys("Milo");
        Thread.sleep(2000);
        AddCandidatePage.lastNameInputField.sendKeys("Monstro");
        Thread.sleep(2000);
        AddCandidatePage.vacancyDropDownMenu.click();
        Thread.sleep(3000);
        WebElement menuItem = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div/div/div[2]/div/div[2]/div[6]"));
        menuItem.click();
        Thread.sleep(2000);
        AddCandidatePage.emailInputField.sendKeys("milo666@gmail.com");
        Thread.sleep(2000);
        AddCandidatePage.saveCandidateButton.click();
    }
}
