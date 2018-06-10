package wdMethods;


import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {
	public ExtentReports extent;
	public ExtentTest test;
	String testcaseName, testcaseDesc, category, author;
	@BeforeSuite
	public void startReport()
	{
		ExtentHtmlReporter html = new ExtentHtmlReporter("./reports/result.html");
		html.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(html);
	}
	
	@BeforeClass
	public void setData()
	{
		 testcaseName = "TC001";
		 testcaseDesc="LogIn";
		 category="smoke";
		 author="Ramya";
	}
	
	
	
	@BeforeMethod
	public void startTestCase()
	{
		test = extent.createTest(testcaseName, testcaseDesc);
		test.assignCategory(category);
		test.assignAuthor(author);
	}
	
	public void reportStep(String desc, String status)
	{
		try {
			desc=desc+MediaEntityBuilder.
					createScreenCaptureFromPath("./../snaps/img1.png")
			.build();
			if (status.equalsIgnoreCase("PASS")) {			
				test.pass(desc);
			}else if (status.equalsIgnoreCase("Fail")) {			
				test.fail(desc);
				throw new RuntimeException();
			}else if (status.equalsIgnoreCase("INFO")) {			
				test.info(desc);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public void endReport()
	{
		extent.flush();
	}
}
