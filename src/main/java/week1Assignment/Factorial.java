package week1Assignment;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create a scanner object to read input from console.
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number:");

		//Read the data and store it in a variable.
		int number = scan.nextInt();
		int result = 1;
		
		for (int i = number; i >= 1; i--)
			result = result * i;

		System.out.println("The factorial of number " + number + " is " + result);
		scan.close();
	}

}
