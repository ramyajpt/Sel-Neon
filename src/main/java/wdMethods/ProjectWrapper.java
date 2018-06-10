package wdMethods;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import week6.LearnExcel;

public class ProjectWrapper extends SeMethods{

	protected static RemoteWebDriver driver;
	@Parameters({"url", "username", "password"})
	@BeforeMethod
	public void login(String URL, String usrName, String pword)
	{
		startApp("chrome", URL);
		WebElement uName = locateElement("id", "username");
		type(uName, usrName);
		WebElement pwd = locateElement("id", "password");
		type(pwd, pword);
		WebElement loginButton = locateElement("class", "decorativeSubmit");
		click(loginButton);
	}
	@AfterMethod
	public void closeApp()
	{
		closeAllBrowsers();
	}
	
	@DataProvider(name = "fetch")
	public Object[][] fetchData() throws InvalidFormatException, IOException
	{
		LearnExcel excel = new LearnExcel();
		return excel.readExcel();		
	}

	public void loginNormal()
	{
		// Launch Browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();//Maximize the window
		driver.get("http://leaftaps.com/opentaps/");//Give the url to launch
		//Enter username
		driver.findElementById("username").sendKeys("DemoSalesManager");
		//Enter password
		driver.findElementById("password").sendKeys("crmsfa");
		//Click Login button
		driver.findElementByClassName("decorativeSubmit").click();
	}
	public void closeNormal()
	{
		driver.close();
	}
}
