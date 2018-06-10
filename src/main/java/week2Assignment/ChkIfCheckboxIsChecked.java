package week2Assignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChkIfCheckboxIsChecked {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();//Maximize the window
		driver.get("http://leafground.com/pages/checkbox.html");//Give the url to launch
		//Find the chkbox element by xPath and store it in a variable
		WebElement chkBox = driver.findElementByXPath("//*[@id=\'contentblock\']/section/div[2]/input");
		//Use 'isSelected()' method to chk if the chkBox is selected or not
		if(chkBox.isSelected())
				System.out.println("Checkbox is selected");
		else
			System.out.println("Checkbox is not selected");
		
	}

}
