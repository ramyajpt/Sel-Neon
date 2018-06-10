package week4Assignment;

import java.util.Scanner;

public class NumberLessThanDigit {

	public static void main(String[] args) {
		// Create scanner object
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int number = scan.nextInt();
		System.out.println("Enter a digit : ");
		int digit = scan.nextInt();
		//Chk if digit entered is part of number
		if ( chkIsDigitInNumber(digit, number))
			//Print the number without the digit
			System.out.println(numberWithoutDigit(digit, number-1));
		scan.close();
	}
	
	static boolean chkIsDigitInNumber(int digit, int number)
	{
		//Chk if user entered a digit greater than 9.
		if(digit > 9)
		{
			System.out.println("The digit entered /'" + digit +"/' is invalid. Please enter a digit between 0 & 9.");
			return false;
		}
		else
		{
			//Chk if the digit is part of the number
			String tempNumber = number+"";
			for(int index = 0; index < tempNumber.length(); index++)
			{
				if (tempNumber.charAt(index) == (char)(digit+48))
				{
					//Digit is part of the number
					System.out.println("The digit \'" + digit+"\' is part of the number: "+number);
					return true;
				}
			}
			System.out.println("The entered digit \'" + digit+"\' is not part of the number: "+number);
			return false;
		}
	}
	
	static int numberWithoutDigit(int digit, int number)
	{
		//Iterate until a number without the digit is found
		while(chkIsDigitInNumber(digit, number))
			number--;
		return number;
	}
}
