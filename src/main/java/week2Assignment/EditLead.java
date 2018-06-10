package week2Assignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import wdMethods.ProjectWrapper;

public class EditLead extends ProjectWrapper{
	@Test
	public void main() throws InterruptedException {
		//loginNormal();
		// Launch Browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();//Maximize the window
		driver.get("http://leaftaps.com/opentaps/");//Give the url to launch
		//Enter username
		driver.findElementById("username").sendKeys("DemoSalesManager");
		//Enter password
		driver.findElementById("password").sendKeys("crmsfa");
		//Click Login button
		driver.findElementByClassName("decorativeSubmit").click();
		//Click CRM/SFA
		driver.findElementByLinkText("CRM/SFA").click();

		//Click Leads link
		driver.findElementByLinkText("Leads").click();
		//Click Find leads
		driver.findElementByLinkText("Find Leads").click();
		//Enter first name
		driver.findElementByXPath("//div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']/div[2]/div/input").sendKeys("Ramya");
		//Click Find leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		//Click on first resulting lead. Use Thread.sleep. Else system will throw 'notClickable' exception.
		Thread.sleep(2000);
		WebElement firstRecord = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		firstRecord.click();
		//Verify title of the page
		String title = driver.getTitle();
		if(title.equals("View Lead | opentaps CRM"))
			System.out.println("The Title of the current page is: " + title);
		//Click Edit
		driver.findElementByXPath("//a[text()='Edit']").click();
		//Change the company name
		WebElement companyNameTextBox = driver.findElementById("updateLeadForm_companyName");
		//String oldCompanyName = companyNameTextBox.getText();
		String newCompanyName = "SampleCompanyName";
		companyNameTextBox.clear();//clear the existing value in the textbox
		companyNameTextBox.sendKeys(newCompanyName);//ENter a new company name
		//Click Update
		driver.findElementByXPath("//input[@value='Update']").click();
		String updatedCompanyName = driver.findElementById("viewLead_companyName_sp").getText();//Get the updated company name

		String []splitString = updatedCompanyName.split("\\(");
		if (splitString[0].trim().equals(newCompanyName))
			System.out.println("The company name has been successfully updated to " + splitString[0] );
		//closeNormal();
		driver.close();
	}

}
