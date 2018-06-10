package week4day1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SelectableMultiSelect {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();//Maximize the window
		driver.get("http://jqueryui.com/selectable");//Give the url to launch
		WebElement frameWithDraggableObject = driver.findElementByClassName("demo-frame");
		driver.switchTo().frame(frameWithDraggableObject);
		WebElement item1 = driver.findElementByXPath("//ol[@id='selectable']/li[1]");
		WebElement item3 = driver.findElementByXPath("//ol[@id='selectable']/li[3]");
		WebElement item5 = driver.findElementByXPath("//ol[@id='selectable']/li[5]");
		//Actions object
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(item1).click(item3).click(item5).keyUp(Keys.CONTROL).perform();

	}

}
