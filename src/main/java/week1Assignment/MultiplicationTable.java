package week1Assignment;

import java.util.Scanner;

public class MultiplicationTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long result=0L;
		//Create scanner object
		Scanner scan = new Scanner(System.in);
		//Read number1
		System.out.println("Enter number#1: ");
		int number1 = scan.nextInt();
		//Read number2
		System.out.println("Enter number#2: ");
		int number2 = scan.nextInt();
		
		System.out.println("The multiplication table for " + number1 + " is:");
		//Iterate number2 times. Since the no of iterations is known, use for loop
		for(int count=1; count<=number2; count++)
		{
			//Calculate the result of multiplication
			result = count * number1;
			
			//Print the result
			System.out.println(count + " * " + number1 + " = " + result);
		}
		scan.close();
	}
}
