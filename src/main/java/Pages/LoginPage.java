package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import  Utils.WaitUtil;

public class LoginPage {

    private WebDriver driver;
    private WaitUtil waitUtil;
    private String  username="//input[@id='email']";
    private String nxtBtn="//button[@type='submit']";
    private String password="//input[@name='password']";
    private String loginBtn="//button[@type='submit']";
    private String dashBoardPageUrl="https://dev.internal.ecotrak.com/panel/dashboard";
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        waitUtil=new WaitUtil(driver);
    }

   
   public void loginToApplication(String username, String password) {
	   driver.findElement(By.xpath(this.username)).sendKeys(username);
	   driver.findElement(By.xpath(this.nxtBtn)).click();
	   waitUtil.waitExplicitly(this.password);
	   driver.findElement(By.xpath(this.password)).sendKeys(password);
	   driver.findElement(By.xpath(this.loginBtn)).click();
   }


   public boolean isLoginSuccessful(String currentTitle) throws InterruptedException {
	boolean isDashboardVisible = currentTitle.equals(dashBoardPageUrl);
	System.out.println(isDashboardVisible);
	return isDashboardVisible;
   }
    
    
    
}