package workOrders;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.WorkOrder;
import base.BaseClass;

public class verifyWOListView extends BaseClass{
	

	@Test
	public void verifyWOListing() {
		
		
	}
	
	@Test
	public void verifySortingOfWOListingColumn() {
		commonActions.navigateToModule("Work Orders");
		Assert.assertTrue(workorder.isAllColumnsPresent(), "Missing Columns in WO Listing");
		//Sorting
		workorder.sortByColumn("Status");	
	}
	
	@Test
	public void verifySearchFunctionality() {
		
	}

	@Test
	public void verifyBulkEdit() {
		
		
	}
}
