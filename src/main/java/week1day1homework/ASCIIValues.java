package week1day1homework;

public class ASCIIValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		for(i=33; i<=127; i++)
		{
			System.out.println("ASCII Value of "+(char)i + " is "+ i);
		}
	}
//Note: Important ASCII values starts from 33
//ASCII value of AtoZ is 65-90.
//ASCII value of atoz is 97-122.
//ASCII value of numbers 0 to 9 is 48-57
//To get the lower case of an alphabet, use 'A'+32. This would return 'a'.
}
