package week6Assignment;

public class LongestPositiveSequence {

	public static void main(String[] args) {
		int[] numbers = {-1,-2,3,-4,5,6,7,-8,9};
		int count = 0, index = 0, maxCount = 0, maxIndex = 0;
		for(int x = 0; x < numbers.length; x++)
		{
			if(numbers[x] > 0)
			{
				if(count == 0)
					index = x;
				count++;
			}
			else
			{
				if(count > maxCount)
				{
					maxCount = count;
					maxIndex = index;
				}
				count = 0;
			}
		}
		if(maxCount == 0) {
			System.out.println("There are no positive integers in the given array.");
		} 
		else {
			System.out.print("The longest positive sequence is : ");
			for(int x = maxIndex; x < (maxCount+maxIndex); x++)
				System.out.print(numbers[x] + " ");
			System.out.println();
			System.out.println("Count: " + maxCount);
		}
	}

}
