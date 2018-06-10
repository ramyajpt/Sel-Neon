package week3Assignment;

public class ArmstrongNumber {


	public static void main(String[] args) {

		int minRange = 100, maxRange = 1000;
		System.out.println("This program lists the Armstrong numbers from 100 to 1000. \rEx: 153 is an Armstrong number. 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153.");
		for(int num = minRange; num <= maxRange; num++)
		{
			int sum = 0;
			int quotient, remainder;
			//Separate the digits from the number; Calculate the cube of the digits; Sum the cubes
			while(num>0)
			{
				quotient=num/10;
				remainder=num%10;
				sum=sum + (int)(Math.pow(remainder, 3));
				num=quotient;
			}

			if (num == sum)
				System.out.print(num + " ");	
		}
	}
}
