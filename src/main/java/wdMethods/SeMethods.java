package wdMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeMethods implements WdMethods{
	public RemoteWebDriver driver;
	public int i = 1;
	
	@Override
	public void startApp(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", 
						"./drivers/chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				driver = new ChromeDriver(options);
			}else if(browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", 
						"./drivers/geckodriver.exe");
				//FirefoxOptions options = new FirefoxOptions();
				//options.addArguments()
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("The Browser "+browser+" launched successfully");
		} catch (IllegalStateException e) {
			System.err.println("The driver path is incorrect");
		} catch (WebDriverException e) {
			System.err.println("The browser version is not compatible with the driver version. Or the Url given is invalid");
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*finally {
			takeSnap();
		}*/
	}
	
	@Override
	public WebElement locateElement(String locator, String locValue) {

		try {
			switch(locator) {
			case "id": 
				return driver.findElementById(locValue);			
			case "class":
				return driver.findElementByClassName(locValue);
			case "name":
				return driver.findElementByName(locValue);
			case "tagname":
				return driver.findElementByTagName(locValue);
			case "linktext":
				return driver.findElementByLinkText(locValue);
			case "xpath":
				return driver.findElementByXPath(locValue);
			}

		} catch (InvalidSelectorException ex)
		{
			System.err.println(" The xpath is incorrect. Cannot find the element");
			throw new RuntimeException();
		}
		catch (NoSuchElementException ex) {
			System.err.println("The element with locator : " + locator+ " & value : " + locValue + " could not be found");
			throw new RuntimeException();
		} catch (IllegalArgumentException ex) 
		{
			System.err.println("Cannot find elements when the selector is null.");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public WebElement locateElement(String locValue) {	

		try {
			return driver.findElementById(locValue);

		} catch (NoSuchElementException e) {
			System.err.println("The element with ID : " + locValue + " could not be located.");
			throw new RuntimeException();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<WebElement> locateElements(String locator, String locValue)
	{
		try {
			switch(locator) {
			case "id": 
				return driver.findElementsById(locValue);			
			case "class":
				return driver.findElementsByClassName(locValue);
			case "name":
				return driver.findElementsByName(locValue);
			case "tagname":
				return driver.findElementsByTagName(locValue);
			case "linktext":
				return driver.findElementsByLinkText(locValue);
			case "xpath":
				return driver.findElementsByXPath(locValue);
			}

		} catch (InvalidSelectorException ex)
		{
			System.err.println(" The xpath is incorrect. Cannot find the element");
			throw new RuntimeException();
		}
		catch (NoSuchElementException ex) {
			System.err.println("The element with locator : " + locator+ " & value : " + locValue + " could not be found");
			throw new RuntimeException();
		} catch (IllegalArgumentException ex) 
		{
			System.err.println("Cannot find elements when the selector is null.");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("The data "+data+" is entered successfully");
		} catch (NullPointerException ex) {
			System.err.println(" The element value is null");
			throw new RuntimeException();
		} catch (NoSuchElementException e) {
			System.err.println(" The element " + ele + " could not be found");
			throw new RuntimeException();
		} catch (ElementNotVisibleException e) {
			System.err.println("The element " + ele + " is not visible.");
			throw new RuntimeException();
		} catch (InvalidElementStateException e) {
			System.err.println(" The element " + ele + "is disabled. sendKeys() could not be performed on a disabled element");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			System.err.println(" The browser got closed.");
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}
	}
	
	@Override
	public void click(WebElement ele) {
		//waitUntilClickable(ele);
		try {
			ele.click();
			System.out.println("The Element "+ele+" is clicked successfully and a screenshot has been taken.");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element " + ele + " is not visible.");
			throw new RuntimeException();
		} catch (ElementClickInterceptedException e) {
			System.err.println("The click could not be performed as the traget element was obscured in some way.");
			throw new RuntimeException();
		} catch (StaleElementReferenceException e) {
			System.err.println("The target element could not be clicked. Please wait for some for some more time");
			throw new RuntimeException();
		} catch (ElementNotSelectableException e) {
			System.err.println("The target element " + ele + " is not selectable");
			throw new RuntimeException();
		}catch (InvalidElementStateException e) {
			System.err.println(" The element " + ele + "is disabled. sendKeys() could not be performed on a disabled element");
			throw new RuntimeException();
		} catch (NullPointerException ex) {
			System.err.println(" The element value is null");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			takeSnap();	
		}
	}

	public void clickWithoutSnap(WebElement ele) {
		waitUntilClickable(ele);
		try {
			ele.click();
			System.out.println("The Element "+ele+" is clicked successfully and a screenshot is not taken.");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element " + ele + " is not visible.");
			throw new RuntimeException();
		} catch (ElementClickInterceptedException e) {
			System.err.println("The click could not be performed as the traget element was obscured in some way.");
			throw new RuntimeException();
		} catch (StaleElementReferenceException e) {
			System.err.println("The target element could not be clicked. Please wait for some for some more time");
			throw new RuntimeException();
		} catch (ElementNotSelectableException e) {
			System.err.println("The target element " + ele + " is not selectable");
			throw new RuntimeException();
		}catch (InvalidElementStateException e) {
			System.err.println(" The element " + ele + "is disabled. click() could not be performed on a disabled element");
			throw new RuntimeException();
		} catch (NullPointerException ex) {
			System.err.println(" The target element is null");
			throw new RuntimeException(); 
		} catch (WebDriverException e) {
			System.err.println("The browser got closed");
			throw new RuntimeException();
		}catch (Exception e) {		
			e.printStackTrace();
		} 
	}

	
	public void waitUntilClickable(WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			System.out.println("Wait till the element is clickable");
		} catch (TimeoutException e) {
			System.err.println("The element " + ele + " could not be found even after waiting for 20 sconds");
			throw new RuntimeException();
		}catch (WebDriverException ex)
		{
			System.err.println("The browser got closed.");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getText(WebElement ele) {
		String text = "";
		try {
			text = ele.getText();
			System.out.println("The text read is : " + text);
		} catch (NoSuchElementException e) {
			System.err.println("The target element " + ele + "could not be found");
			throw new RuntimeException();
		} catch (NullPointerException ex) {
			System.err.println(" The target element is null");
			throw new RuntimeException();
		} catch (WebDriverException ex) {
			System.err.println(" The browser got closed.");
			throw new RuntimeException();
		}
		return text;
	}
	
	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			Select dropdown = new Select(ele);
			dropdown.selectByVisibleText(value);
			System.out.println("The value " + value + " is selected in the dropdown " + ele);
		} catch (NullPointerException ex) {
			System.err.println(" The target element is null");
			throw new RuntimeException();
		} catch (NoSuchElementException e) {
			System.err.println(" The element with text : " + value + " could not be found in the dropdown.");
			throw new RuntimeException();
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();		
		}
	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			Select dropdown = new Select(ele);
			dropdown.selectByValue(value);
			System.out.println("The value " + value + " is selected in the dropdown " + ele);
		} catch (NullPointerException ex) {
			System.err.println(" The target element is null");
			throw new RuntimeException();
		} catch (NoSuchElementException e) {
			System.err.println(" The element with value : " + value + " could not be found in the dropdown.");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();		
		}
	}
	
	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			Select dropdown = new Select(ele);
			dropdown.selectByIndex(index);
			System.out.println("The value at index " + index + " is selected in the dropdown " + ele);
		} catch (NullPointerException ex) {
			System.err.println(" The target element is null");
			throw new RuntimeException();
		} catch (NoSuchElementException e) {
			System.err.println(" The element with index : " + index + " could not be found in the dropdown.");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();	
		}
	}
	@Override
	public boolean verifyTitle(String expectedTitle) {
		try {
			String title = driver.getTitle();
			takeSnap();
			if(title.contains(expectedTitle))
			{
				System.out.println("The current title: " + title + " matches the expected title :" + expectedTitle);
				return true;
			}
			else
			{
				System.out.println("The current title: " + title + " did not match the expected title :" + expectedTitle);
				return false;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}
	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			String text = ele.getText();
			if (text.equals(expectedText))
				System.out.println(" The text read : \'"+ text + "\' exactly matches the expected text: " + expectedText);
			else
				System.out.println(" The text read : \'"+ text + "\' did not exactly match the expected text: " + expectedText);
		} catch (NullPointerException ex) {
			System.err.println(" The target element is null");
			throw new RuntimeException();
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}
	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			String text = ele.getText();
			if (text.contains(expectedText))
				System.out.println(" The text read from the webelement : \'"+ text + "\' contains the expected text: " + expectedText);
			else
				System.out.println(" The text read from the webelement : \'"+ text + "\' does not contain the expected text: " + expectedText);
		}catch (NullPointerException ex) {
			System.err.println(" The target element is null");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();	
		}
	}
	
	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			String attributeValueRead = ele.getAttribute(attribute);
			if( attributeValueRead.equalsIgnoreCase(value))
				System.out.println(" The attribute value : " + value + " for attribute : "+ attribute + " exactly matches the value read.");
			else
				System.out.println(" The attribute value : " + value + " for attribute : "+ attribute + " does not exactly match the value read.");
		} catch (NullPointerException e) {
			System.err.println(" The attribute is not available in the element. Or the attribute value is incorrect");
		}catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			String attributeValueRead = ele.getAttribute(attribute);
			if( attributeValueRead.contains(value))
				System.out.println(" The attribute value : " + value + " for attribute : "+ attribute + " contains the value read.");
			else
				System.out.println(" The attribute value : " + value + " for attribute : "+ attribute + " does not contain the value read.");
		} catch (NullPointerException e) {
			System.err.println(" The attribute is not available in the element. Or the attribute value is incorrect.");
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

	@Override
	public void verifySelected(WebElement ele) {
		try {
			boolean isSelected = ele.isSelected();
			if(isSelected)
				System.out.println("The webelement is already selected");
			else
				System.out.println("The webelement is not selected");
		} catch (NullPointerException e) {
			System.err.println(" The target element is null.");
		} catch (WebDriverException e) {
			System.err.println("The browser got closed.");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		try {
			boolean isDisplayed = ele.isDisplayed();
			if(isDisplayed)
				System.out.println("The webelement is displayed in the DOM");
			else
				System.out.println("The webelement is not displayed in the DOM");
		} catch (NullPointerException e){ 
			System.err.println(" The target element is null.");
		} catch (WebDriverException e) {
			System.err.println("The browser got closed.");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}
	
	
	public void waitTillWindowsAreAvailable(int range) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.numberOfWindowsToBe(range));
			System.out.println("Wait until " + range + " windows are available");
		} catch (TimeoutException e) {
			System.err.println(" The mentioned number of windows : " + range + " did not get opened within the timeframe of 10 seconds");
			throw new RuntimeException();
		} catch (WebDriverException e) { 
			System.err.println("The browser got closed.");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void switchToWindow(int index) {
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			System.out.println("The number of windows is: " + windowHandles.size());
			List<String> listWindowHandles = new ArrayList<String>();
			listWindowHandles.addAll(windowHandles);
			String singleWindowHandle = listWindowHandles.get(index);
			driver.switchTo().window(singleWindowHandle);
			System.out.println("Switched to the window at index :" + index);
		} catch (NoSuchWindowException e) {
			System.err.println(" The window at index : " + index + " is not available");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}
	
	@Override
	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			System.out.println("Switched to frame.");
		} catch (NullPointerException e) {
			System.err.println("The target element is null. Cannot switch to frame");
			throw new RuntimeException();
		} catch (NoSuchFrameException e) {
			System.err.println(" The frame : " + ele + " is not available");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();	
		}
	}
	
	@Override
	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
			System.out.println("Accepted the alert");
		} catch (NoAlertPresentException e) {
			System.err.println(" The alert is not available. Could not accept the alert");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
		} 	
	}

	@Override
	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("Dismissed the alert");
		} catch (NoAlertPresentException e) {
			System.err.println(" The alert is not available. Could not dismiss the alert");
			throw new RuntimeException();
		}	catch (Exception e) {
			e.printStackTrace();
		} 	
	}
	
	@Override
	public String getAlertText() {
		String text = "";
		try {
			text = driver.switchTo().alert().getText();
			System.out.println("The text read from the alert is : " + text);
		} catch (NoAlertPresentException e) {
			System.err.println(" The alert is not available. Could not accept the alert");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return text;
	}

	@Override
	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/img"+i+".png");
		try {
			FileUtils.copyFile(src, desc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		i++;
	}
	
	@Override
	public void closeBrowser() {
		driver.close();
		System.out.println("The current browser is closed.");
	}

	@Override
	public void closeAllBrowsers() {
		driver.quit();
		System.out.println("All the browsers opened by this execution are closed.");
	}

}