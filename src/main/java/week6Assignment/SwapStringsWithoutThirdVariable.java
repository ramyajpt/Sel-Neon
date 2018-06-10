package week6Assignment;

public class SwapStringsWithoutThirdVariable {

	public static void main(String[] args) {
		String input1 = "ABC", input2 = "DEF";
		System.out.println("Before Exchange: ");
		System.out.println("String1 : " + input1);
		System.out.println("String2 : " + input2);
		input1 = input1 + input2;
		input2 = input1.substring(0, (input1.length() - input2.length()));
		input1 = input1.substring(input1.length() - input2.length());
		System.out.println("After Exchange: ");
		System.out.println("String1 : " + input1);
		System.out.println("String2 : " + input2);
	}
}
