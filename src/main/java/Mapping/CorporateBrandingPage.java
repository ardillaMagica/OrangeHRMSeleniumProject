package Mapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CorporateBrandingPage {

    WebDriver driver;

    //Primary color picker
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div")
    public static WebElement primaryColorPicker;

    //Primary Gradient color 1 picker
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[5]/div/div[2]/div")
    public static WebElement primaryGradientColorOne;

    //Primary Gradient color 2 picker
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[6]/div/div[2]/div")
    public static WebElement primaryGradientColorTwo;

    //Publish button
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[4]/div/button[3]")
    public static WebElement publishButton;

    //Reset to Default button
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[4]/div/button[1]")
    public static WebElement resetButton;
}
