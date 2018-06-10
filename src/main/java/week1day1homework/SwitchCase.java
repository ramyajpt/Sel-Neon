package week1day1homework;

public class SwitchCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String myOperation="subtract";
		int op1 = 28;
		int op2 = 42;
		switch(myOperation)
		{
		case "add":
			System.out.println("Addition of " + op1+ " and "+op2+" is :"+(op1+op2));
			break;
		case "subtract":
			System.out.println("Subtraction of " + op1+ " from "+op2+" is :"+(op2-op1));
			break;
		case "multiply":
			System.out.println("Multiplication of " + op1+ " and "+op2+" is :"+(op1*op2));
			break;
		case "divide":
			System.out.println("Division of " + op2+ " by "+op1+" is :"+(op2/op1));
			break;
		}
	}
}
