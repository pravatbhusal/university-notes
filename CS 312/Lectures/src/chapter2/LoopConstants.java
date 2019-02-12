package chapter2;

public class LoopConstants {

	/* Definitions:
	 * 1. Scope: Part of a program where a variable exists.
	 * 2. Class Constant: A fixed variable available to the whole class.
	 * 3. Final: The Java term for a constant.
	 */

	/* Program Hygiene Tips
	 * 1. Use final constants with for loop test cases to reduce runtime with math calculations.
	 * 2. Keep your variables at the smallest scope possible.
	 * 3. Final constants are all upper-case and use underscores to separate words.
	 */

	// example class constant variables
	public static final int DAYS_IN_WEEK = 7;
	public static final double INTEREST_RATE = 0.5; 

	public static void main(String[] args) {
		System.out.println(DAYS_IN_WEEK); // output: 7 <- because DAYS_IN_WEEK variable is available in the class scope

		// an example of good loop hygiene <- Read Program Hygiene Tips #1,2,3 for more info
		final int NUM_LOOPS = 3 * 2 + 5; // 11
		for(int i = 0; i < NUM_LOOPS; i++) {
			System.out.print(i + " ");
		}
	}
}
