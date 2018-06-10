package week2Assignment;

public class StringSplitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "SampleCompanyName (10480)";
		String split[] = str.split("\\(");
		for(String s : split)
		{
			System.out.println(s);
			//if (s.equals("SampleCompanyName"))
				System.out.println(s.trim().equals("SampleCompanyName"));
		}
	}

}
