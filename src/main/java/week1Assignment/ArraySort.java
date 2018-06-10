package week1Assignment;

import java.util.Scanner;

public class ArraySort {

	public static void main(String[] args) {
		// Create a scanner object to read data from console
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the list of numbers to be sorted: ");
		String inputRead = scan.nextLine();
		
		//Call the parseStringToInteger method and store the value in an array;
		int []numbers = parseStringToInteger(inputRead);
		sortIntegerArray(numbers);

		//Print the result in ascending order
		System.out.println("The array sorted in ascending order looks like: ");
		for (int index = 0; index < numbers.length; index++)
		{
			if(index == (numbers.length-1))
				System.out.println(numbers[index]);
			else
				System.out.print(numbers[index] + ",");
					
		}
		//Print the result in descending order
		System.out.println("The array sorted in descending order looks like: ");
		for (int index = numbers.length -1; index >= 0; index--)
		{
			if(index == 0 )
				System.out.println(numbers[index]);
			else
				System.out.print(numbers[index] + ",");
					
		}
		scan.close();
	}

	public static void sortIntegerArray(int[] numbers) {
		int temp;//temporary variable to use while interchanging the numbers

		for( int outer=0; outer < numbers.length; outer++)
		{
			for(int inner=outer + 1; inner < numbers.length; inner++)
			{
				if (numbers[outer] > numbers[inner])//compare the two values and interchange the values.
				{
					temp = numbers[outer];
					numbers[outer] = numbers[inner];
					numbers[inner] = temp;
				}
			}
		}
	}

	static int[] parseStringToInteger(String inputRead) {
		String []strArray = inputRead.split(",");
		int []splitNumbers = new int[strArray.length];
		
		int index =0;
		for (String s :strArray)
		{
			splitNumbers[index] = Integer.parseInt(s);
			index++;
		}
		return splitNumbers;
	}

}
