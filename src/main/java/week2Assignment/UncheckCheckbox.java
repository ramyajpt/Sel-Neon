package week2Assignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UncheckCheckbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();//Maximize the window
		
		driver.get("http://testleaf.herokuapp.com/pages/Button.html");//Give the url to launch
		//WebElement chkBox = driver.findElementByXPath("//div[@id='contentblock']/section/div[3]/input[2]");
		
		/*if(chkBox.isSelected())
		{
			chkBox.click();
			System.out.println("The checkbox is unchecked.");
		}
		else
		{
			chkBox.click();
			System.out.println("The checkbox is checked.");
		}*/
		WebElement colorButton = driver.findElementByXPath("//button[@id='color']");
		//WebElement colorButton = driver.findElementByXPath("//button[@id='color']");
		System.out.println(colorButton.getAttribute("idaq"));
	}

}
