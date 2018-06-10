package project1week4;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		// Launch Browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();//Maximize the window
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com");//Give the url to launch
		driver.findElementByClassName("desktop-searchBar").sendKeys("Sunglasses");
		driver.getKeyboard().sendKeys(Keys.ENTER);
		//Find all the webElements of brand name
		List<WebElement> brandNamesList = driver.findElementsByXPath("//div[@class='product-productMetaInfo']/div[1]");
		System.out.println("The number of brand name webelements is : " + brandNamesList.size());
		Set<String> brandNamesUnique = new TreeSet<String>();
		
		for (WebElement eachBrand : brandNamesList)
		{ 
			brandNamesUnique.add(eachBrand.getText());
		}
		System.out.println("List of unique brand names:");
		for (String each : brandNamesUnique)
			System.out.println(each);
		System.out.println("The count of unique brands is: " + brandNamesUnique.size());
		
		//Find all the web elements of discount percentage
		List<WebElement> discountPercentageWebElements = driver.findElementsByXPath("//div[@class='product-price']/span[2]");
		int countOfProductWithDiscountPercentage40 = 0;
		for (WebElement each : discountPercentageWebElements)
		{
			if (each.getText().contains("40"))
				countOfProductWithDiscountPercentage40++;
		}
		System.out.println("The number of products with 40% off is: " + countOfProductWithDiscountPercentage40);
		
		//Find all the webelements for unisex text
		List<WebElement> unisexWebElements = driver.findElementsByXPath("//div[@class='product-productMetaInfo']/h4");
		int countOfUnisexSunglasses = 0;
		for (WebElement each : unisexWebElements)
		{
			if (each.getText().contains("Unisex"))
				countOfUnisexSunglasses++;
		}
		System.out.println("The number of products which are unisex is : " + countOfUnisexSunglasses);
		
		//Click on the green color filter
		driver.findElementByXPath("//li[@data-colorhex='green']/label").click();
		
		Thread.sleep(1000);
		
		//Get the name of the second product
		WebElement brandNameOfSecondProduct = driver.findElementByXPath("(//div[@class='product-productMetaInfo']/div[1])[2]");
		WebElement nameOfSecondProduct = driver.findElementByXPath("(//div[@class='product-productMetaInfo']/h4)[2]");
		
		String nameOf2ndProduct = brandNameOfSecondProduct.getText() + " " + nameOfSecondProduct.getText();
		System.out.println("Name of second product in search results page is: " + nameOf2ndProduct);
		
		//Get the price of the second product
		String priceOfSecondProduct = driver.findElementByXPath("(//span[@class='product-discountedPrice'])[2]").getText();
		System.out.println("Price of the second product in search results page is : " + priceOfSecondProduct);
		
		//Click on the second product
		driver.findElementByXPath("(//div[@class='product-thumbShim']/following-sibling::a/img)[2]").click();
		
		//Print the product name
		WebElement productTitle = driver.findElementByXPath("//h1[@class='pdp-title']");
		String prdctTitle = productTitle.getText();
		System.out.println("Name of the product in the product details page is: " + prdctTitle);
		
		//Click on Add to bag
		driver.findElementByXPath("//button[@class='pdp-add-to-bag pdp-button']").click();
		
		//Click on Go to bag
		driver.findElementByXPath("//a[@class='pdp-goToCart pdp-add-to-bag pdp-button']").click();
		
		//Get the name & price of the product in bag.
		String productNameOfFirstProductInBag = driver.findElementByXPath("//div[@class='prod-name']/a").getText();
		System.out.println("The product name in bag is : " + productNameOfFirstProductInBag);
		String priceOfFirstProductInBag = driver.findElementByXPath("//div[@class='amount red']/div").getText();
		System.out.println("The price of product in bag is : " + priceOfFirstProductInBag);
		
		//Replace , in the price string with ""
		String priceReplaced = priceOfFirstProductInBag.replaceAll(",", "");
		
		if(productNameOfFirstProductInBag.contains(nameOf2ndProduct))
			System.out.println("The product name is correct in both the pages");
		else
			System.out.println("The product name is not same in both the pages");
		if(priceReplaced.contains(priceOfSecondProduct))
			System.out.println("The price is same in both pages");
		else
			System.out.println("The price is not same in both the pages");
		driver.close();
	}

}
