package week6Assignment;

public class LearnStaticKeyword {
	
	public static String word1 = "Hello";
	public String word2 = "World";

	public static void main(String[] args) {
		LearnStaticKeyword lsk = new LearnStaticKeyword();
		printStaticString();
		lsk.printNonStaticString();	
	}
	
	public static void printStaticString() {
		System.out.println(word1);
	}
	
	public void printNonStaticString() {
		System.out.println(word2);
	}

}
