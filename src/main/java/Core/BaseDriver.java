package Core;

import Mapping.LoginPage;
import Utils.PropertyUtil;
import com.sun.org.apache.xpath.internal.functions.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseDriver {

    public WebDriver driver;
    String path = System.getProperty("user.dir");

    public WebDriver getDriver() { return driver;}

    public void startSession(String browser){
        try{
            PropertyUtil pus = new PropertyUtil(path + "\\selenium.properties");
//            String browser = pus.getProperty("browser");
            String WebSiteURL = pus.getProperty("WebSiteURL");
            String grid = pus.getProperty("grid");
            String gridUrl = pus.getProperty("gridUrl");

            if(browser.equalsIgnoreCase("FireFox")){
                if (grid.equalsIgnoreCase("true")){
                    DesiredCapabilities cap = new DesiredCapabilities();
                    cap.setBrowserName("firefox");
                    cap.setPlatform(Platform.WINDOWS);
                    driver = new RemoteWebDriver(new URL(gridUrl), cap);
                }else{
                    System.setProperty("webdriver.gecko.driver", path + "\\drivers\\geckodriver.exe");
                    driver = new FirefoxDriver();
                }
            }else if(browser.equalsIgnoreCase("chrome")){
                if(grid.equalsIgnoreCase("true")){
                    System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriver.exe");
                    ChromeOptions options = new ChromeOptions();
                    //set some options
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability(ChromeOptions.CAPABILITY,options);
                    Capabilities cap = null;
                    driver = new RemoteWebDriver(new URL(gridUrl), cap);
                }else{
                    System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriver.exe");
                    driver = new ChromeDriver();
                }
            }
            String url = pus.getProperty("WebSiteURL");
            driver.get(url);
            driver.manage().window().maximize();

        }catch (Exception e){
            e.getMessage();
        }
    }

    public void Login() throws InterruptedException{
        Thread.sleep(3000);
        LoginPage.usernameField.sendKeys("Admin");
        LoginPage.passwordField.sendKeys("admin123");
        LoginPage.loginButton.click();
    }

    public void stopSession() {
    driver.quit();
    }
}
