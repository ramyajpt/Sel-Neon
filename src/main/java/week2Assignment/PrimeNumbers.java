package week2Assignment;

import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Prime numbers below a given range...");
		System.out.println("Enter the range : ");
		
		int range = scan.nextInt();
		System.out.println("The list of prime numbers below " + range + " is: ");
		for (int i =1; i < range; i++)
		{
			int count = 0;
			for(int j = 2; j < i; j++)
			{
				if(i%j == 0)
					count++;
			}
			if(count == 0)
				System.out.print(i + " ");
		}
		scan.close();
	}
}