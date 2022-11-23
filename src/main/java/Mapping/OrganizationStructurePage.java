package Mapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationStructurePage {

    WebDriver driver;

    //Engineering tree menu button
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div[3]/ul/li/ul/li[2]/div[1]/span/button")
    public static WebElement engineeringTreeMenu;

    //TechOps title
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div[3]/ul/li/ul/li[2]/ul/li[3]/div[1]/div/div/div[1]")
    public static WebElement techOpsTitle;
}
