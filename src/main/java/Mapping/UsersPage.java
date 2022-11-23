package Mapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage {
    WebDriver driver;

    //Add user button
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
    public static WebElement addUserButton;

    //Username field
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
    public static WebElement usernameField;

    //Search button
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
    public static WebElement searchButton;

    //User edit button
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[6]/div/button[2]")
    public static WebElement editUserButton;
}
