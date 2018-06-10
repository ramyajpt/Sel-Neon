package week2day1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLead {

	public static void main(String[] args) {
		// Launch Browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");//Give the url to launch
		driver.manage().window().maximize();//Maximize the window
		
		//Enter username
		driver.findElementById("username").sendKeys("DemoSalesManager");
		String a = driver.findElementById("username").getAttribute("value");
		System.out.println(a);
		//Enter password
		driver.findElementById("password").sendKeys("crmsfa");
		
		//Click Login button
		driver.findElementByClassName("decorativeSubmit").click();
		
		//Click CRM/SFA
		driver.findElementByLinkText("CRM/SFA").click();
		
		//Click CreateLead
		driver.findElementByLinkText("Create Lead").click();
		
		//Enter Company Name
		driver.findElementById("createLeadForm_companyName").sendKeys("CISCO");
		//Enter FirstName
		driver.findElementById("createLeadForm_firstName").sendKeys("RamyaP");
		//Enter LastName
		driver.findElementById("createLeadForm_lastName").sendKeys("Janagarajan");
		
		//create a webelement for source dropdown
		WebElement source = driver.findElementById("createLeadForm_dataSourceId");
		Select ddSource = new Select(source);//Create a select object for source dropdown	
		ddSource.selectByVisibleText("Existing Customer");
		
		WebElement marketingCampaign = driver.findElementById("createLeadForm_marketingCampaignId");
		Select ddMarketingCampaign = new Select(marketingCampaign);//Create a select object for Marketing Campaign d
		ddMarketingCampaign.selectByIndex(3);
		
		WebElement industry = driver.findElementById("createLeadForm_industryEnumId");
		Select ddIndustry = new Select(industry);//Create a select object for industry dropdown
		
		List<WebElement> industryList = ddIndustry.getOptions();//getOptions returns a list of WebElements
		for (WebElement eachIndustry : industryList) {
			System.out.println(eachIndustry.getText());//get the text of each web element
			
		}
		
		//Clear country code
		WebElement countryCode = driver.findElementById("createLeadForm_primaryPhoneCountryCode");
		countryCode.clear();
		//Enter country code
		countryCode.sendKeys("91");
		//Enter phone number
		driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("9442251964");
		//Enter email ID
		driver.findElementById("createLeadForm_primaryEmail").sendKeys("ramyaj@gmail.com");
		
		//Click Create Lead button
		//driver.findElementByName("submitButton").click();
		driver.findElementByClassName("smallSubmit").click();
		//If id contains numbers don't use it
		//If classname contains space don't use it.
		

	}

}
