package base;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Pages.LoginPage;
import Pages.WorkOrder;
import Utils.CommonActions;
import Utils.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    protected WebDriver driver;
    protected LoginPage loginPage;
	protected CommonActions commonActions;
    protected ExtentTest test ;        // ExtentTest instance
    protected ExtentReports extent=ExtentManager.getInstance();
    private String testName;
    protected WorkOrder workorder;
    
	
	@BeforeClass
	public void loginToApplication() {
		launchBrowser();
		launchApplication();
		initializePages();
		loginPage.loginToApplication("davesburgers@ecotrakfm.com", "Ecotrak@123");
	}
	
	 public void initializePages() {
	    	this.loginPage= new LoginPage(driver);
		    this.commonActions=new CommonActions(driver); 
		    this.workorder= new WorkOrder(driver);
	    }

	@BeforeMethod
	public void startTest(Method method) {
		Test testAnnotation = method.getAnnotation(Test.class);
	    this.testName = method.getName();
	    
	    if (testAnnotation != null && !testAnnotation.description().isEmpty()) {
	        testName = testAnnotation.description();
	    }
	    this.test = extent.createTest(testName);
	}
	
    
    @AfterMethod
    public void reportResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
        	 test.fail(result.getThrowable())
             .addScreenCaptureFromPath(commonActions.captureScreenshot(this.testName));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test passed");
        }
        extent.flush(); // flush after every test
    }

    
	@AfterClass
	public void LogoutFromApplication() {
            driver.close();
    }
	
	
    
    // launch browser
    public void launchBrowser() {
    	WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
    }
    
    // close current tab of browser
    public void closeBrowser() {
    	driver.close();
    }
    
   // close all tabs of browser
    public void closeAllTabsOfBrowser() {
    	driver.quit();
    }
    
    public void launchApplication() {
    	driver.get("https://dev.internal.ecotrak.com/");
        driver.manage().window().maximize();
    }
}