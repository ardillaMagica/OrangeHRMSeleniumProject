package Mapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScheduleInterview {

    WebDriver driver;

    //Interview title field
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")
    public static WebElement interviewTitle;

    //Interviewer field
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div/div[2]/div/div[1]/input")
    public static WebElement interviewerField;

    //Date picker
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[3]/div/div[2]/div/div[1]/i")
    public static WebElement datePicker;

    //Time picker
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[4]/div/div[2]/div/div/i")
    public static WebElement timePicker;

    //Save button
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")
    public static WebElement saveButton;
}
