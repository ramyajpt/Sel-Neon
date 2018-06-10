package week4day1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartMenuSelect {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();//Maximize the window
		driver.get("https://www.flipkart.com/");//Give the url to launch
		driver.getKeyboard().sendKeys(Keys.ESCAPE);//To dismiss the login pop-up, by pressing the ESC button
		WebElement electronicsMenu = driver.findElementByXPath("//a[@title='Electronics']/span");
		WebElement appleMenu = driver.findElementByXPath("//a[@title='Apple']/span");
		Actions builder = new Actions(driver);
		builder.moveToElement(electronicsMenu).perform();
		//Wait for the menu to get loaded and then click on Apple.
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(appleMenu));
		builder.click(appleMenu).perform();

	}

}
