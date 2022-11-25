package TestCases;

import Core.BaseDriver;
import Mapping.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class EmployeeListPageTestCases extends BaseDriver {
    @Parameters({"browser"})
    @BeforeClass(groups = {"Sanity", "Regression", "Login", "Recruit"})
    public void EmployeeListTestCases(String browser){
        startSession(browser);
        PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, MainMenu.class);
        PageFactory.initElements(driver, PimPage.class);
        PageFactory.initElements(driver, EmployeeListPage.class);
        PageFactory.initElements(driver, AddEmployeePage.class);
        try {
            Login();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(groups = {"Regression"}, priority = 4)
    public void searchEmployeeByName() throws InterruptedException{
        Thread.sleep(5000);
        MainMenu.pimPageButton.click();
        Thread.sleep(5000);
        PimPage.employeeListButton.click();
        Thread.sleep(5000);
        EmployeeListPage.employeeNameField.sendKeys("Milo Dog");
        Thread.sleep(5000);
        EmployeeListPage.searchButton.click();
        Thread.sleep(5000);
        System.out.println(EmployeeListPage.recordsFound.getText());
        assertEquals(EmployeeListPage.recordsFound.getText(), "(1) Record Found");
    }

    @Test(groups = {"Regression"}, priority = 6)
    public void resetSearchFields() throws InterruptedException{
        Thread.sleep(5000);
        MainMenu.pimPageButton.click();
        Thread.sleep(5000);
        PimPage.employeeListButton.click();
        Thread.sleep(5000);
        EmployeeListPage.employeeNameField.sendKeys("Try me");
        Thread.sleep(5000);
        EmployeeListPage.employeeIdField.sendKeys("666");
        Thread.sleep(5000);
        EmployeeListPage.resetButton.click();
    }

    @Test(groups = {"Regression"}, priority = 5)
    public void deleteEmployee() throws InterruptedException{
        Thread.sleep(5000);
        MainMenu.pimPageButton.click();
        Thread.sleep(5000);
        PimPage.employeeListButton.click();
        Thread.sleep(5000);
        EmployeeListPage.employeeNameField.sendKeys("Milo Dog");
        Thread.sleep(5000);
        EmployeeListPage.searchButton.click();
        Thread.sleep(5000);
        WebElement result = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[3]/div"));
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(result.getText(), "Milo");
        EmployeeListPage.firstResultDeleteButton.click();
        Thread.sleep(5000);
        WebElement delete = driver.findElement(By.xpath("//*[@id=\'app\']/div[3]/div/div/div/div[3]/button[2]"));
        delete.click();
    }

    @Test(groups = {"Regression"}, priority = 3)
    public void missingLastNameError() throws InterruptedException{
        Thread.sleep(5000);
        MainMenu.pimPageButton.click();
        Thread.sleep(5000);
        PimPage.addEmployeeButton.click();
        Thread.sleep(5000);
        AddEmployeePage.firstNameField.sendKeys("Milo");
        Thread.sleep(5000);
        AddEmployeePage.middleNameField.sendKeys("Dog");
        Thread.sleep(5000);
        AddEmployeePage.employeeIdField.sendKeys("007");
        Thread.sleep(5000);
        AddEmployeePage.saveButton.click();
        Thread.sleep(5000);
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(AddEmployeePage.lastNameRequiredMessage.getText(), "Required");
    }

    @Test(groups = {"Sanity", "Regression"}, priority = 1)
    public void addingEmployee() throws InterruptedException{
        Thread.sleep(5000);
        MainMenu.pimPageButton.click();
        Thread.sleep(5000);
        PimPage.addEmployeeButton.click();
        Thread.sleep(5000);
        AddEmployeePage.firstNameField.sendKeys("Milo");
        Thread.sleep(5000);
        AddEmployeePage.lastNameField.sendKeys("Dog");
        Thread.sleep(5000);
        AddEmployeePage.employeeIdField.sendKeys("007");
        Thread.sleep(5000);
        AddEmployeePage.saveButton.click();
        Thread.sleep(5000);
        String newEmployeeName = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[1]/h6")).getText();
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(newEmployeeName, "Milo Dog");
    }

    @Test(groups = {"Regression"}, priority = 2)
    public void createLoginCredSwitch() throws InterruptedException{
        Thread.sleep(5000);
        MainMenu.pimPageButton.click();
        Thread.sleep(5000);
        PimPage.addEmployeeButton.click();
        Thread.sleep(5000);
        AddEmployeePage.createLoginSwitch.click();
        Thread.sleep(5000);
        AddEmployeePage.enabledRadioButton.isSelected();
        AddEmployeePage.cancelButton.click();
    }

    @AfterClass
    public void quitSession(){
        stopSession();
    }
}
