package week3Assignment;

import java.util.Scanner;

public class FloydTriangle {

	public static void main(String[] args) {
		// Create a scanner object
		int number =1;
		Scanner scan = new Scanner(System.in);
		System.out.println("*****This program prints the Floyd Triangle for an entered number*****");
		System.out.println("Enter the number of rows: ");
		int rows = scan.nextInt();
		for(int countOfRows=1; countOfRows <= rows; countOfRows++)
		{
			for(int noOfEntriesInARow =1; noOfEntriesInARow <= countOfRows; noOfEntriesInARow++)
			{	
				System.out.print(number + " ");
				number++;			
			}
			System.out.print("\r");
		}
		scan.close();
	}

}
