package Mapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CandidateProfilePage {

    WebDriver driver;

    //Edit candidate profile button
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div[2]/div/div/div/label/span")
    public static WebElement editCandidateButton;

    //Application next step button
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div[1]/form/div[2]/div[2]/button[2]")
    public static WebElement applicationNextStepButton;

    //Application status
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div[1]/form/div[2]/div[1]/p")
    public static WebElement applicationStatus;

    //Notes input box
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div[2]/div/form/div[6]/div/div/div/div[2]/textarea")
    public static WebElement notesInputBox;

    //Save button
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div[2]/div/form/div[8]/button")
    public static WebElement saveChangesButton;
}
