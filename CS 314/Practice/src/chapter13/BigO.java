package chapter13;

// CS314 Section Problems - Algorithm Analysis
public class BigO {

	public void firstProblem() {
		/* Question:
		 * A method is O(2^N). It takes 1 second for the method to complete when N = 50.
		 * What is the expected time in seconds to complete when N = 54?
		 */

		/* Answer:
		 * [make proportion] (2^50) / (2^54) = 1 / x
		 * [simplify proportion] 1 / 2^4 = 1 / x
		 * [multiply proportion] 1 * x = 16 * 1, so x = 16
		 * time = 16 seconds
		 */
	}

	public void secondProblem() {
		/* Question:
		 * A method is O(N^2log2(N)). It takes 20 seconds for the method to complete when N = 1_000_000.
		 * What is the expected time in seconds to complete when N = 2_000_000?
		 * Assume log2(1_000_000) = 20
		 */

		/* Understand:
		 * log2(1000) = 10, log2(1_000_000) = 20, log2(1_000_000_000) = 30
		 * - Because 1000^1 = 1000, 1000^2 = 1_000_000, 1000^3 = 1_000_000_000
		 * 
		 * This works for other log bases as well.
		 * log4(1000) = 5, log4(1_000_000) = 10, log4(1_000_000_000) = 15
		 * - Because 1000^1 = 1000, 1000^2 = 1_000_000, 1000^3 = 1_000_000_000
		 * 
		 * Also, logs with parameters can be determined if a very close log is determined.
		 * log2(1000) = 10, so log2(2000) = 11
		 * - Because if 2^10 = 1000, then 2^11 = 1000 * 2 = 2000
		 */

		/* Answer
		 * [make proportion] (1_000_000)^2 * 20 / (2_000_000)^2 * log2(2_000_000) = 20 / x
		 * [simplify proportion] (1_000_000)^2 * 20 / (2_000_000)^2 * 21 = 20 / x
		 * [simplify proportion] 1 * 20 / 4 * 21 = 20 / x
		 * [multiply proportion] 20 / 84 = 20 / x
		 * time = 84 seconds
		 */
	}

	public void thirdProblem() {
		/* Question:
		 * What is the T(N) for method a? Recall, T(N) is the function that represents the ACTUAL
		 * number of executable statements for a function or algorithm. N = listA.length = listB.length.
		 */

		/* Answer:
		 * T(N) = 1 + 1 + (N + 1) + N + N + N(N + 1) + N^2 + N^2 + N^2 + N^2 + 1 = 5N^2 + 4N + 4
		 */
	}

	// for use with the third problem
	public int a(int[] listA, int[] listB) {
		int total = 0; // 1
		for(int i = 0; i < listA.length; i++) { // 1 + (N + 1) + N
			for(int j = 0; j < listB.length; j++) { // N + N(N + 1) + N^2
				total += listA[i] * listB[j]; // N^2
				total += listA[i] / 10; // N^2
				total += listB[j] / 100; // N^2
			}
		}
		return total; // 1
	}

	public void fourthProblem() {
		/* Question:
		 * What is the worst case order (Big O) of method d? Assume Arrays.fill is
		 * O(N) and method process is O(N). N = data.length.
		 */

		/* Answer:
		 * O(N^2) because Arrays.fill, process() is O(N), new int[data.length]
		 * is O(N), and the outer for loop is O(N), so ignore coefficients and N * N = N^2.
		 */
	}

	// for use with the fourth problem
	public int[] d(int[] data, int key) {
		int[] result = new int[0];
		for(int i = 0; i < data.length; i++) {
			if(data[i] == key) {
				result = new int[data.length]; // N * N = N^2
				Arrays.fill(data, i); // N * N = N^2
				process(data, i, key); // N * N = N^2
			}
		}
	}

	public void fifthProblem() {
		/* Question 1:
		 * What is the best cases order of the following method?
		 * Assume method check is O(1) and that method process is O(1).
		 */

		/* Answer 1:
		 * O(1) because check is O(1), and it could always return false in the best case.
		 */

		/* Question 2:
		 * If method check from question 6 is O(N) where N is the number of rows
		 * in mat (mat.length), what is the best case order of num6?
		 */

		/* Answer 2:
		 * O(N) because check() could still return false and since check() itself
		 * takes O(N) time to finish, the answer has to be O(N).
		 */

		/* Question 3:
		 * What is the best cases order of the following method?
		 * Assume method check is O(1) and that method process is O(1).
		 */

		/* Answer 3:
		 * O(1) because check is O(1), and it could always return false in the best case.
		 */

		/* Question 4:
		 * What is the best cases order of the following method?
		 * Assume method check is O(1) and that method process is O(1).
		 */

		/* Answer 4:
		 * O(N) because check() could still return false and since check() itself
		 * takes O(N) time to finish, the answer has to be O(N).
		 */
	}

	// for use with the fifth problem
	public int num6(int[][] mat) {
		int result = 0;
		for(int r = 0; check(r, mat); r++) {
			int[] row = mat[r];
			for(int c = 0; c < mat[0].length; c++) {
				int val = mat[r][c];
				result += process(val, mat, row);
			}
		}
		return result;
	}

	public void sixthProblem() {
		/* Question 1 :
		 * What is the output by the following code? (It is very gacky)
		 */

		/* Answer 1:
		 * Since r = N * log2(N) and N = 64
		 * r = 64 * log2(64) = 64 * 6 = 256
		 */

		/* Question 2 :
		 * What is the output by the following code if int n = 1024; ?
		 */

		/* Answer 2:
		 * Since r = N * log2(N) and N = 1024
		 * r = 1024 * log2(1024) = 1024 * 10 = 10240
		 */
	}

	// for use with the sixth problem
	public void gacky() {
		int n = 64; // Question 2 sets n = 1024
		int r = 0;
		for(int i = 1; i <= n; i *= 2) { // runs log2(N) times
			for(int j = 1; j <= i; j++) { // runs N * log2(N) times
				r++; // runs N * log2(N) times
			}
		}
		System.out.println(r);
	}
}
