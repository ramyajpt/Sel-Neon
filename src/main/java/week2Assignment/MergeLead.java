package week2Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MergeLead {
@Test
	public void main() throws InterruptedException {
		String fromLeadId = "10156";
		String toLeadId = "10157";
		// Launch Browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();//Maximize the window
		driver.get("http://leaftaps.com/opentaps/");//Give the url to launch
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
		//Click Merge Leads Link
		driver.findElementByLinkText("Merge Leads").click();
		//Click on icon next to From lead
		driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[1]").click();
		//Move to new window
		//Get the handle of all windows
		Set<String> windowHandlesFrom = driver.getWindowHandles();
		//Convert Set to List
		List<String> lstWindowHandlesFrom = new ArrayList<String>();
		//Add all the entries in set to list
		lstWindowHandlesFrom.addAll(windowHandlesFrom);
		//Get the handle of second window
		String primaryWindowHandle = lstWindowHandlesFrom.get(0);
		String secondWindowHandleFrom = lstWindowHandlesFrom.get(1);
		//Switch to new window
		driver.switchTo().window(secondWindowHandleFrom);
		//Enter Lead ID
		driver.findElementByName("id").sendKeys(fromLeadId);
		//Click find leads button		
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(1000);
		//Click First Resulting lead
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		//Switch back to main window
		driver.switchTo().window(primaryWindowHandle);
		//Click on icon next to To Lead
		driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[2]").click();
		//Get the handle of all windows
		Set<String> windowHandlesTo = driver.getWindowHandles();
		//Convert Set to List
		List<String> lstWindowHandlesTo = new ArrayList<String>();
		//Add all the entries in set to list
		lstWindowHandlesTo.addAll(windowHandlesTo);
		//Get the handle of second window

		String secondWindowHandleTo = lstWindowHandlesTo.get(1);
		System.out.println("From Handle =" + secondWindowHandleFrom);
		System.out.println("To Handle =" + secondWindowHandleTo);
		//Switch to new window
		driver.switchTo().window(secondWindowHandleTo);
		//Enter Lead ID
		driver.findElementByName("id").sendKeys(toLeadId);
		//Click find leads button		
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(1000);
		//Click First Resulting lead
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		//Switch back to main window
		driver.switchTo().window(primaryWindowHandle);
		//Click on Merge button
		driver.findElementByLinkText("Merge").click();
		//Switch to Alert
		driver.switchTo().alert();
		//Accept the alert
		driver.switchTo().alert().accept();
		//Click on Find Leads
		driver.findElementByLinkText("Find Leads").click();
		//Enter From Lead ID
		driver.findElementByName("id").sendKeys(fromLeadId);
		//Click on Find Leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(1000);
		String errorMsg = driver.findElementByXPath("//div[@class='x-paging-info']").getText();
		System.out.println(errorMsg);
		if(errorMsg.equals("No records to display"))
			System.out.println("The entry has been successfully merged.");
		else
			System.out.println("The entry has not been merged");
		//Close the browser
		driver.close();
	}

}
