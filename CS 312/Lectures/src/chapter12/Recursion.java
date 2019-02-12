package chapter12;

public class Recursion {

	/* Definitions:
	 * 1. Recursion: A technique in which a method calls itself until
	 * 		it arrives at a base case where it stops and finishes
	 * 		the method's call stack.
	 * 2. Base case: A case where recursion stops.
	 */

	public static void main(String[] args) {
		/* getFactorial(5) Analysis:
		 * 5! <- 120
		 * 5 * 4! <- 120
		 * 4 * 3! <- 24
		 * 3 * 2! <- 6
		 * 2 * 1! <- 2
		 * 1! = 1 <- 1
		 */
		int fiveFactorial = getFactorial(5); // 120
		System.out.println(fiveFactorial); // output: 120
		
		/* recMystery(3) Analysis:
		 * first call: 3
		 * first recursive call: (3 - 1) = 2
		 * second recursive call: (2 - 1) = 1
		 * third recursive call: (1 - 1) = 0
		 * fourth recursive call: stop, returns 1
		 * returns: (1 + 1 * 2) = 2 -> (2 + 2 * 2) = 6 ->
		 * 				(6 + 3 * 2) = 13
		 */
		int threeRecMystery = recMystery(3); // 13
		System.out.println(threeRecMystery); // output: 13

		// for loop recursion
		forLoop(0, 5); // output: 0 1 2 3 4
	}

	// a recursive solution to the factorial of a number
	public static int getFactorial(int num) {
		/* How factorials work:
		 * !5 = 5 * 4 * 3 * 2 * 1
		 * !3 = 3 * 2 * 1
		 * !9 = 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1
		 */

		// base case <- Read Definitions #2 for more info
		if(num <= 1) {
			return 1; // stop recursion, finish the stack
		}
		return num * getFactorial(num - 1); // recursive factorial algorithm
	}
	
	// a recursive algorithm for a mystery number
	public static int recMystery(int num) {
		if(num == 0) {
			return 1;
		}
		return recMystery(num - 1) + (num + 2);
	}

	// a recursive solution to a for loop
	public static void forLoop(int i, int stop) {
		// base case
		if(i == stop) {
			return; // stop recursion, finish the stack
		}
		System.out.print(i + " ");
		forLoop(i + 1, stop); // recursive for loop algorithm
	}
}
