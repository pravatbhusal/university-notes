package chapter4;

import java.util.Scanner;

public class StringPractice {

	public static void main(String[] args) {
		padString("Hello", 10); // ___Hello <- The underscores are spaces
		vertical("Yes"); // each character is produced on a new line
		longestName(new Scanner(System.in), 5);
	}
	
	// pad a String with spaces until its length is the given length
	public static String padString(String text, int length) {
		String paddedString = "";

		// iterate for number of spaces needed to be added
		for(int i = 0; i < length - text.length(); i++) {
			paddedString += " ";
		}
		paddedString += text; // add the text

		return paddedString;
	}

	/* Write a method called vertical that accepts a String as its parameter and 
	 * prints each letter of the string on separate lines.
	 */
	public static void vertical(String text) {
		for(int i = 0; i < text.length(); i++) {
			// get each character of the String
			String character = text.substring(i,i+1);
			System.out.println(character);
		}
	}

	// get the longest name based on values given by the user
	public static void longestName(Scanner src, int n) {
		String longestName = "";
		String tiePhrase = "";

		for(int i = 1; i <= n; i++) {
			System.out.print("name #" + i + "? ");
			String name = src.nextLine();

			// check if the name inputted is longer than the current longest name
			if(name.length() > longestName.length()) {
				longestName = name;
				tiePhrase = "";
			} else if(name.length() == longestName.length()) {
				tiePhrase = "(There was a tie!)";
			}
		}

		longestName = longestName.toLowerCase(); // lower-case all characters
		String firstLetter = longestName.substring(0, 1).toUpperCase(); // upper-case first letter of name
		longestName = firstLetter + longestName.substring(1, longestName.length()); // capitalize the name

		System.out.println(longestName + "'s " + "name is longest");
		System.out.println(tiePhrase);
	}
}
