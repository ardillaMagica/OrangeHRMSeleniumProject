package Mapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SkillsPage {

    WebDriver driver;

    //Add skill button
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div[1]/div/button")
    public static WebElement addButton;
}
