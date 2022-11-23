package TestCases;

import Core.BaseDriver;
import Mapping.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EmployeeListPageTestCases extends BaseDriver {
    @BeforeTest
    public void EmployeeListTestCases(){
        startSession();
        PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, MainMenu.class);
        PageFactory.initElements(driver, PimPage.class);
        PageFactory.initElements(driver, EmployeeListPage.class);
        try {
            Login();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void searchEmployeeByName() throws InterruptedException{
        Thread.sleep(3000);
        MainMenu.pimPageButton.click();
        Thread.sleep(3000);
        PimPage.employeeListButton.click();
        Thread.sleep(3000);
        EmployeeListPage.employeeNameField.sendKeys("Milo Dog");
        Thread.sleep(3000);
        EmployeeListPage.searchButton.click();
        Thread.sleep(3000);
        System.out.println(EmployeeListPage.recordsFound.getText());
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(EmployeeListPage.recordsFound.getText(), "(1) Record Found");
    }

    @Test
    public void resetSearchFields() throws InterruptedException{
        Thread.sleep(3000);
        MainMenu.pimPageButton.click();
        Thread.sleep(3000);
        PimPage.employeeListButton.click();
        Thread.sleep(3000);
        EmployeeListPage.employeeNameField.sendKeys("Try me");
        Thread.sleep(2000);
        EmployeeListPage.employeeIdField.sendKeys("666");
        Thread.sleep(2000);
        EmployeeListPage.resetButton.click();
    }

    @Test
    public void deleteEmployee() throws InterruptedException{
        Thread.sleep(3000);
        MainMenu.pimPageButton.click();
        Thread.sleep(3000);
        PimPage.employeeListButton.click();
        Thread.sleep(3000);
        EmployeeListPage.employeeNameField.sendKeys("Milo Dog");
        Thread.sleep(2000);
        EmployeeListPage.searchButton.click();
        Thread.sleep(3000);
        EmployeeListPage.firstResultDeleteButton.click();
        Thread.sleep(2000);
        WebElement delete = driver.findElement(By.xpath("//*[@id=\'app\']/div[3]/div/div/div/div[3]/button[2]"));
        delete.click();
    }
}
