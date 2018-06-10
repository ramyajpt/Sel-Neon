package week2Assignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DeleteLead {
@Test
	public void main() throws InterruptedException {
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
		//Click on Phone
		driver.findElementByXPath("//span[text()='Phone']").click();
		//Enter phone number
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("9442251964");
		//Click find leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		//Capture lead ID of First Resulting lead
		Thread.sleep(2000);
		WebElement firstRecord = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		String firstRecordText = firstRecord.getText();
		System.out.println(firstRecordText);
		//Click First Resulting lead
		firstRecord.click();
		//Click Delete
		driver.findElementByXPath("//a[text()='Delete']").click();
		//Click Find leads
		driver.findElementByLinkText("Find Leads").click();
		//Enter captured lead ID
		driver.findElementByName("id").sendKeys(firstRecordText);
		//Click find leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		//Verify error msg (No records to display)
		Thread.sleep(2000);
		String errorMsg = driver.findElementByXPath("//div[@class='x-paging-info']").getText();
		System.out.println(errorMsg);
		if(errorMsg.equals("No records to display"))
			System.out.println("The entry has been successfully deleted.");
		else
			System.out.println("The entry has not been deleted");
		//Close the browser
		driver.close();		
	}
}
