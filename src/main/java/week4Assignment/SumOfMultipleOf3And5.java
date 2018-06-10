package week4Assignment;

import java.util.Scanner;

public class SumOfMultipleOf3And5 {

	public static void main(String[] args) {
		// Create a scanner object
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number : ");
		int maxNumber = scan.nextInt();
		scan.close();
		int sum = 0;
		System.out.print("Sum of numbers ");
		for(int number = 3; number < maxNumber; number++)
		{
			if ((number%3 == 0) || (number%5 == 0))
			{
				System.out.print(number + " ");
				sum = sum + number;
			}
		}
		System.out.println(" is : " + sum);
	}
}