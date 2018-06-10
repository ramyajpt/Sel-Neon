package week1day2;

public class SumOfNumbersInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numberArray = {11, 22,33,44,55};
		int sum=0;
		for(int individual: numberArray)
		{
			sum = sum + individual;
		}
		System.out.println("Sum of the given Array is : " + sum);
	}

}
