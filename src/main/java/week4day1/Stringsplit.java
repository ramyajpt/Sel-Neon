package week4day1;

public class Stringsplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "?58,999";
		String replace = str.replaceAll("[?,]", "");
		//String st[]=str.split("//?");
		//for(String s: st)
		System.out.println(replace);
		int parseInt = Integer.parseInt(replace);
	
			System.out.println(""+parseInt);
		

	}

}
