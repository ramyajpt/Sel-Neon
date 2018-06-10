package week1day2homework;

import week1day2.ArithmeticOperations;

public class AccessArithmeticOperationsInDiffPackage {
	public static void main(String[] args)
	{
		ArithmeticOperations AOObject = new ArithmeticOperations();
		System.out.println("Accessing the methods in ArithmeticOperations class from a different package...");
		System.out.println("Cannot call addition method, since it is declared as default in another package");
		//System.out.println(AOObject.addition(1234, 4567));
		System.out.println("Calling method subtraction");
		System.out.println(AOObject.subtraction(4567,1234));
		System.out.println("Cannot call multiplication method, since it is defined as private ");
		//System.out.println(AOObject.multiplication(23, 45));
		System.out.println("Cannot call division method, since it is deined as protected");
		//System.out.println(AOObject.division(485,25));
	}
}
