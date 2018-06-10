package week3Assignment;

public class DuplicateInIntegerArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intArray[] = {1,2,3,4,5,6,7,8,9,3,6,4,1};
		boolean isDuplicatePresent = false;
		System.out.println("Duplicate entries in the array: ");
		for(int outer = 0; outer < intArray.length; outer++)
		{
			for(int inner = outer+1; inner < intArray.length; inner++)
				if(intArray[outer] == intArray[inner])
				{
					//Say duplicate entry is present.
					isDuplicatePresent = true;
					//Print the Duplicate number.
					System.out.print(intArray[outer] + " ");
				}			
		}
		//Check if duplicate entries are not present.
		if(!isDuplicatePresent)
		{
			//Print there are no duplicate entries
			System.out.println("No duplicate entries.");
		}
	}
}
