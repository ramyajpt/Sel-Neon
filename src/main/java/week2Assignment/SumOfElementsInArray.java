package week2Assignment;

import java.util.Scanner;

public class SumOfElementsInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int index, sum =0;
		//Create scanner object to read data from console
		Scanner scan = new Scanner(System.in);
		System.out.println("This program gives the sum of elements in the array.");
		//Ask user to enter the number of elements in the array
		System.out.println("Enter the number of elements in the array: ");
		//Read the data and store it in a variable
		int length = scan.nextInt();
		//Create an array of size entered by the user
		int []numberArray = new int[length];
		//Ask user to enter the elements in the array
		System.out.println("Enter the elements in the array:");
		//Read the elements and store it in a array.
		for (index =0; index<length; index++)
		{
			numberArray[index] = scan.nextInt();
		}
		//Use for each loop; iterate and sum the elements in the array
		for(int number: numberArray)
			sum = sum + number;
		//Print the result
		System.out.println("The sum of elements in the array is : " + sum);
		scan.close();
	}
}