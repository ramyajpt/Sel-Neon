package week4day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Droppable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();//Maximize the window
		driver.get("http://jqueryui.com/droppable");//Give the url to launch
		WebElement frameWithDraggableObject = driver.findElementByClassName("demo-frame");
		driver.switchTo().frame(frameWithDraggableObject);
		WebElement draggableElement = driver.findElementById("draggable");
		WebElement droppableElement = driver.findElementById("droppable");
		//Create an actions object to perform multiple mouse actions.
		Actions builder = new Actions(driver);
		//The below line also works for drag and drop.
		//builder.clickAndHold(draggableElement).release(droppableElement).build().perform();
		builder.dragAndDrop(draggableElement, droppableElement).build().perform();
	}

}
