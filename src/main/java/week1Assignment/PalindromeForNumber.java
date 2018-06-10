package week1Assignment;

import java.util.Scanner;

public class PalindromeForNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create a scanner object to read input from console.
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number:");

		//Read the data and store it in a variable.
		int number = scan.nextInt();
		
		//Create an instance for ReverseANumber class
		ReverseANumber ranObject = new ReverseANumber();
		
		//Call the chkReverse method in ReverseANumber class  and store it in a variable.
		int reversedNumber = ranObject.chkReverse(number);
		
		if (number == reversedNumber)
		{
			System.out.println("Yes the number " + number + " is a palindrome.");
		}
		else
		{
			System.out.println("The number " + number + " is not a palindrome.");
		}	
		scan.close();
	}

}
