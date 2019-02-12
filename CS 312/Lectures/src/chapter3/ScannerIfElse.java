package chapter3;

import java.util.Scanner; // import the Scanner class

public class ScannerIfElse {

	/* Definitions:
	 * 1. Interactive program: Reads input from the console.
	 * 2. Scanner: An object than can read input from many sources.
	 * 3. System.in: Reads inputs onto the console.
	 * 4. Prompt: A message telling the user what to input.
	 * 5. Token: A unit of user input separated by whitespace.
	 * 6. Boolean: True or False.
	 * 7. If Statement: A control structure that executes a block of statement only if a test is true.
	 * 8. Else If Statement: A control structure that executes a block of statement only if the if or above else if is false.
	 * 9. Else Statement: A control structure that executes a block of statement only if the if or all else if is false.
	 */

	/* Extra Notes
	 * 1. The user does not need to utilize escape sequences with Scanner's nextLine() or next()
	 * 2. Use a print and NOT a println method for prompts, or else the user will have to type in a new line
	 * 3. After the user types an input, the user typically presses enter which creates a new line.
	 */

	/* Scanner Methods
	 * 1. nextInt(): Allows for user to input an integer, returning the first token
	 * 2. nextDouble(): Allows for user to input a double, returning the first token
	 * 3. nextLine(): Allows for user to input a String, returning the line
	 * 4. next(): Allows for user to input a String, returning the first token
	 */

	public static void main(String[] args) {
		// create a new Scanner object
		Scanner src = new Scanner(System.in);

		// prompt the user to type his age (use print method, not println <- Read Extra Notes #2,3 for more info)
		System.out.print("How old are you? Only integers!");
		int age = src.nextInt();
		System.out.println("You typed: " + age);

		// prompt the user to two numbers on the same line
		System.out.print("Type two numbers on the same line separated by a space.");
		double num1 = src.nextDouble();
		double num2 = src.nextDouble();
		System.out.println("The sum is " + (num1 + num2));

		// skipping extraneous tokens using nextLine
		System.out.print("Type a number with an extraneous input token...");
		double extraNum = src.nextDouble(); // gets first token
		src.nextLine(); // skips any extraneous tokens after extraNum
		System.out.print("Now type a String...");
		String text = src.nextLine();
		System.out.println("Number was: " + extraNum + " and String was " + text);

		// escape sequences with Scanners <- Read Extra Notes #1 for more info
		System.out.print("Type String needing escape sequences without using escape sequences.");
		String escapeSequences = src.nextLine();
		System.out.println(escapeSequences);

		// if, else if, else statements <- Read Definitions #6,7,8 for more info
		double randNum = Math.random();
		if(randNum > 0.5) { // if randNum is greater than 0.5
			System.out.println("The random number is greater than 0.5! It was " + randNum);
		} else if(randNum < 0.5) { // if randNum is less than 0.5
			System.out.println("The random number is less than 0.5! It was " + randNum);
		} else { // nothing else is true, so randNum must equal to 0.5
			System.out.println("The random number is neither greater or less than 0.5, so logically it is 0.5!");
		}

		// multiple boolean operations, also you can have infinite operations
		double sqrtNum = Math.sqrt(67);
		if(sqrtNum > 8 && sqrtNum < 10) { // if sqrtNum is greater than 8 AND less than 10
			System.out.println("The number is greater than 8 AND less than 10.");
		} else if(sqrtNum > 10 || sqrtNum < 12) { // if sqrtNum is greater than 10 OR less than 12
			System.out.println("The number is greater than 10 OR less than 12.");
		}
	}
}
