package week3Assignment;

import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create a scanner object
		Scanner scan = new Scanner(System.in);
		System.out.println("***This program checks if a year entered by the user is a leap year or not***");
		System.out.println("Enter a year to check if it is leap year or not:");
		int year = scan.nextInt();

		//Logic 1:
		if(year%400 == 0)	
			System.out.println("Yes, the entered year is a leap year.");		
		else if(year%100 == 0)
			System.out.println("No, the entered year is not a leap year.");
		else if(year%4 == 0)
			System.out.println("Yes, the entered year is a leap year.");
		else
			System.out.println("No, the entered year is not a leap year.");

		//Logic 2:
		if(year%400 == 0)	
			System.out.println("Yes, the entered year is a leap year.");
		else if(year%4 == 0)
		{
			if(year%100 == 0)
				System.out.println("No, the entered year is not a leap year.");		
			else
				System.out.println("Yes, the entered year is a leap year.");
		}
		scan.close();
	}
}