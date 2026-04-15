package dashboards;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Pages.LoginPage;
import Utils.CommonActions;
import Utils.ExtentManager;
import base.BaseClass;

public class VerifyDashBoard extends BaseClass{

    
    @Test
    public void verifyDashboardDetails() throws InterruptedException {
    	commonActions.navigateToModule("Work Orders");
    	
    }
}
