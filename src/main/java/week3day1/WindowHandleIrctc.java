package week3day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleIrctc {

	public static void main(String[] args) {
		// Launch Browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();//Maximize the window
		driver.get("https://www.irctc.co.in");//Give the url to launch
		driver.findElementByLinkText("Contact Us").click();
		//Get the handle of all WIndows
		Set<String> allWindowHandlesSet = driver.getWindowHandles();
		//Print the number of windows
		System.out.println("Number of windows opened by this execution is : " + allWindowHandlesSet.size());
		//Convert set to list, since there is no get method in Set
		List<String> lstWindowHandles = new ArrayList<String>();
		//Note: List is an Interface. Hence we cannot create a list object.
		//That is why we create an empty array list and assign it to the list
		lstWindowHandles.addAll(allWindowHandlesSet);//Add all the entries in set to the list
		//Switch to second window
		String secondWindowHandle = lstWindowHandles.get(1);//get the handle of the second window.
		driver.switchTo().window(secondWindowHandle);
		//Print the URL of the second window
		System.out.println("The URL of the current active (2nd) window is " + driver.getCurrentUrl());
		//Close both the windows
		driver.quit();
	}
}