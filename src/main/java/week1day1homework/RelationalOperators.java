package week1day1homework;

public class RelationalOperators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=10;
		int num2=5;
		int num3=5;
		if(num1>num2)
		{
			System.out.println("Is num1 greater than num2?..." + (num1>num2));
		}
		if(num2>=num3)
		{
			System.out.println("Is num2 is greater than or equal to num3?... " + (num2>=num3));
		}
		if(num2==num3)
		{
			System.out.println("Is num2 is equal to num3?... " + (num2==num3));
		}
		
		System.out.println("Is num1 not equal to num3?... "+ (num1!=num3));
		System.out.println("Is num2 less than or equal to num1?... "+ (num2<=num1));
		System.out.println("Is num3 less than num1?... "+ (num3<=num1));
	}

}
