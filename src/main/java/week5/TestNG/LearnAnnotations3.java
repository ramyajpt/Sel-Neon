package week5.TestNG;

/*import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;*/
import org.testng.annotations.Test;

public class LearnAnnotations3 extends LearnAnnotations1 {
	@Test
	public void method2()
	{
		System.out.println("IN method 2.. in LearnAnnotations3 class");
	}
	/*@BeforeClass
	  public void beforeClass() {
		  System.out.println("@Before Class in LA3"); 
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("@After Class in LA3");
	  }


	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("@Before Test in LA3");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("@After Test in LA3");
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("@Before Method in LA3");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("@After Method in LA3");
	  }
*/
}
