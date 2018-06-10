package week2Assignment;

import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
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
		//Click on Email
		driver.findElementByLinkText("Email").click();
		//Enter Email
		driver.findElementByName("emailAddress").sendKeys("ramyaj@gmail.com");
		//Click find leads button		
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		//Capture name of First Resulting lead
		Thread.sleep(2000);
		String firstRecordName = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]").getText();
		//Click First Resulting lead
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		//Click Duplicate Lead
		driver.findElementByLinkText("Duplicate Lead").click();
		//Verify the title as 'Duplicate Lead'
		String title = driver.getTitle();
		if(title.contains("Duplicate Lead"))
			System.out.println("Yes! The title of the page contains Duplicate Lead");
		//Click Create Lead button
		driver.findElementByName("submitButton").click();
		//Confirm the duplicated lead name is same as captured name
		String duplicatedName = driver.findElementById("viewLead_firstName_sp").getText();
		if(duplicatedName.equals(firstRecordName))
			System.out.println("The record has been duplicated");
		else
			System.out.println("The record has not been duplicated");
		//Close the browser (Do not log out)
		driver.close();
	}

}
