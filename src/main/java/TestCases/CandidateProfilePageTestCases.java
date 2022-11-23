package TestCases;

import Core.BaseDriver;
import Mapping.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CandidateProfilePageTestCases extends BaseDriver {
    @BeforeTest
    public void CandidatesTestCases(){
        startSession();
        PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, MainMenu.class);
        PageFactory.initElements(driver, RecruitmentPage.class);
        PageFactory.initElements(driver, CandidatesPage.class);
        PageFactory.initElements(driver, CandidateProfilePage.class);
        PageFactory.initElements(driver, ScheduleInterview.class);
        try {
            Login();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void editCandidate() throws InterruptedException{
        Thread.sleep(3000);
        MainMenu.recruitmentPageButton.click();
        Thread.sleep(3000);
        CandidatesPage.candidateNameField.sendKeys("Milo");
        Thread.sleep(2000);
        WebElement menuItem = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/div/div[1]/div/div[2]/div/div[2]"));
        menuItem.click();
        CandidatesPage.searchButton.click();
        Thread.sleep(2000);
        CandidatesPage.candidateDetailsButton.click();
        Thread.sleep(2000);
        CandidateProfilePage.editCandidateButton.click();
        Thread.sleep(2000);
        CandidateProfilePage.notesInputBox.sendKeys("goodest boy ever!!");
        Thread.sleep(2000);
        CandidateProfilePage.saveChangesButton.click();
    }

    @Test
    public void shortlistApplication() throws InterruptedException{
        Thread.sleep(3000);
        MainMenu.recruitmentPageButton.click();
        Thread.sleep(3000);
        CandidatesPage.candidateNameField.sendKeys("Milo");
        Thread.sleep(2000);
        WebElement menuItem = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/div/div[1]/div/div[2]/div/div[2]"));
        menuItem.click();
        CandidatesPage.searchButton.click();
        Thread.sleep(2000);
        CandidatesPage.candidateDetailsButton.click();
        Thread.sleep(2000);
        CandidateProfilePage.applicationNextStepButton.click();
        Thread.sleep(2000);
        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]"));
        saveButton.click();
    }

    @Test
    public void scheduleInterview() throws InterruptedException{
        Thread.sleep(3000);
        MainMenu.recruitmentPageButton.click();
        Thread.sleep(2000);
        CandidatesPage.candidateNameField.sendKeys("Milo");
        Thread.sleep(2000);
        WebElement menuItem = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/div/div[1]/div/div[2]/div/div[2]"));
        menuItem.click();
        CandidatesPage.searchButton.click();
        Thread.sleep(2000);
        CandidatesPage.candidateDetailsButton.click();
        Thread.sleep(2000);
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(CandidateProfilePage.applicationStatus.getText(), "Status: Shortlisted");
        //Status: Application Initiated
        CandidateProfilePage.applicationNextStepButton.click(); //change element?
        Thread.sleep(2000);
        ScheduleInterview.interviewTitle.sendKeys("Let's talk");
        ScheduleInterview.interviewerField.sendKeys("Odis");
        Thread.sleep(2000);
        WebElement interviewerPicked = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div"));
        interviewerPicked.click();
        ScheduleInterview.datePicker.click();
        Thread.sleep(2000);
        WebElement datePicked = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[3]/div/div[2]/div/div[2]/div/div[3]/div[30]/div"));
        datePicked.click();
        ScheduleInterview.timePicker.click();
        Thread.sleep(2000);
        WebElement timePicked = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[4]/div/div[2]/div/div[2]/div[4]/div[2]"));
        timePicked.click();
        ScheduleInterview.saveButton.click();
    }

    @Test
    public void markInterviewPassed() throws InterruptedException{
        Thread.sleep(3000);
        MainMenu.recruitmentPageButton.click();
        Thread.sleep(2000);
        CandidatesPage.candidateNameField.sendKeys("Milo");
        Thread.sleep(2000);
        WebElement menuItem = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/div/div[1]/div/div[2]/div/div[2]"));
        menuItem.click();
        CandidatesPage.searchButton.click();
        Thread.sleep(2000);
        CandidatesPage.candidateDetailsButton.click();
        Thread.sleep(2000);
        WebElement passed = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div[1]/form/div[2]/div[2]/button[3]"));
        passed.click();
        Thread.sleep(2000);
        WebElement save = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]"));
        save.click();
    }

    @Test
    public void offerJob() throws InterruptedException{
        Thread.sleep(3000);
        MainMenu.recruitmentPageButton.click();
        Thread.sleep(2000);
        CandidatesPage.candidateNameField.sendKeys("Milo");
        Thread.sleep(2000);
        WebElement menuItem = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/div/div[1]/div/div[2]/div/div[2]"));
        menuItem.click();
        CandidatesPage.searchButton.click();
        Thread.sleep(2000);
        CandidatesPage.candidateDetailsButton.click();
        Thread.sleep(2000);
        WebElement offerJobButton = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div[1]/form/div[2]/div[2]/button[3]"));
        offerJobButton.click();
        Thread.sleep(2000);
        WebElement saveOfferButton = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]"));
        saveOfferButton.click();
    }
}
