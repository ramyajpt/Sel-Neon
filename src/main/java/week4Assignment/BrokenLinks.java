package week4Assignment;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) {
		String homePage = "http://www.zlti.com";
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(homePage);

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		for (WebElement eachLink: allLinks)
		{
			url = eachLink.getAttribute("href");
			//System.out.println(url);
			if(!url.startsWith(homePage))
			{
				System.out.println("URL " + url +" belongs to another domain, skipping it.");
				continue;
			}
			try
			{
				//Cast is needed since HttpURLCOnnection is an abtract class & cant be instantiated directly.
				//Create an URLConnection object and cast it.
				huc = (HttpURLConnection) new URL(url).openConnection();
				//huc.setRequestMethod("HEAD");
				//openConnection() does not establish the connection. Only when we give connect(), the connection is established.
				huc.connect(); 
				respCode = huc.getResponseCode();
				if(respCode >= 400){
					System.out.println(url+" is a broken link");
				}
				else{
					System.out.println(url+" is a valid link");
				}
			} catch (MalformedURLException e)
			{
				System.err.println("The URL does not contain any protocol.");
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();	
			}
		}
	}
}