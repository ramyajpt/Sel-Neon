package week1day1homework;

public class LogicalOperatorsSimpleIfLadderIf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ladder-if example
		int n1=9;
		int n2=5;
		int n3=3;
		if((n2>n1) && (n2>n3))
		{
			System.out.println("n2 is the largest");
					}
		else if((n1>n2) && (n1>n3))
		{
			System.out.println("n1 is the largest");
					}
		else
		{
			System.out.println("n3 is the largest");
		}
		
		if ((n1>n2) || (n1<n3))
		{
			System.out.println("Checking (n1>n2) || (n1<n3)...");
			System.out.println("The || operator does not take into acoount the second condition, if the first condition is true");
		}
		
		if(!(n1<n2))
		{
			System.out.println("Checking (!(n1<n2))...");
			System.out.println("The result is : " + (!(n1<n2)));
		}
	}
}


