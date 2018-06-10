package project1week4;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import wdMethods.SeMethods;

public class FacebookLoginUsingSeMethods extends SeMethods{
	@Test
	public void likeTestLeafPage()
	{
		//Launch the facebook page
		startApp("chrome", "https://www.facebook.com");
		//Locate the emailID textbox
		WebElement emailID = locateElement("email");
		type(emailID, "ramyaj85@gmail.com");//Type the mail ID
		WebElement passwordTextbox = locateElement("pass");//Locate the password textbox
		type(passwordTextbox, "dans63@we");//Type the password
		//Click on login button
		WebElement logInButton = locateElement("xpath", "//input[@value='Log In']");
		click(logInButton);
		//Enter TestLeaf in the search field
		WebElement search = locateElement("xpath", "//input[@aria-label='Search']");
		type(search, "TestLeaf");
		driver.getKeyboard().sendKeys(Keys.ENTER);
		//Locate the first like button
		WebElement likeButton = locateElement("xpath", "(//div[@class='_3ko9']/span/button)[1]");
		String text = getText(likeButton);
		if(text.equals("Like"))
			click(likeButton);
		//Click on TestLeaf
		WebElement firstSearchResult = locateElement("xpath", "(//a[@class='_1ii5 _2yez']/div)[1]");
		click(firstSearchResult);
		//Click on Reviews
		WebElement reviewsLink = locateElement("xpath", "//span[text()='Reviews']");
		click(reviewsLink);
		//Print the no of reviews
		WebElement noOfReviews = locateElement("xpath", "//div[@class='_4uyj']/div[2]");
		System.out.println("The no of reviews in TestLeaf page is : " + getText(noOfReviews));
		closeBrowser();		
	}
}