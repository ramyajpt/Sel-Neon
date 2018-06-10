package project1week4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FacebookLogin {
	
	public static void main(String[] args) {	
		// Launch Browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();//Maximize the window
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");//Give the url to launch
		driver.findElementById("email").sendKeys("ramyaj85@gmail.com");
		driver.findElementById("pass").sendKeys("dans63@we");
		driver.findElementByXPath("//input[@value='Log In']").click();
		driver.findElementByXPath("//input[@aria-label='Search']").sendKeys("TestLeaf", Keys.ENTER);
		//driver.getKeyboard().sendKeys(Keys.ENTER);
		//WebElement likeButton = driver.findElementByXPath("(//button[text()='Like'])[1]");
		WebElement likeButton = driver.findElementByXPath("(//div[@class='_3ko9']/span/button)[1]");
		String text = likeButton.getText();
		if (text.equals("Like"))
		{
			likeButton.click();
		}
		//Click on TestLeaf
		driver.findElementByXPath("(//a[@class='_1ii5 _2yez']/div)[1]").click();
		//Click on Reviews
		driver.findElementByXPath("//span[text()='Reviews']").click();
		//Print the no of reviews
		System.out.println("The no of reviews:" + driver.findElementByXPath("//div[@class='_4uyj']/div[2]").getText());
		driver.close();
	}
}
