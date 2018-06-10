package week1day2;

public class SumOfDigits {
	public static void main(String[] args)
	{
		int inputNumber = 12354;
		int sum = 0;
		int quotient, remainder;
		System.out.println("Given number is : "+ inputNumber);
		while(inputNumber>0)
		{
			quotient=inputNumber/10;
			remainder=inputNumber%10;
			sum=sum+remainder;
			inputNumber=quotient;
		}
		System.out.println("Sum of the digits of the given number is : "+ sum );
	}

}
