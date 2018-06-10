package testcases;


import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import wdMethods.ProjectWrapper;


public class DuplicateLead extends ProjectWrapper{
	
	@Test(groups="regression", dependsOnGroups="sanity")
	public void duplicateLead()
	{
		//login();
		WebElement crmSFALink = locateElement("linktext", "CRM/SFA");
		click(crmSFALink);
		WebElement leadsLink = locateElement("linktext", "Leads");
		click(leadsLink);
		WebElement findLeadsLink = locateElement("linktext", "Find Leads");
		click(findLeadsLink);
		WebElement emailLink = locateElement("linktext", "Email");
		click(emailLink);
		WebElement emailTextBox = locateElement("name", "emailAddress");
		type(emailTextBox, "ramyaj@gmail.com");
		WebElement findLeadsButton = locateElement("xpath", "//button[text()='Find Leads']");
		click(findLeadsButton);
		WebElement firstRecordID = locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		waitUntilClickable(firstRecordID);		
		WebElement firstRecordName = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]");
		String nameOfFirstRecord = getText(firstRecordName);
		clickWithoutSnap(firstRecordID);
		WebElement duplicateLeadButton = locateElement("linktext", "Duplicate Lead");
		click(duplicateLeadButton);
		if(verifyTitle("Duplicate Lead"))
			System.out.println("The title is correct.");
		else
			System.out.println("The title is incorrect");
		WebElement createLeadButton = locateElement("name", "submitButton");
		click(createLeadButton);
		WebElement firstNameInViewLeadPage = locateElement("id", "viewLead_firstName_sp");
		verifyPartialText(firstNameInViewLeadPage, nameOfFirstRecord);
		
		closeApp();
		
	}

}
