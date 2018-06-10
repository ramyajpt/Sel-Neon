package project1week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartSamsungTv39 {
	
	public static void main (String[] args) throws InterruptedException {
		//Launch the browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();//Maximize the window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com");//Give the url to launch
		driver.getKeyboard().sendKeys(Keys.ESCAPE);//To dismiss the login pop-up,user presses ESC key
		Actions builder = new Actions(driver);//Create an actions object for multiple-mouse interactions
		//Mouse over the TV&Appliances link
		WebElement tvAppMenu = driver.findElementByXPath("//a[@title='TVs & Appliances']/span");
		builder.moveToElement(tvAppMenu).perform();
		//Wait for the menu to get loaded
		WebElement samsungBrand = driver.findElementByXPath("(//a[@title='Samsung']/span)[2]");//Find the samsung webelemnt
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(samsungBrand));//wait till the Samsung element is clickable
		//Click on Samsung brand
		builder.click(samsungBrand).perform();
		//Create a dropdown for Min Price
		WebElement minPrice = driver.findElementByXPath("//div[@class='_1QaKk1']/select");
		Select ddMinPrice = new Select(minPrice);
		//Create a dropdown for Max Price
		WebElement maxPrice = driver.findElementByXPath("//div[@class='_3nSxeA']/select");
		Select ddMaxPrice = new Select(maxPrice);
		//Select the Min Price
		ddMinPrice.selectByValue("25000");		
		//Select the Max Price
		ddMaxPrice.selectByValue("60000");
		//Find the Screensize element and click on it.
		
		WebElement screenSize = driver.findElementByXPath("//div[text()='Screen Size']");
		wait.until(ExpectedConditions.elementToBeClickable(screenSize));
		builder.click(screenSize).perform();
		
		//Check the checkbox 48-55
		WebElement sizeCheckbox = driver.findElementByXPath("//div[text()='48 - 55']/preceding-sibling::div");
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.elementToBeClickable(sizeCheckbox));
		builder.click(sizeCheckbox).perform();
		
		//Find  the first product 
		
		WebElement firstProduct = driver.findElementByXPath("(//a[@class='_1UoZlX']/div[3]/div/div)[1]");
		System.out.println(" The first product is: " + firstProduct.getText());
		//Get the price in the first window:
		String priceInFirstWindow = driver.findElementByXPath("(//div[@class='_1uv9Cb']/div)[1]").getText();
		System.out.println("Price in first window is: " + priceInFirstWindow);
		//Click on the first product
		firstProduct.click();
		//Switch to the new window
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("The number of windows is: " + windowHandles.size());
	
		List<String> listWindowHandles = new ArrayList<String>();
		listWindowHandles.addAll(windowHandles);
		String singleWindowHandle = listWindowHandles.get(1);
		driver.switchTo().window(singleWindowHandle);
		System.out.println("Switched to the window at index : 1" );
		//Get the price in the second window
		String priceInSecondWindow = driver.findElementByXPath("//div[@class='_2MUtYG']/div/div[1]").getText();
		System.out.println("Price in second window is : " + priceInSecondWindow);
		if (priceInFirstWindow.equals(priceInSecondWindow))
			System.out.println("The price in the both the windows are same.");
		else
			System.out.println("The price in both the windows are not same.");
		driver.close();
		//Switch to the parent window
		windowHandles = driver.getWindowHandles();
		System.out.println("The number of windows is: " + windowHandles.size());
		listWindowHandles = new ArrayList<String>();
		listWindowHandles.addAll(windowHandles);
		String parentWindowHandle = listWindowHandles.get(0);
		driver.switchTo().window(parentWindowHandle);
		System.out.println("Switched to the window at index : 0" );
		//Find the add to compare checkbox for the first two products
		driver.navigate().refresh();
		WebElement addToCompareFirstProduct = driver.findElementByXPath("//span[@class='_1nUZxV']/div/label/input");
		
		WebElement addToCompareSecondProduct = driver.findElementByXPath("(//span[@class='_1nUZxV']/div/label/input)[2]");
		//Check both the checkboxes
		builder.click(addToCompareFirstProduct).perform();
		builder.click(addToCompareSecondProduct).perform();
		//WebElement addToCompareFirstProduct = driver.findElementByXPath("(//span[text()='Add to Compare'])[1]");
		//WebElement addToCompareSecondProduct = driver.findElementByXPath("(//span[text()='Add to Compare'])[2]");		

		//Click on compare button.
		WebElement compareButton = driver.findElementByXPath("//span[text()='COMPARE']");
		compareButton.click();
		//Check the section title contains 'Compare'
		WebElement sectionTitle = driver.findElementByXPath("//span[text()='Compare']");
		if((sectionTitle.getText()).equals("Compare"))
			System.out.println("The section title contains the text /'Compare/'");
		else
			System.out.println("The section title does not contain the text /'Compare/'");
		//Get the price of the second product
		String priceOfSecondProduct = driver.findElementByXPath("(//div[@class='_1uv9Cb']/div)[2]").getText();
		System.out.println("The price of the second product is :" + priceOfSecondProduct);
		//Check & print the least of the two products
		String price1 = priceInFirstWindow.replaceAll("[?,]", "");
		String price2 = priceOfSecondProduct.replaceAll("[?,]", "");
		System.out.print("The price of the product which costs less is : ");
		if(Integer.parseInt(price1) < Integer.parseInt(price2))
			System.out.print(price1);
		else
			System.out.print(price2);
		driver.close();
	}

}
