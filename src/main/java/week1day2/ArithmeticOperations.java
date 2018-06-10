package week1day2;

public class ArithmeticOperations {
	
	static int addition(int operator1, int operator2)
	{
		int result	= operator1 + operator2;
		System.out.println("In addition method definition with default access");
		System.out.println(result);
		System.out.println("Exiting addition method definition");
		return result;
	}
	
	public static int subtraction(int operator1, int operator2)
	{
		int result	= operator1 - operator2;
		System.out.println("In subtraction method definition with public access");	
		System.out.println(result);
		System.out.println("Exiting subtraction method definition");
		return result;
	}
	
	private static int multiplication(int operator1, int operator2)
	{
		int result	= operator1 * operator2;
		System.out.println("In Multiplication method definition with private access");	
		System.out.println(result);
		System.out.println("Exiting multiplication method definition");
		return result;
	}
	
	protected static int division(int operator1, int operator2)
	{
		int result	= operator1 / operator2;
		System.out.println("In Division method definition with protected access");	
		System.out.println(result);
		System.out.println("Exiting division method definition");
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Calling method addition");
		System.out.println(addition(1234, 4567));
		System.out.println("Calling method subtraction");
		System.out.println(subtraction(4567,1234));
		System.out.println("Calling method multiplication");
		System.out.println(multiplication(23, 45));
		System.out.println("Calling method division");
		System.out.println(division(485,25));
	}
}
