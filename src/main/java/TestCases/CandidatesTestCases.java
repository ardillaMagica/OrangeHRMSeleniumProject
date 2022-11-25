package TestCases;

import Core.BaseDriver;
import Mapping.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class CandidatesTestCases extends BaseDriver {
    @Parameters({"browser"})
    @BeforeClass(groups = {"Sanity", "Regression", "Login", "Recruit"})
    public void CandidatesTestCases(String browser){
        startSession(browser);
        PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, MainMenu.class);
        PageFactory.initElements(driver, RecruitmentPage.class);
        PageFactory.initElements(driver, CandidatesPage.class);
        PageFactory.initElements(driver, CandidateProfilePage.class);
        PageFactory.initElements(driver, AddCandidatePage.class);
        PageFactory.initElements(driver, ScheduleInterview.class);
        try {
            Login();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(groups = {"Regression"}, priority = 7)
    public void searchRejectedCandidates() throws InterruptedException{
        Thread.sleep(3000);
        MainMenu.recruitmentPageButton.click();
        Thread.sleep(3000);
        RecruitmentPage.candidatesButton.click();
        Thread.sleep(3000);
        CandidatesPage.applicationStatus.click();
        Thread.sleep(2000);
        CandidatesPage.rejectedApplication.click();
        Thread.sleep(2000);
        CandidatesPage.searchButton.click();
    }

    @Test(groups = {"Recruit", "Regression"}, priority = 1)
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

    @Test(groups = {"Recruit", "Regression"}, priority = 2)
    public void editCandidate() throws InterruptedException{
        Thread.sleep(5000);
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

    @Test(groups = {"Recruit", "Regression"}, priority = 3)
    public void shortlistApplication() throws InterruptedException{
        Thread.sleep(5000);
        MainMenu.recruitmentPageButton.click();
        Thread.sleep(5000);
        CandidatesPage.candidateNameField.sendKeys("Milo");
        Thread.sleep(5000);
        WebElement menuItem = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/div/div[1]/div/div[2]/div/div[2]"));
        menuItem.click();
        CandidatesPage.searchButton.click();
        Thread.sleep(5000);
        CandidatesPage.candidateDetailsButton.click();
        Thread.sleep(5000);
        CandidateProfilePage.applicationNextStepButton.click();
        Thread.sleep(5000);
        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]"));
        saveButton.click();
    }

    @Test(groups = {"Recruit", "Regression"}, priority = 4)
    public void scheduleInterview() throws InterruptedException{
        Thread.sleep(5000);
        MainMenu.recruitmentPageButton.click();
        Thread.sleep(5000);
        CandidatesPage.candidateNameField.sendKeys("Milo");
        Thread.sleep(5000);
        WebElement menuItem = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/div/div[1]/div/div[2]/div/div[2]"));
        menuItem.click();
        CandidatesPage.searchButton.click();
        Thread.sleep(5000);
        CandidatesPage.candidateDetailsButton.click();
        Thread.sleep(5000);
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(CandidateProfilePage.applicationStatus.getText(), "Status: Shortlisted");
        //Status: Application Initiated
        CandidateProfilePage.applicationNextStepButton.click(); //change element?
        Thread.sleep(5000);
        ScheduleInterview.interviewTitle.sendKeys("Let's talk");
        ScheduleInterview.interviewerField.sendKeys("Odis");
        Thread.sleep(5000);
        WebElement interviewerPicked = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div"));
        interviewerPicked.click();
        ScheduleInterview.datePicker.click();
        Thread.sleep(5000);
        WebElement datePicked = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[3]/div/div[2]/div/div[2]/div/div[3]/div[30]/div"));
        datePicked.click();
        ScheduleInterview.timePicker.click();
        Thread.sleep(5000);
        WebElement timePicked = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[4]/div/div[2]/div/div[2]/div[4]/div[2]"));
        timePicked.click();
        ScheduleInterview.saveButton.click();
    }

    @Test(groups = {"Recruit", "Regression"}, priority = 5)
    public void markInterviewPassed() throws InterruptedException{
        Thread.sleep(5000);
        MainMenu.recruitmentPageButton.click();
        Thread.sleep(5000);
        CandidatesPage.candidateNameField.sendKeys("Milo");
        Thread.sleep(5000);
        WebElement menuItem = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/div/div[1]/div/div[2]/div/div[2]"));
        menuItem.click();
        CandidatesPage.searchButton.click();
        Thread.sleep(5000);
        CandidatesPage.candidateDetailsButton.click();
        Thread.sleep(5000);
        WebElement passed = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div[1]/form/div[2]/div[2]/button[3]"));
        passed.click();
        Thread.sleep(5000);
        WebElement save = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]"));
        save.click();
    }

    @Test(groups = {"Recruit", "Regression"}, priority = 6)
    public void offerJob() throws InterruptedException{
        Thread.sleep(5000);
        MainMenu.recruitmentPageButton.click();
        Thread.sleep(5000);
        CandidatesPage.candidateNameField.sendKeys("Milo");
        Thread.sleep(5000);
        WebElement menuItem = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/div/div[1]/div/div[2]/div/div[2]"));
        menuItem.click();
        CandidatesPage.searchButton.click();
        Thread.sleep(5000);
        CandidatesPage.candidateDetailsButton.click();
        Thread.sleep(5000);
        WebElement offerJobButton = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div[1]/form/div[2]/div[2]/button[3]"));
        offerJobButton.click();
        Thread.sleep(5000);
        WebElement saveOfferButton = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]"));
        saveOfferButton.click();
    }

    @AfterTest
    public void quitSession(){
        stopSession();
    }
}
