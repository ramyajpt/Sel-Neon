package week3Assignment;

public class SecondMaxNumberInIntegerArray {

	public static void main(String[] args) {		
		//Declare an integer array and initialize it.
		int numbers[] = {-11,-2,-3,-4,-5,-1,-3,-2,-8,-9};
		
		
		int temp;//temporary variable to use while interchanging the numbers

		for( int outer=0; outer < numbers.length; outer++)
		{
			for(int inner=outer + 1; inner < numbers.length; inner++)
			{
				if (numbers[outer] > numbers[inner])//compare the two values and interchange the values.
				{
					temp = numbers[outer];
					numbers[outer] = numbers[inner];
					numbers[inner] = temp;
				}
			}
		}
		
		//Print the second Largest number in the array
		System.out.println("The second largest number in the array is :" + numbers[numbers.length - 2]);
		System.out.println("The sorted array looks like : ");
		for(int num : numbers)
			System.out.print(num + ", ");
	}
}