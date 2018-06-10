package week1Assignment;

import java.util.Scanner;

public class DaysInAMonth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(" Find the number of days in a month");

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int number = scan.nextInt();
		String month;
		
		// Check if the number entered is greater than 12, ask the user to try again
		switch(number)
		{
		case 1:
			month = "January";
			System.out.println("The " + number + "st month of the year is " + month);
			System.out.println("Number of days in the month of " + month + " is 31");
			break;
		case 2:
			month = "February";
			System.out.println("The " + number + "nd month of the year is " + month);
			System.out.println("Number of days in the month of " + month + " is 28");
			break;
		case 3:
			month = "March";
			System.out.println("The " + number + "th month of the year is " + month);
			System.out.println("Number of days in the month of " + month + " is 31");
			break;
		case 4:
			month = "April";
			System.out.println("The " + number + "th month of the year is " + month);
			System.out.println("Number of days in the month of " + month + " is 30");
			break;
		case 5:
			month = "May";
			System.out.println("The " + number + "th month of the year is " + month);
			System.out.println("Number of days in the month of " + month + " is 31");
			break;
		case 6:
			month = "June";
			System.out.println("The " + number + "th month of the year is " + month);
			System.out.println("Number of days in the month of " + month + " is 30");
			break;
		case 7:
			month = "July";
			System.out.println("The " + number + "th month of the year is " + month);
			System.out.println("Number of days in the month of " + month + " is 31");
			break;
		case 8:
			month = "August";
			System.out.println("The " + number + "th month of the year is " + month);
			System.out.println("Number of days in the month of " + month + " is 31");
			break;
		case 9:
			month = "September";
			System.out.println("The " + number + "th month of the year is " + month);
			System.out.println("Number of days in the month of " + month + " is 30");
			break;
		case 10:
			month = "October";
			System.out.println("The " + number + "th month of the year is " + month);
			System.out.println("Number of days in the month of " + month + "is 31");
			break;
		case 11:
			month = "November";
			System.out.println("The " + number + "th month of the year is " + month);
			System.out.println("Number of days in the month of " + month + "is 30");
			break;
		case 12:
			month = "December";
			System.out.println("The " + number + "th month of the year is " + month);
			System.out.println("Number of days in the month of " + month + "is 31");
			break;
		default:
			System.out.println(" Sorry the number entered is incorrect. Please try again by entering a number not greater than 12");
		}
		scan.close();
	}
}
