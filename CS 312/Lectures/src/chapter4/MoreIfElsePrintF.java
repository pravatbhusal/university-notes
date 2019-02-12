package chapter4;

public class MoreIfElsePrintF {

	/* Definitions:
	 * 1. printf: A method to output a formatted String without concatenation.
	 * 2. Ternary Operator: An operator that takes three arguments and returns value.
	 * 		- Format: (boolean) ? (true statement) : (false statement);
	 */

	/* Extra Notes
	 * 1. printf does not insert a new line unless you add \n
	 * 2. %d is a placeholder for integers
	 * 3. %f is a placeholder for floating point numbers (real numbers)
	 * 4. %s is a placeholder for Strings
	 * 5. %Wd is a placeholder for integers of W characters wide right-aligned
	 * 6. %-Wd is a placeholder for integers of W characters wide left-aligned
	 * 7. %Wf is a placeholder for real numbers of W characters wide right-aligned
	 * 8. %.Df is a placeholder for real numbers rounded to D digits after decimal
	 * 9. %W.Df is a placeholder for real of W characters wide right-aligned and D digits after decimal
	 * 10. %-W.Df is a placeholder for real numbers of W characters wide left-aligned and D digits after decimal
	 */

	public static void main(String[] args) {
		max(3,2); // returns 3

		// printf (print format) statements
		System.out.printf("x is %d and y is %d!\n", 3, -17); // output: x is 3 and y is -17!
		System.out.printf("I hope I get a %f\n", 4.0); // output: I hope I get a 4.000000
		System.out.printf("My name is %s\n", "Pravat"); // output: My name is Pravat

		// printf statements with width (spaces are represented as underscores for the output comments)
		System.out.printf("%4d\n", 5); // output: ___5 <- 3 spaces and one char for the int, which equals 4 characters
		System.out.printf("%-4d\n", 5); // output: 5___ <- 3 spaces and one char for the int, which equals 4 characters

		// printf statements with precision
		final double GPA = 3.256764;
		System.out.printf("%.1f\n", GPA); // output: 3.3
		System.out.printf("%8.3f\n", GPA); // output: ___3.257 <- 3 spaces and 5 chars for the number, which equals 8 characters
		System.out.printf("%.8f\n", GPA); // output: 3.25676400 <- two extra zeroes, since it needs to output 8 digits after decimal

		// ternary operator <- Read Definitions #2 for more info
		boolean isTrue = true;
		int valueX = isTrue ? 5 : 3; // 5
	}

	// get the greater number between two integers
	public static int max(int a, int b) {
		/* A method that isn't void MUST return a value, so when the if, else if statements
			don't return a value it causes an error. Therefore, the program either must have
			an else statement that returns a value, or the program should return a value at
			the end of the method. */
		if(a > b) {
			return a;
		} else if(a < b) {
			return b;
		} else { // required for returning a value
			return a;
		}
	}
}
