package week1day1homework;

public class DataTypeRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("The size of byte datatype is: " + Byte.SIZE + " bits");
		System.out.println("The size of character datatype is: " + Character.SIZE + " bits");
		System.out.println("The size of short datatype is: " + Short.SIZE + " bits");
		System.out.println("The size of integer datatype is: " + Integer.SIZE + " bits");
		System.out.println("The size of Long datatype is: " + Long.SIZE + " bits");
		System.out.println("The size of float datatype is: " + Float.SIZE + " bits");
		System.out.println("The size of long datatype is: " + Long.SIZE + " bits");
		System.out.println();
		//Note: There is no SIZE method for Boolean datatype.
		//Boolean occupies just one bit of information
		long byteRange= (long) Math.pow(2,(Byte.SIZE-1));
		long charRange=(long) Math.pow(2,(Character.SIZE));
		long shortRange=(long) Math.pow(2,(Short.SIZE-1));
		long intRange=(long) Math.pow(2,(Integer.SIZE-1));
		long longRange=(long) Math.pow(2,(Long.SIZE-1));
		//Math.pow returns double. Hence type casting is necessary
		//By type casting to short/int we are loosing the last bit of data.
		//Observe the range value for long.
		System.out.println("Range of byte datatype is: -"+byteRange + " to "+ (byteRange-1) );
		System.out.println("Range of character datatype is:  0 to "+ charRange + ",because character type is unsigned");
		System.out.println("Range of short datatype is: -"+ shortRange + " to "+ (shortRange-1) );
		System.out.println("Range of int datatype is: -"+intRange + " to "+ (intRange-1) );
		System.out.println("Range of long datatype is: -"+longRange + " to "+ (longRange-1) );


	}

}
