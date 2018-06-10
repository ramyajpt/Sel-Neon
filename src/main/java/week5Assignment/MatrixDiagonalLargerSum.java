package week5Assignment;

public class MatrixDiagonalLargerSum {
	
	static int rows, columns, currentRow, currentColumn ;
	static int lowerMatrixSum =0, upperMatrixSum =0;
	static int elements, index;
	
	public static void main(String[] args) {
		//int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int [][] matrix = {{7,8,9},{4,5,6},{1,2,3}};
		rows = matrix.length;
		columns = matrix[0].length;
		elements = (rows*(columns-1))/2;
		int tempArray[] = new int[elements];
		//Calculate the sum of the elements in the diagonally upper half matrix
		tempArray = elementsInUpperMatrix(matrix);
		for(int each : tempArray)
			upperMatrixSum = upperMatrixSum + each;
		//Calculate the sum of the elements in the diagonally lower half matrix
		tempArray = elementsInLowerMatrix(matrix);
		for(int each : tempArray)
			lowerMatrixSum = lowerMatrixSum + each;
		if(lowerMatrixSum > upperMatrixSum)
			tempArray = elementsInLowerMatrix(matrix);
		else
			tempArray = elementsInUpperMatrix(matrix);
		System.out.println("The list of elements with greater sum : ");
		for(int each : tempArray)
			System.out.print(each + " ");		
		
	}
	
	public static int[] elementsInLowerMatrix(int[][] matrix)
	{
		int temp = columns;	
		int[] lowerMatrixElements = new int[elements]; 
		index = 0;
		for(currentRow = 1; currentRow < rows ; currentRow++)
		{
			for (currentColumn = temp-1; currentColumn < columns  ; currentColumn++)
			{
				lowerMatrixElements[index] = matrix[currentRow][currentColumn];
				index++;
				/*System.out.print(matrix[currentRow][currentColumn] + ", ");
				lowerMatrixSum = lowerMatrixSum + matrix[currentRow][currentColumn];*/
			}
			temp--;
		}
		return lowerMatrixElements;
	}
	
	public static int[] elementsInUpperMatrix(int[][] matrix)
	{
		int temp = columns;
		int[] upperMatrixElements = new int[elements]; 
		index = 0;
		for(currentRow = 0 ; currentRow < rows; currentRow++)
		{
			for(currentColumn = 0; currentColumn < temp-1; currentColumn++)
			{
				upperMatrixElements[index] = matrix[currentRow][currentColumn];
				index++;
				/*System.out.print(matrix[currentRow][currentColumn] + ", ");
				upperMatrixSum = upperMatrixSum + matrix[currentRow][currentColumn];*/
			}
		temp--;	
		}
		return upperMatrixElements;
	}

}
