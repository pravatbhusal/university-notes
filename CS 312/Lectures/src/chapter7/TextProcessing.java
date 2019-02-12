package chapter7;

public class TextProcessing {

	/* Definitions:
	 * 1. char: A primitive type representing single characters
	 * 2. ASCII: Character encoding standard for electronic communication
	 * 		- Utilizes integers as values for characters
	 */

	/* Extra Notes:
	 * 1. Strings are an Array of chars.
	 * 2. It is legal to have escape sequences as chars.
	 * 3. charAt cannot have negative or out-of-bound indexes
	 * 4. Characters use the == or != operators to compare values.
	 * 5. Characters follow an ASCII value, which are integers.
	 * 		- Therefore, characters of upper or lower-case are different
	 * 6. Characters are NOT Strings, so it cannot utilize String methods.
	 */

	public static void main(String[] args) {
		// escape sequences as chars <- Read Extra Notes #2 for more info
		char doubleBackSlash = '\\';

		// charAt method for Strings
		String text = "Hello World";
		char firstLetter = text.charAt(0); // returns: 'H'
		// char outOfBoundIndex = text.charAt(99); // Runtime Exception
		// char negativeIndex = text.charAt(-1); // Runtime Exception

		// traversing each character of a String
		for(int i = 0; i < text.length(); i++) {
			System.out.println(text.charAt(i));
		}

		// comparing characters <- Read Extra Notes #4 for more info
		boolean sameChar = 'a' == 'a'; // true
		boolean notSameChar = 'a' == 'A'; // false

		// representing chars as ASCII values <- Read Extra Notes #5 for more info
		int aChar = 'a' - 5; // 'a' = 97, so 97 - 5 = 92
		System.out.println(aChar); // output: 92
	}
}