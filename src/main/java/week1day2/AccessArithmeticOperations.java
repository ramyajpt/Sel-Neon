package week1day2;

public class AccessArithmeticOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Accessing the methods in ArithmeticOpeartions class from a different class in the same package...");
		ArithmeticOperations AOObject = new ArithmeticOperations();
		System.out.println("Calling method addition");
		System.out.println(AOObject.addition(1234, 4567));
		System.out.println("Calling method subtraction");
		System.out.println(AOObject.subtraction(4567,1234));
		System.out.println("Cannot call multiplication method, since it is defined as private ");
		//System.out.println(AOObject.multiplication(23, 45));
		System.out.println("Calling method division");
		System.out.println(AOObject.division(485,25));
	}

}
