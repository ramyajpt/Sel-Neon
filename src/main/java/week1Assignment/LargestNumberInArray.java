package week1Assignment;

import java.util.Scanner;

public class LargestNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a scanner object to read data from console
				Scanner scan = new Scanner(System.in);
				
				System.out.println("Enter the list of numbers to be sorted: ");
				String inputRead = scan.nextLine();
				
				//Call the parseStringToInteger method in ArraySort class and store the value in an array;
				int []numbers = ArraySort.parseStringToInteger(inputRead);
				//Call the method 'sortIntegerArray()' in ArraySort class-it sorts the integer array in ascending order
				ArraySort.sortIntegerArray(numbers);
				
				//Print the largest number in the array
				System.out.println(" The largest number in the array is : " + numbers[numbers.length - 1]);
				//Print the second Largest number in the array
				System.out.println("The second largest number in the array is :" + numbers[numbers.length - 2]);
				//Print the third largest number in the array
				System.out.println(" The third largest number in the array is : " + numbers[numbers.length - 3]);
				scan.close();
	}

}
