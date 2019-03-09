package chapter12;

public class RecursiveEvaluation {

	/* Definitions:
	 * 1. Recursive Evaluation: Evaluating recursion by writing out the
	 * 		stack calls and substituting their return values as you
	 * 		write each stack call out.
	 */

	// a method that uses single recursion, O(N)
	public static int mystery(int n) {
		if(n == 0) {
			return 1;
		}
		return 3 * mystery(n - 1);
	}

	// a method that uses double recursion, O(1.65^N) <- I don't know why it's this complexity
	public static int bar(int n) {
		if(n <= 0) {
			return 2;
		}
		return 3 + bar(n - 1) + bar(n - 2);
	}


	// a method to show the evaluation of recursive algorithms
	public static void main(String[] args) {
		mystery(3); // 27
		/* Recursive Evaluation:
		 * m(3) = 3 * m(2) = 3 * 9 = 27
		 * m(2) = 3 * m(1) = 3 * 3 = 9
		 * m(1) = 3 * m(0) = 3 * 1 = 3
		 * m(0) = 1
		 */

		bar(4); // 37
		/* Recursive Evaluation:
		 * b(4) = 3 + b(3) + b(2) = 3 + 22 + 12 = 37
		 * b(3) = 3 + b(2) + b(1) = 3 + 12 + 7 = 22
		 * b(2) = 3 + b(1) + b(0) = 3 + 7 + 2 = 12
		 * b(1) = 3 + b(0) + b(-1) = 3 + 2 + 2 = 7
		 * b(0) = 2
		 * b(-1) = 2
		 */
	}
}
