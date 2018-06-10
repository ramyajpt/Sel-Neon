package week2Assignment;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectLastButOneValueInDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();//Maximize the window
		driver.get("http://leafground.com/pages/Dropdown.html");//Give the url to launch
		//Find the dropdown web element by ID and store it in a variable of type Web Element
		WebElement webElement = driver.findElementById("dropdown1");
		//Create a select object for dropdown web element
		Select ddWebElement = new Select(webElement);
		//Collect the list of options in the dropdown and store it.
		List<WebElement> listOfOptions = ddWebElement.getOptions();
		//Find the size of the list, and use size -2 to select the last but one option in the dropdown. 
		//Note: index starts from 0
		ddWebElement.selectByIndex(listOfOptions.size()-2);	
	}

}
