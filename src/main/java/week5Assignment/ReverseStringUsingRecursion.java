package week5Assignment;

import java.util.Scanner;

public class ReverseStringUsingRecursion {

	public static void main(String[] args) {
		String str;
		System.out.println("Enter a string to be reversed: ");
		Scanner scanner = new Scanner(System.in);
		str = scanner.nextLine();
		
		scanner.close();
		String reversed = reverseString(str);
		System.out.println("The reversed string is: " + reversed);
	}

	public static String reverseString(String str)
	{
		if (str.isEmpty())
			return str;
		//Calling Function Recursively
		return reverseString(str.substring(1)) + str.charAt(0);
	}
}
