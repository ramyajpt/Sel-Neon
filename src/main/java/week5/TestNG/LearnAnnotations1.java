package week5.TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class LearnAnnotations1 {
  @Test
  public void method3() {
	  System.out.println("@Test in method3 in LearnAnnotations1 class..");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("@Before Method in LA1");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("@After Method in LA1");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("@Before Class in LA1"); 
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("@After Class in LA1");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("@Before Test in LA1");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("@After Test in LA1");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("@Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("@After Suite");
  }

}
