package week1day1homework;

public class NestedIf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isHungry = false;
		String myDay = "Friday";
		if (isHungry)
		{
			if(myDay == "Friday")
			{
				System.out.println("I am Hungry..But i can't have Non-Veg today");
			}
			else
			{
				System.out.println("I am Hungry. I am going to have Non-Veg today");
			}
		}
		else
		{
			System.out.println("I am not hungry");
		}

	}

}
