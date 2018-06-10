package testcases;


import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import wdMethods.ProjectWrapper;


public class EditLead extends ProjectWrapper{
	@Test(groups="sanity", dependsOnGroups="smoke")
	public void editLead() throws InterruptedException
	{
		//login();
		WebElement crmSFALink = locateElement("linktext", "CRM/SFA");
		click(crmSFALink);
		WebElement leadsLink = locateElement("linktext", "Leads");
		click(leadsLink);
		WebElement findLeadsLink = locateElement("linktext", "Find Leads");
		click(findLeadsLink);
		WebElement firstNameTextBox = locateElement("xpath", "//div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/div[2]/div/input");
		type(firstNameTextBox, "Ramya");
		WebElement findLeadsButton = locateElement("xpath", "//button[text()='Find Leads']");
		click(findLeadsButton);
		
		WebElement firstRecord = locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		waitUntilClickable(firstRecord);
		clickWithoutSnap(firstRecord);
		verifyTitle("View Lead");
		WebElement editButton = locateElement("xpath", "//a[text()='Edit']");
		click(editButton);
		WebElement companyNameTextBox = locateElement("id", "updateLeadForm_companyName");
		String newCompanyName = "Updated Company HTC";
		type(companyNameTextBox, newCompanyName);
		WebElement updateButton = locateElement("xpath", "//input[@value='Update']");
		click(updateButton);
		WebElement companyNameInViewLeadPage = locateElement("id", "viewLead_companyName_sp");
		verifyPartialText(companyNameInViewLeadPage, newCompanyName);
		
		//closeApp();
	}
}