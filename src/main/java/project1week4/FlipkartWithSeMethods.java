package project1week4;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import wdMethods.SeMethods;

public class FlipkartWithSeMethods extends SeMethods {

	@Test
	public void selectSamsungTvInFlipkart() throws InterruptedException
	{
		//Launch flipkart website
		startApp("chrome", "https://www.flipkart.com");
		driver.getKeyboard().sendKeys(Keys.ESCAPE);//To dismiss the login pop-up,user presses ESC key
		Actions builder = new Actions(driver);//Create an actions object for multiple-mouse interactions
		//Mouse over the TV&Appliances link
		WebElement tvAppMenu = locateElement("xpath","//a[@title='TVs & Appliances']/span");
		builder.moveToElement(tvAppMenu).perform();
		//Wait for the menu to get loaded
		WebElement samsungBrand = locateElement("xpath","(//a[@title='Samsung']/span)[2]");//Find the samsung webelemnt
		waitUntilClickable(samsungBrand);//wait till the Samsung element is clickable
		//Click on Samsung brand
		builder.click(samsungBrand).perform();
		//Create a dropdown for Min Price
		WebElement minPrice = locateElement("xpath","//div[@class='_1qKb_B']/select");
		//Create a dropdown for Max Price
		WebElement maxPrice = locateElement("xpath","//div[@class='_1YoBfV']/select");
		//Select the Min Price
		selectDropDownUsingValue(minPrice, "25000");		
		//Select the Max Price
		selectDropDownUsingValue(maxPrice, "60000");
		//Find the Screensize element and click on it.
		WebElement screenSize = locateElement("xpath","//div[text()='Screen Size']");
		//waitUntilClickable(screenSize);
		builder.click(screenSize).build().perform();
		//click(screenSize);
		//screenSize.click();
		//Check the checkbox 48-55
		WebElement sizeCheckbox = locateElement("xpath","//div[text()='48 - 55']/preceding-sibling::div");
		//Thread.sleep(3000);
		//wait.until(ExpectedConditions.elementToBeClickable(sizeCheckbox));
		//builder.click(sizeCheckbox).perform();
		click(sizeCheckbox);

		//Find  the first product
		WebElement firstProduct = locateElement("xpath","(//a[@class='_31qSD5']/div[3]/div/div)[1]");
		System.out.println(" The first product is: " + getText(firstProduct));
		//Get the price in the first window:
		WebElement priceInFirstWindow = locateElement("xpath","(//div[@class='_1uv9Cb']/div)[1]");
		String priceIn1stWindow = getText(priceInFirstWindow);
		System.out.println("Price in first window is: " + priceIn1stWindow);
		//Click on the first product
		waitUntilClickable(firstProduct);
		click(firstProduct);
		//builder.click(firstProduct).build().perform();
		//Switch to the new window
		switchToWindow(1);

		//Get the price in the second window
		//WebElement priceInSecondWindow = locateElement("xpath","//div[@class='_2MUtYG']/div/div[1]");
		WebElement priceInSecondWindow = locateElement("xpath","(//div[@class='_1uv9Cb']/div[1])[1]");
		//String priceIn2ndWindow = getText(priceInSecondWindow);
		//System.out.println("Price in second window is : " + priceIn2ndWindow);
		verifyExactText(priceInSecondWindow, priceIn1stWindow);

		closeBrowser();

		//Switch to the parent window
		switchToWindow(0);
		//Find the add to compare checkbox for the first two products
		driver.navigate().refresh();
		WebElement addToCompareFirstProduct = locateElement("xpath","//span[@class='_1nUZxV']/div/label/input");

		WebElement addToCompareSecondProduct = locateElement("xpath","(//span[@class='_1nUZxV']/div/label/input)[2]");
		//Check both the checkboxes
		builder.click(addToCompareFirstProduct).perform();
		builder.click(addToCompareSecondProduct).perform();

		//Click on compare button.
		WebElement compareButton = locateElement("xpath","//span[text()='COMPARE']");
		click(compareButton);

		//Check the section title contains 'Compare'
		WebElement sectionTitle = locateElement("xpath","//span[text()='Compare']");
		verifyExactText(sectionTitle, "Compare");
		
		//Get the price of the second product
		WebElement priceOfSecondProduct = locateElement("xpath","(//div[@class='_1uv9Cb']/div[1])[2]");
		String priceOf2ndProduct = getText(priceOfSecondProduct);
		System.out.println("The price of the second product is :" + priceOf2ndProduct);
		//Check & print the least of the two products
		String price1 = priceIn1stWindow.replaceAll("[₹,]", "");
		String price2 = priceOf2ndProduct.replaceAll("[₹,]", "");
		//priceIn1stWindow = price1.replaceAll("[?]", "");
		//priceOf2ndProduct = price2.replaceAll("[?]", "");
		System.out.print("The price of the product which costs less is : ");
		//System.out.println("Price1: "+priceIn1stWindow);
		//System.out.println("Price2: "+priceOf2ndProduct);
		if(Integer.parseInt(price1) < Integer.parseInt(price2))
			System.out.print(price1);	
		else
			System.out.print(price2);
		closeBrowser();
	}
}
