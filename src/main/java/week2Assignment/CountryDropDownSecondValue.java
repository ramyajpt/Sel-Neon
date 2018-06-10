package week2Assignment;

//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CountryDropDownSecondValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");//Give the url to launch
		driver.manage().window().maximize();//Maximize the window
		
		WebElement country = driver.findElementById("userRegistrationForm:countries");
		Select ddCountry = new Select(country);
		ddCountry.selectByIndex(1);
		ddCountry.selectByIndex(899);
	}

}
