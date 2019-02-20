package chapter4;

public class Strings {

	/* Definitions:
	 * 1. String: An object storing a sequence of text characters.
	 * 2. Concatenation: To combine Objects or primitives together.
	 *	- In String concatenation, the first element must be a String (or null)
	 *		or else String concatenation cannot convert the trailing Objects
	 *		to Strings, properly...
	 *	- Therefore, if concatenating primitives, make sure the first element is a String
	 */

	/* Extra Notes
	 * 1. Java Strings are immutable, so their methods cannot change the String itself.
	 * 2. String is not always created with the keyword new, but it can be.
	 * 		EX: String name = "Pravat";
	 * 		EX: String name = new String("Pravat");
	 * 3. Characters of a String are numbered with 0-based indexes
	 * 		EX: In the String "Pravat", P = index 0, r = index 1, a = index 2, etc.
	 * 4. Strings cannot use == when comparing values between Strings because they
	 * 		are Object-types, so you must use the equals or equalsIgnoreCase methods.
	 * 		- The equals() method is actually a method from the standard Object class!
	 * 		- Make sure not to use equals() on null, or the NullPointerException will throw
	 * 5. String variables CANNOT equal to any other data-type
	 * 		EX: String number = 3.5; <- ERROR: DOES NOT WORK
	 * 		EX: String someBoolean = true; <- ERROR: DOES NOT WORK
	 * 6. Even though Strings cannot equal to another data-type; print(), println(), and printf() are overloadable.
	 * 		EX: System.out.println(3.5) <- output: 3.5
	 * 		EX: System.out.println(true) <- output: true
	 * 7. When the program cannot find a String that contains the indexOf(), it returns -1
	 * 8. When any String method using index(es) parameter(s) goes out of bounds, it throws a runtime error.
	 * 		- EX: charAt(8) goes out of bounds if there's only 7 indexes in the String
	 * 		- EX: substring(3, 2) goes out of bounds because you cannot get the substring from 3 to 2
	 * 		- EX: substring(4,9) goes out of bounds if there's only 7 indexes in the String
	 */

	public static void main(String[] args) {
		// declare and initialize a String
		String name = "Pravat";

		// String concatenation (combining) <- Read Definitions #2 for more info
		String nullString = null + " this works!"; // returns: null this works!
		String regularString = "one string and " + " other string."; // returns: one string and another string
		String concatPrimitive1 = "concat a primitive: " + 5; // returns: concat  a primitive: 5
		String concatPrimitive2 = true + " concat a primitive"; // returns: true concat a primitive
		String concatObject = new Object + " concat an Object"; // returns  java.lang.Object@xxxxx concat an Object

		// get the index of the first occurrence of P in the String
		int pIndex = name.indexOf("P"); // 0
		int cIndex = name.indexOf("c"); // -1 <- Read Extra Notes #6 for more info

		// get the index of the last occurrence of a in the String
		int aLastIndex = name.lastIndexOf("a"); // 4

		// get the character at a certain index of a String
		char index3Char = name.charAt(3); // v

		// get the number of characters of the String
		int length = name.length(); // 6

		// replace the first occurrence of a String with the another String
		String replacedString = name.replace("Pra", "Tre"); // Trevat

		// get the String from an index inclusive to another index exclusive
		String substrString = name.substring(1, 4); // rav

		// get the String from an index to the end of the String
		String substrEndString = name.substring(1); // ravat

		// upper-case a String
		String upperCaseString = name.toUpperCase(); // PRAVAT

		// lower-case a String
		String lowerCaseString = name.toLowerCase(); // pravat

		/* check if String equals (case-sensitive) to another String
			<- Read Extra Notes #3 for more info */
		boolean equalsString = name.equals("Pravat"); // true

		// without variables, Strings return true with ==
		boolean trueEqualsEquals = "test" == "test"; // true

		// using a String that calls a method and comparing with == returns false
		boolean falseEqualsEquals = "ok".toUpperCase() == "OK"; // false

		// check if String equals (not case-sensitive) to another String
		boolean equalsIgnoreCaseString = name.equalsIgnoreCase("pravat"); // true

		// check if String starts with a String
		boolean startsWithString = name.startsWith("Pr"); // true

		// check if String ends with a String
		boolean endsWithString = name.endsWith("at"); // true

		// check if String contains a certain String
		boolean containsString = name.contains("vat"); // true
	}
}
