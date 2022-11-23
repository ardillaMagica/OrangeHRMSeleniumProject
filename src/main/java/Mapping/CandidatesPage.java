package Mapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CandidatesPage {

    WebDriver driver;

    //Add candidate button
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
    public static WebElement addCandidateButton;

    //Application status dropdown menu
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div")
    public static WebElement applicationStatus;

    //Rejected application option on Application status menu
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[2]/div[4]")
    public static WebElement rejectedApplication;

    //Candidate name field
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/div/div[1]/div/div[2]/div/div/input")
    public static WebElement candidateNameField;

    //Search button
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[4]/button[2]")
    public static WebElement searchButton;

    //View candidates detail button
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[7]/div/button[1]")
    public static WebElement candidateDetailsButton;

}
