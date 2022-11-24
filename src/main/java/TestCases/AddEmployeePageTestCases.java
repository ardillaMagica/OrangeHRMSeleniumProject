package TestCases;

import Core.BaseDriver;
import Mapping.AddEmployeePage;
import Mapping.LoginPage;
import Mapping.MainMenu;
import Mapping.PimPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddEmployeePageTestCases extends BaseDriver {
    @Parameters({"browser"})
    @BeforeTest
    public void AddEmployeeTestCases(String browser){
        startSession(browser);
        PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, MainMenu.class);
        PageFactory.initElements(driver, PimPage.class);
        PageFactory.initElements(driver, AddEmployeePage.class);
        try {
            Login();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void missingLastNameError() throws InterruptedException{
        Thread.sleep(3000);
        MainMenu.pimPageButton.click();
        Thread.sleep(3000);
        PimPage.addEmployeeButton.click();
        Thread.sleep(3000);
        AddEmployeePage.firstNameField.sendKeys("Milo");
        Thread.sleep(3000);
        AddEmployeePage.middleNameField.sendKeys("Dog");
        Thread.sleep(3000);
        AddEmployeePage.employeeIdField.sendKeys("007");
        Thread.sleep(3000);
        AddEmployeePage.saveButton.click();
        Thread.sleep(5000);
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(AddEmployeePage.lastNameRequiredMessage.getText(), "Required");
    }

    @Test
    public void addingEmployee() throws InterruptedException{
        Thread.sleep(3000);
        MainMenu.pimPageButton.click();
        Thread.sleep(3000);
        PimPage.addEmployeeButton.click();
        Thread.sleep(3000);
        AddEmployeePage.firstNameField.sendKeys("Milo");
        Thread.sleep(3000);
        AddEmployeePage.lastNameField.sendKeys("Dog");
        Thread.sleep(3000);
        AddEmployeePage.employeeIdField.sendKeys("007");
        Thread.sleep(3000);
        AddEmployeePage.saveButton.click();
        Thread.sleep(5000);
        String newEmployeeName = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[1]/h6")).getText();
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(newEmployeeName, "Milo Dog");
    }

    @Test
    public void createLoginCredSwitch() throws InterruptedException{
        Thread.sleep(3000);
        MainMenu.pimPageButton.click();
        Thread.sleep(3000);
        PimPage.addEmployeeButton.click();
        Thread.sleep(3000);
        AddEmployeePage.createLoginSwitch.click();
        Thread.sleep(3000);
        AddEmployeePage.enabledRadioButton.isSelected();
    }
}
