package week1Assignment;

public class StringArraytoIntArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "11,22,33,44";
		String []strArray = str.split(",");
		int []numbers = new int[strArray.length];
		
		int index =0;
		for (String s :strArray)
		{
			numbers[index] = Integer.parseInt(s);
			System.out.println(numbers[index]);
			index++;
		}

	}

}
