package week6Assignment;

public class AllPossibleCombinationsOfDigits {

	/*public static void main(String[] args) {
		int input = 123;
		String number = input + "";
		
		

	}
*/
	 public static int reverseNumber(int no)
	 { 
	  int ono=0,rev=0,rem;
	  ono=no;
	  while(ono!=0)
	  {
	   rem=ono%10;
	   ono/=10;
	   rev= (rev*10)+rem;
	  }
	  return rev;
	 
	 }
	 
	 public static void main(String[] args) 
	 {
	  int no;
	
	  no=1234;
	  String str= no+"";
	  for (int x = 0; x < 4; x++) {
          for (int y = 0; y < 4; y++) {
              for (int z = 0; z < 4; z++) {

                  if (x != y && y != z && z != x) {
                      System.out.println(str.charAt(x) + "" + str.charAt(y) + ""
                              + str.charAt(z));
                  }
              }
          }
      }
	 /* for(int j=0;j<3;j++)
	  {
	   for(int i=0;i<4;i++)
	   {
	    rem=no%10;
	    no=no/10;
	    no=(rem*1000)+no;
	    System.out.println("numbers are:"+no);
	   }
	   no=reverseNumber(no);
	  }*/
	 }
}
