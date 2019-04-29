package extras;

public class Asserts {

	/* Definitions:
	 * 1. Assert: Used to verify an assumption made in the program. It uses
	 * 		boolean expressions and can be written in two different ways.
	 * 		- assert 'expression'
	 * 		- assert 'expression 1' : 'expression 2'
	 */

	/* Extra Notes:
	 * 1. Asserts should ONLY be used for debugging purposes, and not in production code.
	 * 2. By default, assertions are disabled. In order to enable assertions, type in Terminal:
	 * 		- 'java -ea FILE_NAME'
	 * 3. To disable assertions, type in Terminal:
	 * 		- 'java -da FILE_NAME'
	 */

	// test assertions, must enable assert <- Look at Extra Notes #2 for more information
	public static void main(String[] args) {
		int value = 15;

		// Exception in thread "main" java.lang.AssertionError: value is not greater than 20
		assert value >= 20 : " value is not greater than 20";
	}
}
