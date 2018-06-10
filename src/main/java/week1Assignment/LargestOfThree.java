package week1Assignment;

import java.util.Scanner;

public class LargestOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Find the largest of three numbers: ");

		//Create a scan object to read data from console
		Scanner scan = new Scanner(System.in);

		//Read the first number and store it.
		System.out.println("Enter the first number: ");
		int number1 = scan.nextInt();

		//Read the second number and store it.
		System.out.println("Enter the second number: ");
		int number2 = scan.nextInt();

		//Read the third number and store it.
		System.out.println("Enter the third number: ");
		int number3 = scan.nextInt();

		//Use nested if-else statement to find the largest
		//Check for 'greater than or equal to', to take into account equal numbers
		if(number1 >= number2) 
		{
			if(number1 >= number3)
			{
				System.out.println("The largest number is : " + number1);
			}
			else if (number3 >= number2)
			{
				System.out.println("The largest number is : " + number3);
			}
		}
		else if (number2 >= number3)
		{
			System.out.println("The largest number is : " + number2);
		}
		else
		{
			System.out.println(" The largest number is : " + number3);
		}
		scan.close();
	}
}