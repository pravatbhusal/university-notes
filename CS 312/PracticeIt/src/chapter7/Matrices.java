package chapter7;

public class Matrices {

	/* Write a method named matrixAdd that accepts a pair of two-dimensional 
	 * arrays of integers as parameters, treats the arrays as 2D matrices and adds 
	 * them, returning the result. The sum of two matrices A and B is a matrix C 
	 * where for every row i and column j, Cij = Aij + Bij. You may assume that 
	 * the arrays passed as parameters have the same dimensions.
	 */
	public static int[][] matrixAdd(int[][] args1, int[][] args2) {
		// args1 and args2 have the same dimensions
		// get rows and columns
		final int ROWS = args1.length;
		int COLUMNS = 0;
		if(ROWS != 0) {
			COLUMNS = args1[0].length;
		}
		int[][] addedMatrix = new int[ROWS][COLUMNS];

		// add each row and column together from args1 and args2
		for(int row = 0; row < ROWS; row++) {
			for(int column = 0; column < COLUMNS; column++) {
				addedMatrix[row][column] = args1[row][column] + args2[row][column];
			}
		}
		return addedMatrix;
	}
}
