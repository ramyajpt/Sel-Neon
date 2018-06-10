package week1Assignment;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create a scanner object to read input from console.
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number:");

		//Read the data and store it in a variable.
		int maxRange = scan.nextInt();
		//Assign the initial values to two variables
		int firstNum = 0; 
		int secondNum = 1;
		int nextNum = firstNum + secondNum;//Variable to store the added value
		
		System.out.println("The Fibonacci series until " + maxRange + " is below: ");
		System.out.print(firstNum);
		System.out.print(", "+ secondNum);
		while((nextNum = firstNum + secondNum) <= maxRange )
		{
			firstNum = secondNum;
			secondNum = nextNum;
			System.out.print(", " + nextNum);
		}
		scan.close();
	}
}
