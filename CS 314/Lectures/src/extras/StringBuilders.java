package extras;

public class StringBuilders {

	/* Definitions:
	 * 1. StringBuilder: An Object that handles String operations as most efficiently as possible.
	 * 		- String Concatenation with the appends() method takes O(1) time unlike O(N) with
	 * 			conventional String concatenation using the "+" operator
	 */

	/* Extra Notes:
	 * 1. Since Strings are immutable, they take O(N) time whenever concatenating Strings
	 * 		because new Strings are created and iterated over the internal char[] Array.
	 */

	// test the StringBuilder class
	public static void main(String[] args) {
		// conventional String concatenation
		String firstName = "Pravat";
		String lastName = "Bhusal";
		String fullName = firstName + " " + lastName; // O(N) because new Strings are created

		// StringBuilder concatenation
		StringBuilder nameBuilder = new StringBuilder();
		nameBuilder.append(firstName); // O(1)
		nameBuilder.append(lastName); // O(1)
		fullName = nameBuilder.toString();
	}
}
