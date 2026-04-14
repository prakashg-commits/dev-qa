package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.CommonActions;

public class WorkOrder {
	private WebDriver driver;
	

	  // Expected column names
    List<String> expectedColumns = List.of(
    		"Description",
    		"Status",
    		"WO ID",
    		"Age of Work Order",
    		"Work Order Date",
    		"Current ETA",
    		"Service Provider",
    		"Category",
    		"NTE",
    		"PM ID",
    		"Location Name",
    		"PM Title",
    		"Technicians Assigned",
    		"Last Comment",
    		"Users Assigned",
    		"Project Name",
    		"Asset Name",
    		"Invoiced",
    		"Priority",
    		"Asset Group",
    		"Updated Date",
    		"Store Number",
    		"Location Address",
    		"Service Provider Email",
    		"Service Provider Phone Number",
    		"Flags",
    		"Completed Date",
    		"Problem Type",
    		"Service Provider WO ID",
    		"Warranty"
    );
    
    
    
	public WorkOrder(WebDriver driver){
		this.driver=driver;

		
	}
	
	public boolean isAllColumnsPresent() {
	
	     List<WebElement>  woListingColumns =	driver.findElements(By.xpath("//p[@class=\"MuiTypography-root MuiTypography-body2 css-1jgfo7f\"]"));
	  
	     // Capture actual column names
	     List<String> actualColumns = woListingColumns.stream()
	             .map(e -> e.getText().trim())
	             .toList();

	     boolean isAllColumnsPresent = true;

	     for (String expected : expectedColumns) {
	         if (actualColumns.contains(expected)) {
	             System.out.println("✅ Column found: " + expected);
	         } else {
	             System.out.println("❌ Missing column: " + expected);
	             isAllColumnsPresent = false;
	         }
	     }

	     return isAllColumnsPresent;
	
	}	
	
	public void sortByColumn(String columnName) {
		driver.findElement(By.xpath(getLocSortArrow(columnName))).click();
			
	}
	
	public static String getLocSortArrow(String columnName) {	
		String locArrow= "//p[text()=\""+columnName+"\"]//following-sibling::span";
		return locArrow;
	}
}
