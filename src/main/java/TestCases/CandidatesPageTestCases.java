package TestCases;

import Core.BaseDriver;
import Mapping.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CandidatesPageTestCases extends BaseDriver {
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
}
