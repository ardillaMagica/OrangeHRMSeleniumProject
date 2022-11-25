package TestCases;

import Core.BaseDriver;
import Mapping.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

public class CorporateBrandingPageTestCases extends BaseDriver {
    @Parameters({"browser"})
    @BeforeClass(groups = {"Sanity", "Regression"})
    public void CorporateBrandingTestCases(String browser){
        startSession(browser);
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

    @Test(groups = {"Regression"}, priority = 1)
    public void changePrimaryColor() throws InterruptedException{
        Thread.sleep(5000);
        MainMenu.adminPageButton.click();
        Thread.sleep(5000);
        AdminPage.corporateBrandingLinkButton.click();
        Thread.sleep(5000);
        CorporateBrandingPage.primaryColorPicker.click();
        Thread.sleep(5000);
        WebElement colorInput = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/input[2]"));
        colorInput.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        colorInput.sendKeys("#12eb9b");
        CorporateBrandingPage.publishButton.click();
    }

    @Test(groups = {"Regression"}, priority = 2)
    public void changeGradientColors() throws InterruptedException{
        Thread.sleep(5000);
        MainMenu.adminPageButton.click();
        Thread.sleep(5000);
        AdminPage.corporateBrandingLinkButton.click();
        Thread.sleep(5000);
        CorporateBrandingPage.primaryGradientColorOne.click();
        Thread.sleep(5000);
        WebElement firstColor = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[5]/div/div[2]/div/div[2]/input[2]"));
        firstColor.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        firstColor.sendKeys("#b680e5");
        CorporateBrandingPage.primaryGradientColorTwo.click();
        Thread.sleep(5000);
        WebElement secondColor = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[6]/div/div[2]/div/div[2]/input[2]"));
        secondColor.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        secondColor.sendKeys("#aec4f0");
        CorporateBrandingPage.publishButton.click();
    }

    @Test(groups = {"Regression"}, priority = 3)
    public void resetDefaultSettings() throws InterruptedException{
        Thread.sleep(5000);
        MainMenu.adminPageButton.click();
        Thread.sleep(5000);
        AdminPage.corporateBrandingLinkButton.click();
        Thread.sleep(5000);
        CorporateBrandingPage.resetButton.click();
    }

    @AfterClass(groups = {"Sanity", "Regression"})
    public void quitSession(){
        stopSession();
    }
}
