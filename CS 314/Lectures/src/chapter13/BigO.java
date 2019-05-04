package chapter13;

public class BigO {

	/* Definitions:
	 * 1. Algorithm Analysis: How much time and space does this algorithm need to finish?
	 * 		- In terms of time, if the program takes too long it's bad
	 * 		- In terms of space, if the program requires too much memory it's bad
	 * 2. Best Case: What are the properties of the data set that will lead to
	 * 		the fewest number of executable statements (steps in the algorithm)?
	 * 3. Average Case: Usually this means assuming the data is randomly distributed.
	 * 		Or if I ran the algorithm a large number of times with different sets of
	 *		data what would the average amount of work be for those runs?
	 * 4. Worst Case: What are the properties of the data set that will lead to the
	 * 		largest number of executable statements?
	 * 5. Big-O Notation: Upper-bound (greatest) worst case complexity to measure
	 * 		performance of an algorithm as the size of data, n, increases.
	 *		- Big-O also means Biggest-Order, which denotes the biggest
	 *			order of magnitude for an algorithm
	 * 		- Big-O notation is formatted as O(F(N)) where F(N) is a function
	 * 			for the upper-bound (greatest) order of an algorithm.
	 *		- T(N) is the # of statements executed.
	 *		- Ex: If T(N) = 5N^2 + 5, then F(N) = 5N^2, so O(N^2)
	 */

	/* Big-O Notation Types (Complexities ordered from smallest to largest)
	 * 1. Constant Time: O(1) <- if you double n complexity does not change
	 * 2. Logarithmic Time: O(log(n)) <- if you double n complexity increases slightly
	 * 3. Linear Time O(n) <- if you double n complexity doubles
	 * 4. Linearithmic Time: O(nlog(n)) <- if you double n complexity slightly more than doubles
	 * 5. Quadratic Time: O(n^2) <- if you double n complexity quadruples
	 * 6. Cubic Time: O(n^3) <- if you double n complexity multiplies by 8
	 * 7. Exponential time: O(b^n) where b > 1 <- if you double n complexity multiplies drastically
	 * 8. Factorial Time O(n!) <- if you double n complexity multiplies drastically
	 */

	/* Big-O Notation Rules
	 * 1. Ignore addition or subtraction of n.
	 * 		- EX: O(n + c) = O(n)
	 * 2. Ignore constants of n.
	 * 		- EX: O(cn) = O(n) where c > 0
	 * 3. Choose the largest complexity in a sequence.
	 * 		- EX: f(n) = 7log(n)^3 + 15n^2 + 2n^3 + 8 => O(f(n)) = O(n^3)
	 * 			This is because 2n^3 is the largest complexity, and
	 * 			ignore constants, so the Big-O notation is O(n^3)
	 * 4. Big-O notation is proportional per the size of n.
	 * 		- EX: O(n^2) and the value of n = 1000 it takes 30 seconds,
	 * 			how long does it take when n = 3000?
	 * 			Since O(n^2) when n = 1000 -> 1000^2 = 1000000
	 * 			Since O(n^2) when n = 3000 -> 3000^2 = 9000000
	 * 			Therefore, proportionally 9000000/1000000 = x/30 = 9, so 9 * 30 = x = 270 seconds
	 * 5. If a question asks for the Big-O (Order) and never specifies case, then assume average case.
	 */

	// an algorithm in terms of n that runs on O(1) time
	public static void constantTime() {
		int a = 1; // 1 statement executed
		int b = 2; // 1 statement executed
		int c = a + 5*b; // 1 statement executed

		int i = 0; // 1 statement executed
		while(i < 10) { // 10 statements executed
			i++; // 1 statement executed
		}

		// T(N) = 1 + 1 + 1 + 1 + 10 + 1 = 15, which simplifies O(1)
	}

	// an algorithm (binary search) in terms of n that runs on O(log2(n)), can be simplified to O(log(n)) time
	public static int logarithmicTime(int[] arr, int value) {
		int n = arr.length;
		int low = 0;
		int high = n - 1;

		// discards half of a sorted Array each iteration (divide and conquer technique)
		/* because the algorithms cuts in half the base is 2, so the
			worst case scenario is F(n) = log base 2 of n = log2(n) */
		while(low <= high) {
			int mid = (low + high) / 2;
			if(arr[mid] == value) {
				return mid;
			} else if(arr[mid] < value) {
				low = mid + 1;
			} else if(arr[mid] > value) {
				high = mid - 1;
			}
		} // O(F(n)) = O(log2(n)) but can be simplified to O(log(n))
		return -1;
	} // algorithms tend to have a logarithmic term when using a divide and conquer technique

	// an algorithm in terms of n that runs on O(n) time
	public static void linearTime(int n) {
		int x = 3 * 5; // O(1) (doesn't rely on n)

		int i = 0;
		while(i < n) {
			i++; // F(n) = n (loop finishes linearly)
		} // O(F(n)) = n

		int j = 0;
		while(j < n) {
			j += 3; // F(n) = 1 / 3 * n = n / 3 (loop finishes 3x faster)
		} // O(F(n)) = O(n)

		// Complexity: O(1) + O(n) + O(n) => O(n)
	}
	
	// an algorithm that uses an outer loop of log2(N) with a dependent inner-loop, runs on O(N) time
	public static void innerLogLinearTime(int n) {
		while(n > 1) { // f(n) = log2(n)
			for(int i = 0; i < n; i++) {
				/* This may seem like a O(n*log2(n)) solution, but the total
					iterations is about 2*n times if you sum them up */
			} // f(n) = n + n / 2 + n / 4 + ... = 2*n
			n /= 2;
		}
		// Complexity: O(log2(n) + 2*n) = O(n)
	}

	// an algorithm in terms of n that runs on O(n^2) time
	public static void quadraticTime(int n) {
		for(int i = 0; i < n; i++) { // F(n) = n
			for(int j = 0; j < n; j++) { // F(n) = n * n = n^2

			}
		}// O(F(n)) = O(n^2)

		for(int i = 0; i < n; i++) { // f(n) = n
			for(int j = i; j < n; j++) { // f(n) = n * (n + 1) / 2

			}
		} // O(F(n)) = O(n^2)

		int i = 0;
		while(i < n) { // f(n) = n
			int j = 0;
			while(j < 3 * n) { // f(n) = n * (3n) = 3n^2
				j++;
			}
			j = 0;
			while(j < 2 * n) { // f(n) = n * (3n + 2n) = 5n^2
				j++;
			}
			i++;
		} // O(F(n)) = O(n^2)

		// Complexity: O(n^2) + O(n^2) + O(n^2) => O(n^2)
	}
	
	// an algorithm in terms of n that runs on O(n^2) time with a dependent loop
	public static void dependentQuadraticTime(int n) {
		for(int i = 0; i < n; i++) { // O(N)
			for(int j = 0; j < i; j++) { // O(n) * O((n*(n-1))/2) = O(n^2)
				/* This may seem like it's not a O(n^2) solution, but a dependent
					loop is considered n*(n-1)/2 time, so multiply by the
					outer loop which is O(n), and it simplifies to O(n^2). */
			}
		}
		// Complexity: O(n) + O(n^2) = O(n^2)
	}

	// an algorithm in terms of n that runs on O(n^4) time
	public static void quarticTime(int n) {
		int i = 0;
		while(i < 3 * n) { // f(n) = 3n
			int j = 10;
			while(j <= 50) { // f(n) = 3n * (1)
				j++;
			}
			j = 0;
			while(j < n * n * n) { // f(n) = 3n * (1 + n^3)
				j += 2;
			}
			i++;
		} // O(f(n)) = O(n^4)

		// Complexity: O(n^4) => O(n^4)
	}
	
	// an algorithm in terms of n that runs on O(1) space
	public static void constantSpace(int n) {
		int i = 0; // 1 space used
		while(i < n) {
			int j = 0; // 1 space used, because garbage collection
		}
		// Complexity: O(1) + O(1) + O(1) => O(1)
	}
	
	// an algorithm in terms of n that runs on O(n) space
	public static void linearSpace(int n) {
		int[] nArray = new int[n]; // O(N) space, creates N new integer variables as an Array
		int[][] n2DArray = new int[n][n]; // O(N^2) space, creates N^2 new integer variables as an Array
		for(int i = 0; i < n; i++) { // O(1) space
			nArray[i] = 5; // No space because we already declared and initialized the Object
			for(int j = 0; j < n; j++) { // O(1) [NOT O(N)] space because garbage collection
				n2DArray[i][j] = 5; // No space because we already declared and initialized the Object
			}
		}
		// Complexity: O(N) + O(N^2) = O(N^2)
	}
}
