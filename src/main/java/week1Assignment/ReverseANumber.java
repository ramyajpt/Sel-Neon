package week1Assignment;

import java.util.Scanner;

public class ReverseANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Create a scanner object to read input from console.
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number:");

		//Read the data and store it in a variable.
		int number = scan.nextInt();

		//call a method to reverse a number and print it
		System.out.println("The reversed number is " + chkReverse(number));
		scan.close();	
	}

	//chkReverse method accepts a number, reverses it and reverses it
	static int chkReverse(int number)
	{
		int quotient, remainder, reversedNumber = 0;
		while (number > 0)
		{
			quotient = number / 10;
			remainder = number % 10;
			reversedNumber = (reversedNumber * 10) + remainder;
			
			number = quotient;
		}
		return reversedNumber;
	}
}
