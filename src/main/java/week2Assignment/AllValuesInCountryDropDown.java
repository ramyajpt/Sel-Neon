package week2Assignment;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AllValuesInCountryDropDown {

	public static void main(String[] args) {
		// Launch Browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();//Maximize the window
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");//Give the url to launch
		//Find the Country dropdown and create a select object for it
		WebElement country = driver.findElementById("userRegistrationForm:countries");
		Select ddCountry = new Select(country);
		//Collect the list of all items in the dropdown
		List<WebElement> allItems = ddCountry.getOptions();
		for(WebElement item : allItems)
		{
			System.out.println(item.getText());
		}
		driver.close();
	}
}
