package chapter4;

public class MoreStrings {

	/* Write a method called printReverse that accepts a String as its parameter 
	 * and prints the characters in opposite order. If the empty string is passed, 
	 * no output is produced. Your method should produce a complete line of output.
	 */
	public static void printReverse(String text) {
		String reverseText = "";

		// get the characters in text in reverse order
		for(int i = text.length() - 1; i >= 0; i--) {
			reverseText += text.charAt(i);
		}

		System.out.println(reverseText);
	}

	/* Write a method called swapPairs that accepts a String as a parameter and 
	 * returns that String with each pair of adjacent letters reversed. If the 
	 * String has an odd number of letters, the last letter is unchanged.
	 */
	public static String swapPairs(String text) {
		String swappedText = "";

		for(int i = 0; i < text.length(); i += 2) {  
			// check if we're at the last index in order to prevent getting out of bounds
			if(i == text.length() - 1) {
				swappedText += text.charAt(i);
			} else {
				// swap the adjacent characters into the swappedText variable
				swappedText += text.charAt(i + 1);
				swappedText += text.charAt(i);
			}
		}

		return swappedText;
	}

	/* Write a method called wordCount that accepts a String as its parameter and 
	 * returns the number of words in the String. A word is a sequence of one or 
	 * more nonspace characters.
	 */
	public static int wordCount(String text) {
		int wordCount = 0;
		char lastChar = ' '; // initial char value

		for(int i = 0; i < text.length(); i++) {
			if(text.charAt(i) == ' ') {
				// we encountered a space
				lastChar = ' ';
			} else if(lastChar == ' ') {
				/* the last character was a space but the current character
		                at i is not a space, so we just encountered a new word */
				wordCount ++;
				lastChar = text.charAt(i);
			}
		}
		return wordCount;
	}
}
