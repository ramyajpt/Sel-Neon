package week2Assignment;

public class SwapTwoNumbers {

	public static void main(String[] args) {
		int a =2, b = 3;
		System.out.println("Before exchange: a = " + a + " & b = " + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("After exchange: a = " + a + " & b = " + b);
	}

}
