package week4Assignment;

public class PasswordCheck {
	static final int PASSWORD_LENGTH = 10;
	static boolean containsUpperCase = false;

	public static void main(String[] args) {

		String password = "abcD12efgh";
		
		if(isValidPassword(password))
			System.out.println("Yes. The string '" + password + "' is a valid password.");	
		else
			System.out.println("No. The string '" + password + "' is not a valid password");


	}

	static boolean isValidPassword(String password) {
		int alphabetCount = 0 , numCount = 0;
		if(password.length() < PASSWORD_LENGTH)
		{
			System.out.println("The password is not 10 characters long.");
			return false;
		}
		else
		{ 
			for(int index =0; index < password.length(); index++)
			{
				char ch = password.charAt(index);

				if(Character.isDigit(ch)) 
					numCount++;
				else if(Character.isLowerCase(ch) || (Character.isUpperCase(ch)))
				{
					alphabetCount++;
					if(Character.isUpperCase(ch))
						containsUpperCase = true;
				}
				else
				{
					System.out.println("The password contains special characters");
					return false;
				}
			}
			//if (numCount >=2 && alphabetCount >= 2 && containsUpperCase )
			//return true;
			if(numCount<2)
			{
				System.out.println("The number of digits is less than 2.");
				return false;
			}			
			if(alphabetCount<2)
			{
				System.out.println("The number of alphabets is less than 2.");
				return false;
			}
			if (!containsUpperCase)
			{
				System.out.println("The password does not contain an Uppercase alphabet");
				return false;
			}
		}			
		return true;
	}

}
