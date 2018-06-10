package week1day1homework;

public class EscapeCharactersInJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Backspace      : " + "abcd\befgh");
		System.out.println("Formfeed       : " + "abcd\fefgh");
		System.out.println("Linefeed       : " + "abcd\nefgh");
		System.out.println("Single Quote   : " + "abcd\'efgh");
		System.out.println("Double Quote   : " + "abcd\"efgh");
		System.out.println("Backslash      : " + "abcd\\efgh");
		System.out.println("Horizontal Tab : " + "abcd\tefgh");
		System.out.println("Carriage Return: " + "abcd\refgh");
		//I don't find any difference between Linefeed and carriage return.
	}

}
