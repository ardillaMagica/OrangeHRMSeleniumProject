package Mapping;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    WebDriver driver;

    //Username input field
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")

    public static WebElement usernameField;

    //Password input field
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
    public static WebElement passwordField;

    //Login button
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
    public static WebElement loginButton;

    //Invalid credentials message
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")
    public static WebElement loginErrorMessage;

    //Username required message
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span")
    public static WebElement usernameRequiredMessage;

    //Password required message
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span")
    public static WebElement passwordRequiredMessage;
}



