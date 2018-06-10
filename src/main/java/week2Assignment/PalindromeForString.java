package week2Assignment;

import java.util.Scanner;

public class PalindromeForString {

	public static void main(String[] args) {
		// Create a scanner object
		Scanner scan = new Scanner(System.in);
		System.out.println("This program tells if a string read from console is a Palindrome or not.");
		//Ask user to enter the string
		System.out.println("Enter the string: ");
		//Read the string from console and store it in a variable
		String input = scan.next();
		//Create a temporary variable
		String output = "";
		//Logic 1: Store each character in the index position in the reverse order
		for(int index = input.length()-1; index >= 0; index-- )
		{
			output = output + input.charAt(index);		
		}

		//Logic 2: convert the string to charArray; reverse it and store it in temporary variable
		//this logic however uses lots of variables. Hence uses more memory. So logic 1 seems better than logic 2
		/*char[] charArray = input.toCharArray();
		char[] tempCharArray = new char[charArray.length];
		for(int i = 0, j=(charArray.length-1); i < charArray.length-1; i++, j--)
			tempCharArray[i] = charArray[j];
		output = tempCharArray.toString();*/

		//Check if both input and output string are same.
		if(input.equalsIgnoreCase(output))
			System.out.println("The string " + input + " is a palindrome");
		else
			System.out.println("The string " + input + " is not a palindrome");
		scan.close();
	}

}
