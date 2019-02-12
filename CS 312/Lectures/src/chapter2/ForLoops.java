package chapter2;

public class ForLoops {

	/* Definitions:
	 * 1. For Loop: A control structure that repeats code.
	 */

	/* Extra Notes
	 * 1. The less than operator is <
	 * 2. The less than equal to operator is <=
	 * 3. The greater than operator is >
	 * 4. The greater than equal to operator is >=
	 * 5. The equal to operator is ==
	 * 6. The does not equal to operator is !=
	 * 7. When continuing a method with a String parameter on a new line (such as println or print),
	 * 		you must concatenate it using the + operator.
	 * 8. It's good to create a loop table to see how for loops work as a mathematical function.
	 */

	/* Methodology of For Loops
	 * 1. Perform the initialization once (first statement)
	 * 2. Repeat the following:
	 * 		- Check if the test is true (second statement)
	 * 		- Execute the statements inside the for loop
	 * 		- Perform the update (third statement)
	 */

	public static void main(String[] args) {
		// post-uniary operators (returns then updates)
		int x = 0;
		x++; // x is now 1 because it increments by 1, but returns 0
		x--; // x is now back to 0 because it decrements by 1, but returns 1

		// pre-uniary operators (updates then returns)
		int y = 0;
		++y; // y is now 1, and returns 1 too
		--y; // y is now back to 0, and returns 0 too

		// print() statements (outputs String, but doesn't create a new line at the end)
		System.out.print("This is outputted without creating a new line at the end.");
		System.out.println("Yep, we're still on the same line. "
				+ "However, this println() statement will create a new line."); // <- Read Extra Note #7 for more details

		System.out.println();

		/* a for loop that executes as long as i is less than 5,
			so it executes 5 times when i = 0 to i = 4 */
		for(int i = 0; i < 5; i++) {
			System.out.println("The value of i is: " + i);
		}

		System.out.println();

		// another example of a for loop that executes 5 times, when i = 1 to i = 5
		for(int i = 1; i <= 5; i++) {
			System.out.println("The value of i is: " + i);
		}

		System.out.println();

		// a decremented for loop, when i = 5 to i = 1
		for(int i = 5; i > 0; i--) {
			System.out.println("The value of i is: " + i);
		}

		System.out.println();

		// a for loop with multiple statements
		for(int i = 0, j = 0; i < 5 && j < 5; i++, j++) {
			System.out.println("Value of i is " + i + " and value of j is " + j);
		}

		System.out.println();

		// a nested for loop can have an infinite number of nests
		for(int i = 0; i < 4; i++) { // 4 loops, from i = 0 to i = 3
			for(int j = 0; j < 2; j++) { // 2 loops, from j = 0 to j = 1
				for(int k = 0; k < 1; k++) { // 1 loop, from k = 0
					System.out.print("*"); // 4 * 2 * 1 = 8 asterisks
				}
			}
			for(int j = 0; j < 2; j++) { // 2 loops
				System.out.print("*"); // 4 * 2 = 8 asterisks
			}
		} // total number of asterisks = 8 + 8 = 16

		System.out.println();

		// ASCII art with nested for loops
		for(int i = 1; i <= 5; i++) { // 5 loops, from i = 1 to i = 5
			for(int j = 1; j <= 5 - i; j++) { // dependent on value of i
				System.out.print(".");
			}
			System.out.println(i);
		}
	}
}
