package week5.TestNG;

/*import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;*/
import org.testng.annotations.Test;

public class LearnAnnotations2 extends LearnAnnotations1 {
	@Test
	public void method1()
	{
		System.out.println("In method1..In LearnAnnotations2 class..");
	}
	/* @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("@Before Method in LA2");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("@After Method in LA2");
	  }


	@BeforeClass
	  public void beforeClass() {
		  System.out.println("@Before Class in LA2"); 
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("@After Class in LA2");
	  }

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("@Before Test in LA2");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("@After Test in LA2");
	  }*/
}

