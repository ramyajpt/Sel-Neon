package testcasesWithParameter;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import wdMethods.ProjectWrapper;
import week6.LearnExcel;

public class CreateLead extends ProjectWrapper{
	
	@Test(dataProvider = "fetch")
	public void createLead(String cName, String fName, String lName, String mNumber, String mailID)
	{		
		WebElement crmSFALink = locateElement("linktext", "CRM/SFA");
		click(crmSFALink);
		WebElement createLeadLink = locateElement("linktext", "Create Lead");
		click(createLeadLink);
		WebElement companyName = locateElement("createLeadForm_companyName");
		type(companyName, cName);
		WebElement firstName = locateElement("createLeadForm_firstName");
		type(firstName, fName);
		WebElement lastName = locateElement("createLeadForm_lastName");
		type(lastName, lName);
		WebElement source = locateElement("createLeadForm_dataSourceId");
		selectDropDownUsingText(source, "Existing Customer");
		WebElement countryCodeTextBox = locateElement("id", "createLeadForm_primaryPhoneCountryCode");
		type(countryCodeTextBox, "91");
		WebElement phoneNumberTextBox = locateElement("id", "createLeadForm_primaryPhoneNumber");
		type(phoneNumberTextBox, mNumber+"");
		WebElement emailTextBox = locateElement("id", "createLeadForm_primaryEmail");
		type(emailTextBox, mailID);
		WebElement createLeadButton = locateElement("name", "submitButton");
		click(createLeadButton);		
	}
	
	
	
	
}