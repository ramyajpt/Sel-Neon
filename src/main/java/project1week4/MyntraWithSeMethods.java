package project1week4;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import wdMethods.SeMethods;

public class MyntraWithSeMethods extends SeMethods {
	@Test
	public void searchSunGlasses() throws InterruptedException
	{
		//Launch Myntra website
		startApp("chrome", "https://www.myntra.com");
		//Locate the search box and type sunglasses
		WebElement searchBox = locateElement("class", "desktop-searchBar");
		type(searchBox, "SunGlasses");
		driver.getKeyboard().sendKeys(Keys.ENTER);
		//Find all the webElements of brand name 
		List<WebElement> brandNamesList = locateElements("xpath", "//div[@class='product-productMetaInfo']/div[1]");
		System.out.println("The number of brand name webelements is : " + brandNamesList.size());
		//Create a set and add all the brand names in the list to the set, so that we can get the unique brand names
		Set<String> brandNamesUnique = new TreeSet<String>();
		for (WebElement eachBrand : brandNamesList) 
			brandNamesUnique.add(eachBrand.getText());
		System.out.println("List of unique brand names:");
		for (String each : brandNamesUnique)
			System.out.println(each);
		System.out.println("The count of unique brands is: " + brandNamesUnique.size());

		//Find all the web elements of discount percentage
		List<WebElement> discountPercentageWebElements = locateElements("xpath", "//div[@class='product-price']/span[2]");
		int countOfProductWithDiscountPercentage40 = 0;
		//Iterate over each web element and find the products with 40% OFF
		for (WebElement each : discountPercentageWebElements)
			if (getText(each).contains("40"))
				countOfProductWithDiscountPercentage40++;
		System.out.println("The number of products with 40% off is: " + countOfProductWithDiscountPercentage40);

		//Find all the webelements for unisex text
		List<WebElement> unisexWebElements = locateElements("xpath", "//div[@class='product-productMetaInfo']/h4");
		int countOfUnisexSunglasses = 0;
		//Iterate over each web element and find the products which are unisex
		for (WebElement each : unisexWebElements)
			if (getText(each).contains("Unisex"))
				countOfUnisexSunglasses++;
		System.out.println("The number of products which are unisex is : " + countOfUnisexSunglasses);

		//Click on green color filter
		WebElement greenColor = locateElement("xpath", "//li[@data-colorhex='green']/label");
		click(greenColor);
		//Wait as the page loads the products based on the filter
		Thread.sleep(1000);

		//Get the name of the second product
		//WebElement brandNameOfSecondProduct = locateElement("xpath", "(//div[@class='product-productMetaInfo']/div[1])[2]");
		WebElement nameOfSecondProduct = locateElement("xpath","(//div[@class='product-productMetaInfo']/h4)[2]");

		//String nameOf2ndProduct = getText(brandNameOfSecondProduct) + " " + getText(nameOfSecondProduct);
		String nameOf2ndProduct =  getText(nameOfSecondProduct);
		System.out.println("Name of second product in search results page is: " + nameOf2ndProduct);

		//Get the price of the second product
		WebElement priceOf2ndProduct = locateElement("xpath","(//span[@class='product-discountedPrice'])[2]");
		String priceOfSecondProduct = getText(priceOf2ndProduct);
		System.out.println("Price of the second product in search results page is : " + priceOfSecondProduct);

		//Click on the second product
		WebElement secondProductLink = locateElement("xpath","(//div[@class='product-thumbShim']/following-sibling::a/img)[2]");
		click(secondProductLink);

		//Print the product name
		WebElement productTitle = locateElement("xpath","//h1[@class='pdp-title']");
		String prdctTitle = getText(productTitle);
		System.out.println("Name of the product in the product details page is: " + prdctTitle);

		//Click on Add to bag
		WebElement addToBag = locateElement("xpath","//button[@class='pdp-add-to-bag pdp-button']");
		click(addToBag);

		//Click on Go to bag
		WebElement goToBag = locateElement("xpath","//a[@class='pdp-goToCart pdp-add-to-bag pdp-button']");
		click(goToBag);
		//Get the name & price of the product in bag.
		WebElement productNameOfFirstProductInBag = locateElement("xpath","//div[@class='prod-name']/a");
		//System.out.println("The product name in bag is : " + productNameOfFirstProductInBag);
		verifyPartialText(productNameOfFirstProductInBag, nameOf2ndProduct);	
		String priceOfFirstProductInBag = getText(locateElement("xpath","//div[@class='amount red']/div"));
		System.out.println("The price of product in bag is : " + priceOfFirstProductInBag);

		//Replace , in the price string with ""
		String priceReplaced = priceOfFirstProductInBag.replaceAll(",", "");
		
		if(priceReplaced.contains(priceOfSecondProduct))
			System.out.println("The price is same in both pages");
		else
			System.out.println("The price is not same in both the pages");
		//Close the browser
		closeBrowser();

	}

}
