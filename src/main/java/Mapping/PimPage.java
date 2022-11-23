package Mapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PimPage {

    WebDriver driver;

    //Employee List Button
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a")
    public static WebElement employeeListButton;

    //Add Employee Button
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[1]/header/div[2]/nav/ul/li[3]/a")
    public static WebElement addEmployeeButton;

}
