package testcases;


import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import wdMethods.ProjectWrapper;


public class DeleteLead extends ProjectWrapper{
	@Test(dependsOnMethods="testcases.CreateLead.createLead")
	public void deleteLead()
	{
		//login();
		/*startApp("chrome", "http://leaftaps.com/opentaps");
		WebElement uName = locateElement("id", "username");
		type(uName, "DemoSalesManager");
		WebElement pwd = locateElement("id", "password");
		type(pwd, "crmsfa");
		WebElement loginButton = locateElement("class", "decorativeSubmit");
		click(loginButton);*/
		WebElement crmSFALink = locateElement("linktext", "CRM/SFA");
		click(crmSFALink);
		WebElement leadsLink = locateElement("linktext", "Leads");
		click(leadsLink);
		WebElement findLeadsLink = locateElement("linktext", "Find Leads");
		click(findLeadsLink);
		WebElement phoneLink = locateElement("xpath", "//span[text()='Phone']");
		click(phoneLink);
		WebElement phoneNumberTextBox = locateElement("xpath", "//input[@name='phoneNumber']");
		type(phoneNumberTextBox, "9442251964");
		WebElement findLeadsButton = locateElement("xpath", "//button[text()='Find Leads']");
		click(findLeadsButton);
		WebElement firstRecord = locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		waitUntilClickable(firstRecord);
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.elementToBeClickable(firstRecord));
		//Get the ID of the first record
		String firstRecordID = getText(firstRecord);
		clickWithoutSnap(firstRecord);
		WebElement deleteButton = locateElement("linktext", "Delete");
		click(deleteButton);
		//Click on Find Leads link
		findLeadsLink = locateElement("linktext", "Find Leads");
		click(findLeadsLink);
		WebElement idTextBox = locateElement("xpath", "//input[@name='id']");
		type(idTextBox, firstRecordID);
		//Click on Find Leads button.
		findLeadsButton = locateElement("xpath", "//button[text()='Find Leads']");
		click(findLeadsButton);
		WebElement pagingInfo = locateElement("xpath", "//div[@class='x-paging-info']");
		verifyPartialText(pagingInfo, "No records to display");
		
		closeApp();
	}
}