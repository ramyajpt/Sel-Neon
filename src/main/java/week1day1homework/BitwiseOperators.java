package week1day1homework;

public class BitwiseOperators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=37;
		int b=67;
		System.out.println("AND operation...Binary AND Operator copies a bit to the result if it exists in both operands.");
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		System.out.println("--------");
		System.out.println(Integer.toBinaryString(a&b));
		System.out.println("--------");
		System.out.println("OR operation...Binary OR Operator copies a bit if it exists in either operand.");
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		System.out.println("--------");
		System.out.println(Integer.toBinaryString(a|b));
		System.out.println("--------");
		System.out.println("XOR operation...Binary XOR Operator copies the bit if it is set in one operand but not both");
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		System.out.println("--------");
		System.out.println(Integer.toBinaryString(a^b));
		System.out.println("--------");
		System.out.println("Compliment operation...Flips each bit");
		System.out.println(Integer.toBinaryString(b));
		System.out.println("--------");
		System.out.println(Integer.toBinaryString(~b));
		System.out.println("--------");
		System.out.println("Left shift operation...");
		System.out.println(Integer.toBinaryString(b));
		System.out.println("--------");
		System.out.println(Integer.toBinaryString(b<<2));
		System.out.println("--------");
		System.out.println("Right shift operation...");
		System.out.println(Integer.toBinaryString(b));
		System.out.println("--------");
		System.out.println(Integer.toBinaryString(b>>3));
		System.out.println("--------");
		System.out.println("Zero fill Right shift operation...");
		System.out.println(Integer.toBinaryString(b));
		System.out.println("--------");
		System.out.println(Integer.toBinaryString(b>>>3));
		System.out.println("--------");
		
	
	}

}
