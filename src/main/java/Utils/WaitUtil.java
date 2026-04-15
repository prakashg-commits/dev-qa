package Utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public WaitUtil(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	
	public void waitExplicitly(String element) {	 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
	}

}
