package week2Assignment;

import java.util.Scanner;

public class FizzBuzz {

	public static void main(String[] args) {
		//Create scanner object
		Scanner scan = new Scanner(System.in);
		System.out.println("This program will accept two numbers.\r For each number between the mentioned range:\r Print FIZZ if the number is divisible by 3.\r Print Buzz if the number is divisible by 5. Print FIZZBUZZ if the number is divisible by both 3 & 5.\r Print the number itself if it is not divisible by both.");
		System.out.println("Enter two numbers:");
		//Accept the two values read from console
		int initial = scan.nextInt();
		int last = scan.nextInt();
		System.out.println("Pattern is: ");
		for(int count = initial; count <= last; count++)
		{
			boolean isDivisibleBy3 = ((count % 3) == 0);
			boolean isDivisibleBy5 = ((count % 5) == 0);
			if(isDivisibleBy3)
				System.out.print("FIZZ");
			if(isDivisibleBy5)
				System.out.print("BUZZ");
			if(!isDivisibleBy3 && !isDivisibleBy5)
				System.out.print(count);
			System.out.print(" ");
		}
		scan.close();
	}

}
