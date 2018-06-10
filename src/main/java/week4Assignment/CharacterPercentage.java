package week4Assignment;

import java.text.NumberFormat;

public class CharacterPercentage {

	static int upperCaseCount = 0, lowerCaseCount = 0;
	static int digitsCount = 0, specialCharacterCount = 0;
	public static void main(String[] args) {
		String input = "Tiger Runs @ The Speed of 100km/hour.";
		//iterate through each character in the string and increment counters.
		for (int index = 0; index < input.length(); index++)
		{
			char ch = input.charAt(index);
			if(Character.isDigit(ch))
				digitsCount++;
			else if (Character.isUpperCase(ch))
				upperCaseCount++;
			else if (Character.isLowerCase(ch))
				lowerCaseCount++;
			else 
				specialCharacterCount++;
		}
		int stringLength = input.length();
		float individualPercentage = 0.00f;
		//Set the max no of fraction digits to 2, since by default it prints 6 decimal values.
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		individualPercentage = ((upperCaseCount*100f)/stringLength) ;
		System.out.println("The number of uppercase letters is : " + upperCaseCount + ". So percentage is " + nf.format(individualPercentage) + "%");
		
		individualPercentage = ((lowerCaseCount*100f)/stringLength) ;
		System.out.println("The number of lowercase letters is : " + lowerCaseCount + ". So percentage is " + nf.format(individualPercentage) + "%");
		
		individualPercentage = ((digitsCount*100f)/stringLength) ;
		System.out.println("The number of digits is : " + digitsCount + ". So percentage is " + nf.format(individualPercentage) + "%");
		
		individualPercentage = ((specialCharacterCount*100f)/stringLength) ;
		System.out.println("The number of special characters is : " + specialCharacterCount + ". So percentage is " + nf.format(individualPercentage) + "%");
	}

}
