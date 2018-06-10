package week5Assignment;

public class UniqueCharInString {
	static String name ;
	public static void main(String[] args) {
		name = "Good Looking";
		for (int index = 0; index < name.length(); index++)
		{
			if(Character.isLetterOrDigit(name.charAt(index)))
			{
				if(!isRepeating(index))
				{
					System.out.print(Character.toLowerCase(name.charAt(index)));
				}
			}
		}		
	}
	public static boolean isRepeating(int index)
	{
		char ch1 = name.charAt(index);
		
		for (int i = index-1; i >= 0; i--)
		{
			char ch2 = name.charAt(i);
			if (Character.toLowerCase(ch1) == Character.toLowerCase(ch2))
			{
				return true;
			}		
		}
		return false;
	}
}
