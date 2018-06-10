package week4day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SelectableContinousSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();//Maximize the window
		driver.get("http://jqueryui.com/selectable");//Give the url to launch
		WebElement frameWithDraggableObject = driver.findElementByClassName("demo-frame");
		driver.switchTo().frame(frameWithDraggableObject);
		WebElement item1 = driver.findElementByXPath("//ol[@id='selectable']/li[1]");
		WebElement item4 = driver.findElementByXPath("//ol[@id='selectable']/li[4]");
		//Actions object
		Actions builder = new Actions(driver);
		builder.clickAndHold(item1).release(item4).build().perform();
		//Instead of build().perform(), we can use perform() also. This will work in the latest versions
	}

}
