package TestCases;

import Core.BaseDriver;
import Mapping.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CorporateBrandingPageTestCases extends BaseDriver {
    @BeforeTest
    public void CorporateBrandingTestCases(){
        startSession();
        PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, MainMenu.class);
        PageFactory.initElements(driver, AdminPage.class);
        PageFactory.initElements(driver, CorporateBrandingPage.class);
        try {
            Login();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void achangePrimaryColor() throws InterruptedException{
        Thread.sleep(3000);
        MainMenu.adminPageButton.click();
        Thread.sleep(2000);
        AdminPage.corporateBrandingLinkButton.click();
        Thread.sleep(2000);
        CorporateBrandingPage.primaryColorPicker.click();
        Thread.sleep(2000);
        WebElement colorInput = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/input[2]"));
        colorInput.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        colorInput.sendKeys("#12eb9b");
        CorporateBrandingPage.publishButton.click();
    }

    @Test
    public void changeGradientColors() throws InterruptedException{
        Thread.sleep(5000);
        MainMenu.adminPageButton.click();
        Thread.sleep(2000);
        AdminPage.corporateBrandingLinkButton.click();
        Thread.sleep(2000);
        CorporateBrandingPage.primaryGradientColorOne.click();
        Thread.sleep(2000);
        WebElement firstColor = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[5]/div/div[2]/div/div[2]/input[2]"));
        firstColor.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        firstColor.sendKeys("#b680e5");
        CorporateBrandingPage.primaryGradientColorTwo.click();
        Thread.sleep(2000);
        WebElement secondColor = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[6]/div/div[2]/div/div[2]/input[2]"));
        secondColor.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        secondColor.sendKeys("#aec4f0");
        CorporateBrandingPage.publishButton.click();
    }

    @Test
    public void resetDefaultSettings() throws InterruptedException{
        Thread.sleep(5000);
        MainMenu.adminPageButton.click();
        Thread.sleep(2000);
        AdminPage.corporateBrandingLinkButton.click();
        Thread.sleep(2000);
        CorporateBrandingPage.resetButton.click();
    }
}
