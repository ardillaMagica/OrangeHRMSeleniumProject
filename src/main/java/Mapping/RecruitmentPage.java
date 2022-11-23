package Mapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecruitmentPage {

    WebDriver driver;

    //Candidates button
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[1]/header/div[2]/nav/ul/li[1]/a")
    public static WebElement candidatesButton;

}
