package week3day1;

import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class PromptBoxAndAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Launch Browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();//Maximize the window
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");//Give the url to launch
		//Switch to Frame
		driver.switchTo().frame("iframeResult");
		//Click on TRy IT button
		driver.findElementByXPath("//button[text()='Try it']").click();
		//Switch to alert
		Alert promptDialog = driver.switchTo().alert();
		//Enter text
		String name = "Taanvi";
		promptDialog.sendKeys(name);
		//Accept the alert
		promptDialog.accept();
		//Get the text 
		String textRead = driver.findElementById("demo").getText();
		//Check if it contains the text entered in alert
		if(textRead.contains(name))
			System.out.println("The entered text is present");
		else
			System.out.println("The enetered text is not present");
	}

}
