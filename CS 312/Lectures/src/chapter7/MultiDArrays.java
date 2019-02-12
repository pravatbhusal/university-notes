package chapter7;

public class MultiDArrays {

	/* Definitions:
	 * 1. Multi-Dimensional Arrays: Arrays with multiple indexes (dimensions).
	 * 		- EX: int[][] grid = new int[3][3]; <- 2D Array
	 * 		- EX: int[][][] grid = new int[3][3][3]; <- 3D Array
	 * 2. Rectangular Array: A 2D Array with the same length of indexes.
	 * 		- EX: int[][] grid = new int[3][3] <- same indexes
	 * 3. Ragged Array: An Array with different length of indexes.
	 * 		- EX: int[][] grid = new int[3][4]; <- different indexes
	 * 4. Parallel Arrays: 2 or more Arrays that have corresponding indexes.
	 * 		- EX: int[] grid1 = new int[3]; <- indexes correspond to grid2
	 * 		- EX: int[] grid2 = new int[3]; <- indexes correspond to grid1
	 */

	/* Extra Notes:
	 * 1. 2D Arrays can be used to make games, like checkers or chess.
	 */

	/* Programming Hygiene Tips:
	 * 1. In 2D Arrays, the first index conveys rows and the second conveys columns.
	 */

	public static void main(String[] args) {
		// creating a 2D Array <- Read Definitions #1 for more info
		int[][] grid2D = new int[5][3]; // 5 rows, 3 columns
		int gridRows = grid2D.length; // 5
		int gridColumns = grid2D[0].length; // 3

		// multi-dimensional Arrays
		int[][][] grid3D = new int[5][3][7];
		int gridX = grid3D.length; // 5
		int gridY = grid3D[0].length; // 3
		int gridZ = grid3D[0][0].length; // 7

		// traversing a 2D Array and outputting each item
		for(int row[] : grid2D) {
			for(int column : row) {
				System.out.print(column + " ");
			}
			System.out.println();
		}
	}
}
