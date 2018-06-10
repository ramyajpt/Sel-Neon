package week1Assignment;

import java.util.Scanner;

public class CheckEvenOrOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create scanner object to read data from console
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number : ");
		
		//Read the data and store it in a variable
		int number = scan.nextInt();
		
		//Make a decision: use if-else since there are only two possibilities of the output
		if((number%2) == 0)
		{
			//Print: the number is even
			System.out.println(number + " is an Even Number.");
		}
		else
		{
			//Print: the number is odd
			System.out.println(number + " is an Odd Number.");
		}
		scan.close();
	}
}
