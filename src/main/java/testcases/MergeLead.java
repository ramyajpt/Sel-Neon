package testcases;


import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import wdMethods.ProjectWrapper;


public class MergeLead extends ProjectWrapper{
	
	@Test(timeOut=20000)
	public void mergeLead()
	{
		String fromID = "10963";
		String toID = "10974";
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
		WebElement mergeLeadsLink = locateElement("linktext", "Merge Leads");
		click(mergeLeadsLink);
		WebElement fromImage = locateElement("xpath", "(//img[@src='/images/fieldlookup.gif'])[1]");
		click(fromImage);
		switchToWindow(1);
		WebElement idTextBox = locateElement("name", "id");
		type(idTextBox, fromID);
		WebElement findLeadsButton = locateElement("xpath", "//button[text()='Find Leads']");
		click(findLeadsButton);
		WebElement firstRecord = locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		waitUntilClickable(firstRecord);
		clickWithoutSnap(firstRecord);//Click() method does not work and throws NoSuchWindow Exception, since there is a takeSnap() call inside click() methodd
		//waitTillWindowsAreAvailable(1);	
		switchToWindow(0);
		WebElement toImage = locateElement("xpath", "(//img[@src='/images/fieldlookup.gif'])[2]");
		click(toImage);		
		switchToWindow(1);
		idTextBox = locateElement("name", "id");
		type(idTextBox, toID);
		findLeadsButton = locateElement("xpath", "//button[text()='Find Leads']");
		click(findLeadsButton);
		firstRecord = locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		waitUntilClickable(firstRecord);
		clickWithoutSnap(firstRecord);
		//waitTillWindowsAreAvailable(1);
		switchToWindow(0);
		WebElement mergeLeadButton = locateElement("linktext", "Merge");
		clickWithoutSnap(mergeLeadButton);//Click() method does not work and throws UnhandledAlertException, since there is a takeSnap() call inside click() method.Weare not supposed to take a snap wen an alert pops-up.
		acceptAlert();
		WebElement findLeadsLink = locateElement("linktext", "Find Leads");
		click(findLeadsLink);
		idTextBox = locateElement("name", "id");
		type(idTextBox, fromID);
		findLeadsButton = locateElement("xpath", "//button[text()='Find Leads']");
		click(findLeadsButton);
		WebElement pagingInfo = locateElement("xpath", "//div[@class='x-paging-info']");
		verifyPartialText(pagingInfo, "No records to display");

		//closeApp();	
	}
}