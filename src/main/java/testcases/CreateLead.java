package testcases;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wdMethods.ProjectWrapper;


public class CreateLead extends ProjectWrapper{
	
	@Test
	public void createLead()
	{
		//login();
		WebElement crmSFALink = locateElement("linktext", "CRM/SFA");
		click(crmSFALink);
		WebElement createLeadLink = locateElement("linktext", "Create Lead");
		click(createLeadLink);
		WebElement companyName = locateElement("createLeadForm_companyName");
		type(companyName, "GE");
		WebElement firstName = locateElement("createLeadForm_firstName");
		type(firstName, "Ramya");
		WebElement lastName = locateElement("createLeadForm_lastName");
		type(lastName, "Taanvi");
		WebElement source = locateElement("createLeadForm_dataSourceId");
		selectDropDownUsingText(source, "Existing Customer");
		WebElement countryCodeTextBox = locateElement("id", "createLeadForm_primaryPhoneCountryCode");
		type(countryCodeTextBox, "91");
		WebElement phoneNumberTextBox = locateElement("id", "createLeadForm_primaryPhoneNumber");
		type(phoneNumberTextBox, "9442251964");
		WebElement emailTextBox = locateElement("id", "createLeadForm_primaryEmail");
		type(emailTextBox, "ramyaj@gmail.com");
		WebElement createLeadButton = locateElement("name", "submitButton");
		click(createLeadButton);	
		
		//closeApp();
	}
}