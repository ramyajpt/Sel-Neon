package week5Assignment;

import org.testng.annotations.Test;

public class ClassWithFourMethods {
	@Test
	public void methodA() {
		System.out.println("MethodA..");
	}
	@Test(dependsOnMethods = "methodC")
	public void methodB() {
		System.out.println("MethodB...");
	}
	@Test(dependsOnMethods = "methodA")
	public void methodC() {
		System.out.println("MethodC...");
	}
	@Test
	public void methodD() {
		System.out.println("MethodD...");
	}

}
