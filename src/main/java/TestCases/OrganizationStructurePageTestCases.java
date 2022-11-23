package TestCases;

import Core.BaseDriver;
import Mapping.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OrganizationStructurePageTestCases extends BaseDriver {
    @BeforeTest
    public void OrganizationStructureTestCases(){
        startSession();
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

    @Test
    public void openTreeMenu() throws InterruptedException{
        Thread.sleep(2000);
        MainMenu.adminPageButton.click();
        Thread.sleep(2000);
        AdminPage.organizationMenu.click();
        Thread.sleep(2000);
        AdminPage.structureLinkButton.click();
        Thread.sleep(2000);
        OrganizationStructurePage.engineeringTreeMenu.click();
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(OrganizationStructurePage.techOpsTitle.getText(), "TechOps");
    }
}
