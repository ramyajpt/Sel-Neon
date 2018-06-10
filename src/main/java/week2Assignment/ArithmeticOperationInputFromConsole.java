package week2Assignment;

import java.util.Scanner;

public class ArithmeticOperationInputFromConsole {

	public static void main(String[] args) {
		// Create scanner object to read data from console
		Scanner scan = new Scanner(System.in);
		//Ask user to enter two numbers
		System.out.println("Enter two numbers:");
		//Read the numbers and store it in variables
		int operator1 = scan.nextInt();
		int operator2 = scan.nextInt();
		//Ask user to enter the arithmetic operation to be performed
		System.out.println("Enter the Arithmetic operation to be performed: ");
		//Read the operation to be performed from the console and store it in a String
		String operation = scan.next();
		
		switch(operation)
		{
		case "add":
			System.out.println("Addition of " + operator1+ " and "+operator2+" is :"+(operator1+operator2));
			break;
		case "subtract":
			System.out.println("Subtraction of " + operator2+ " from "+operator1+" is :"+(operator1-operator2));
			break;
		case "multiply":
			System.out.println("Multiplication of " + operator1+ " and "+operator2+" is :"+(operator1*operator2));
			break;
		case "divide":
			System.out.println("Division of " + operator1+ " by "+operator2+" is :"+(operator1/operator2));
			break;
		}
		
scan.close();
	}

}
