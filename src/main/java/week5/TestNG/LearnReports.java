package week5.TestNG;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnReports {

	public static void main(String[] args) throws IOException {
		ExtentHtmlReporter html = new ExtentHtmlReporter("./reports/result.html");
		html.setAppendExisting(true);//when this is set to false, only the current execution report is shown in html.
		//If set to true, it keeps the previous executions as well.
		ExtentReports extent = new ExtentReports();//to open the file in editable mode
		extent.attachReporter(html);
		ExtentTest test = extent.createTest("TC001_CreateLead", "Create a new Lead in Leaftaps" );
		test.assignCategory("smoke");
		test.assignAuthor("Author name");

		test.pass("Entered User ID DemoSalesManager successfully.", MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/img2.png").build());
		test.info("The password crmsfa is entered succesfully", MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/img3.png").build());
		test.fail("The login button is clicked", MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/img4.png").build());
		extent.flush();//If the flush statement is not given, the html file itself will not be generated.
		


	}

}
