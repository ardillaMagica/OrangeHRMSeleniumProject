package Mapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenu {

    WebDriver driver;

    //Admin page button
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")
    public static WebElement adminPageButton;

    //PIM page button
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[1]/aside/nav/div[2]/ul/li[2]")
    public static WebElement pimPageButton;

    //Recruitment page button
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[1]/aside/nav/div[2]/ul/li[5]")
    public static WebElement recruitmentPageButton;

}
