package week5Assignment;

import java.util.HashSet;
import java.util.Set;

public class UniquesDigitsInNumber {

	public static void main(String[] args) {
		int number = 186553;
		
		Set<Integer> result = new HashSet<>();
		
		while(number > 0)
		{
			int remainder = number % 10;
			number = number/10;
			result.add(remainder);
		}
		for(int i : result)
			System.out.print(i);
	}

}
