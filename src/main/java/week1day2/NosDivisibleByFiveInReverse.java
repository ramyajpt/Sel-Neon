package week1day2;

public class NosDivisibleByFiveInReverse {

	public static void main(String[] args){
		int count;
		for(count=100; count>=1; count--)
		{
			if(count%5==0)
			{
				System.out.println(count);
			}
		}
	}
}
