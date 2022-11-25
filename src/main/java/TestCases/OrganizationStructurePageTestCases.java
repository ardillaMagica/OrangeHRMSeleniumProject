package TestCases;

import Core.BaseDriver;
import Mapping.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class OrganizationStructurePageTestCases extends BaseDriver {
    @Parameters({"browser"})
    @BeforeClass(groups = {"Sanity", "Regression"})
    public void OrganizationStructureTestCases(String browser){
        startSession(browser);
        PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, MainMenu.class);
        PageFactory.initElements(driver, AdminPage.class);
        PageFactory.initElements(driver, OrganizationStructurePage.class);
        try {
            Login();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(groups = {"Regression"})
    public void openTreeMenu() throws InterruptedException{
        Thread.sleep(5000);
        MainMenu.adminPageButton.click();
        Thread.sleep(5000);
        AdminPage.organizationMenu.click();
        Thread.sleep(5000);
        AdminPage.structureLinkButton.click();
        Thread.sleep(5000);
        OrganizationStructurePage.engineeringTreeMenu.click();
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(OrganizationStructurePage.techOpsTitle.getText(), "TechOps");
    }

    @AfterClass(groups = {"Sanity", "Regression"})
    public void quitSession(){
        stopSession();
    }
}
