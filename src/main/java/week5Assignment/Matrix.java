package week5Assignment;

public class Matrix {

	public static void main(String[] args) {
		// Construct a n*n matrix
		//Declare a two dimensional array.
		//This code does not handle m*n type of array.
		/*int[][] matrix = {{1,2,3,4,1,2,3},
						{5,6,7,8,5,6,7},
						{9,10,11,12,9,10,11},
						{13,14,15,16,13,14,15},
						{17,18,19,20,21,22,23},
						{1,2,3,4,1,2,3},
						{5,6,7,8,5,6,7}};*/
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

		int min =-1, max = matrix[0].length;
		int i,j;

		do
		{
			min = min + 1;
			max = max - 1;
			i = min;
			for(j = min; j < max; j++)
				System.out.print(matrix[i][j]+ " ");
			//The next line is not necessary as the loop closes with j = max.
			//j = max;
			for (i = min; i < max; i++)
				System.out.print(matrix[i][j] + " ");
			//i = max;
			for (j = max; j > min; j--)
				System.out.print(matrix[i][j] + " ");
			//j = min;
			for (i = max; i > min; i--)
				System.out.print(matrix[i][j] + " ");
			if(max == min)//To take care of <oddNumber>*<oddNumber> type of arrays
			{
				System.out.print(matrix[i][j] + " ");
				break;
			}
		}while(max != (min+1));

	}

}
