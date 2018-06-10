package week4day1;

//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Draggable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();//Maximize the window
		driver.get("http://jqueryui.com/draggable");//Give the url to launch
		WebElement frameWithDraggableObject = driver.findElementByClassName("demo-frame");
		driver.switchTo().frame(frameWithDraggableObject);
		WebElement draggableElement = driver.findElementById("draggable");
		Actions builder = new Actions(driver);
		//Thread.sleep(1000);
		//Point location = frameWithDraggableObject.getLocation();
		//Dimension size = frameWithDraggableObject.getSize();
		//System.out.println(location);//Throws staleElementException
		builder.dragAndDropBy(draggableElement, 150, 150).perform();
	}

}
