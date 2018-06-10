package week2day2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksInIrctcWitha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Launch Browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();//Maximize the window
		//driver.get("https://www.irctc.co.in/");//Give the url to launch
		driver.get("https://www.cleartrip.com/");
		
		//Collect the list of all links in the webpage
		List<WebElement> allLinks = driver.findElementsByTagName("a");
		//Print the total no of links in the web page
		System.out.println("Total no of links in this page is " + allLinks.size());
		int count =1;//Initialize a counter
		//Use for each loop, since we are passing 'allLinks' which is a collection of webElements
		for(WebElement singleLink : allLinks)
		{
			//Get the text of each link in a string
			String text = singleLink.getText();
			//Chk if the text contains the alphabet 'a'. If so increment the counter
			if(text.contains("a"))
			{
				count++;	
			}
		}
		
System.out.println("The total number of links that contain the letter a is " + count);

	}
}
