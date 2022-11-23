package Mapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage {
    WebDriver driver;

    //Organization dropdown menu
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[1]/header/div[2]/nav/ul/li[3]")
    public static WebElement organizationMenu;

    //Organization Structure menu item
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[1]/header/div[2]/nav/ul/li[3]/ul/li[3]")
    public static WebElement structureLinkButton;

    //Qualifications dropdown menu
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[1]/header/div[2]/nav/ul/li[4]")
    public static WebElement qualificationsMenu;

    //Skills menu item
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[1]/header/div[2]/nav/ul/li[4]/ul/li[1]")
    public static WebElement skillsLinkButton;

    //Corporate Branding button
    @FindBy(xpath = "//*[@id=\'app\']/div[1]/div[1]/header/div[2]/nav/ul/li[6]")
    public static WebElement corporateBrandingLinkButton;
}
