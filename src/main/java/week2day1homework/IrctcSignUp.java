package week2day1homework;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IrctcSignUp {

	public static void main(String[] args) throws InterruptedException {
		// Launch Browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");//Give the url to launch
		driver.manage().window().maximize();//Maximize the window

		driver.findElementById("userRegistrationForm:userName").sendKeys("ramjanataanvi");//Give username
		driver.findElementById("userRegistrationForm:password").sendKeys("Reserve123");//Give password
		driver.findElementById("userRegistrationForm:confpasword").sendKeys("Reserve123");//Confirm password

		WebElement securityQ = driver.findElementById("userRegistrationForm:securityQ");//Create a webelement for Security Question
		Select ddSecurityQ = new Select(securityQ);//Create a select object for the security question dropdown
		ddSecurityQ.selectByVisibleText("What was the name of your first school?");//Select the security question by visible text
		driver.findElementById("userRegistrationForm:securityAnswer").sendKeys("Cluny");//Enter the answer for the security question

		driver.findElementById("userRegistrationForm:firstName").sendKeys("Ramya");//Enter first name
		driver.findElementById("userRegistrationForm:middleName").sendKeys("Taanvi");//Enter middle name
		driver.findElementById("userRegistrationForm:lastName").sendKeys("Janagarajan");

		driver.findElementById("userRegistrationForm:gender:1").click();
		driver.findElementById("userRegistrationForm:maritalStatus:0").click();
		WebElement dobDay = driver.findElementById("userRegistrationForm:dobDay");
		Select ddDobDay = new Select(dobDay);
		ddDobDay.selectByIndex(14);
		WebElement dobMonth = driver.findElementById("userRegistrationForm:dobMonth");
		Select ddDobMonth = new Select(dobMonth);
		ddDobMonth.selectByVisibleText("OCT");
		WebElement dobYear = driver.findElementById("userRegistrationForm:dateOfBirth");
		Select ddDobYear = new Select(dobYear);
		ddDobYear.selectByValue("1995");
		WebElement occupation = driver.findElementById("userRegistrationForm:occupation");
		Select ddOccupation = new Select(occupation);
		ddOccupation.selectByVisibleText("Professional");
		driver.findElementById("userRegistrationForm:uidno").sendKeys("123456789123");
		driver.findElementById("userRegistrationForm:idno").sendKeys("AOXPR5437E");
		WebElement country = driver.findElementById("userRegistrationForm:countries");
		Select ddCountry = new Select(country);
		ddCountry.selectByVisibleText("India");
		
		driver.findElementById("userRegistrationForm:email").sendKeys("psgtech.sw@gmail.com");
		driver.findElementById("userRegistrationForm:mobile").sendKeys("9442251964");
		WebElement nationality = driver.findElementById("userRegistrationForm:nationalityId");
		Select ddNationality = new Select(nationality);
		ddNationality.selectByVisibleText("India");
		driver.findElementById("userRegistrationForm:address").sendKeys("13-D");
		driver.findElementById("userRegistrationForm:street").sendKeys("Hostel Type Qrtrs");
		driver.findElementById("userRegistrationForm:area").sendKeys("Neyveli");
		driver.findElementById("userRegistrationForm:pincode").sendKeys("607803",Keys.TAB);
		Thread.sleep(2000);
		WebElement cityName = driver.findElementById("userRegistrationForm:cityName");
		Select ddCityName = new Select(cityName);
		ddCityName.selectByVisibleText("Cuddalore");

		for(int i=0; i<4;i++)
		{
			try
			{
				WebElement postOfficeName = driver.findElementById("userRegistrationForm:postofficeName");
				Select ddPostOfficeName = new Select(postOfficeName);
				ddPostOfficeName.selectByIndex(2);
				break;
			}catch (StaleElementReferenceException ex)
			{
				System.out.println("Trying to recover from a stale element" + ex.getMessage());
			}
		}		
		driver.findElementById("userRegistrationForm:landline").sendKeys("04142252964");
	}
}