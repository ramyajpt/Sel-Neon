package week2day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarSelectDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Launch Browser
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				ChromeDriver driver = new ChromeDriver();
				driver.get("http://leaftaps.com/opentaps/");//Give the url to launch
				driver.manage().window().maximize();//Maximize the window
				
				//Enter username
				driver.findElementById("username").sendKeys("DemoSalesManager");
				
				//Enter password
				driver.findElementById("password").sendKeys("crmsfa");
				
				//Click Login button
				driver.findElementByClassName("decorativeSubmit").click();
				
				//Click CRM/SFA
				driver.findElementByLinkText("CRM/SFA").click();
				
				//Click CreateLead
				driver.findElementByLinkText("Create Lead").click();
					
				//click on calendar
				driver.findElementById("createLeadForm_birthDate-button").click();
				
				//First we need find the table using class name. 
				//If the class name contains space, then go for tag name <table>
				//Multiple tables may be present in the browser.
				//So use xpath to find the table. Right click on the table element in the Inspect page source and select Copy->copy xpath
				//Paste the xpath in a notepad. Replace double quotes with single quotes
				//WebElement calendarTable = driver.findElementByXPath("//*[@id='_G7329__body']/table");
				
				//findElementsByClassName "daysrow" returns the list of rows in the calendar table.
				//The return type is a collection of web elements
				List<WebElement> calendarRows = driver.findElementsByClassName("daysrow");
				//Print the no of rows in the table
				System.out.println(calendarRows.size());
				//Get the 4th row in the table. get(index) method returns a webelement.
				WebElement fourthRow = calendarRows.get(3);
				//Fourth row has multiple columns. Collect all columns from this row using findElementsbyTabName("td")
				//Since <td> is the tag for each entry in a row. This returns a list of columns.
				List<WebElement> days = fourthRow.findElements(By.tagName("td"));
				//Get the second column from the list of columns
				WebElement secondDay = days.get(1);
				//Print the text of second column in fourth row
				System.out.println(secondDay.getText());
				
	}

}
