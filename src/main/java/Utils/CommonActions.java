package Utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {
	WebDriver driver;
	String moduleName="//span[text()='Dashboard']";
	
	
	
	public CommonActions(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void navigateToModule(String moduleName) {
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/div[1]/div/ul/div[1]/button")).click();
		driver.findElement(By.xpath("//span[text()='"+ moduleName+"']")).click();
	}
	
	public String captureScreenshot(String testName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String directory = "test-output/screenshots/";
        File dir = new File(directory);

        // create folder if not exists
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String path = directory + testName + "_" + System.currentTimeMillis() + ".png";
       
        File destination = new File(path);

        FileUtils.copyFile(source, destination);
        System.out.println(path);
        return "file:///C:/Users/admin/eclipse-workspace/first/"+path;
    }

}
