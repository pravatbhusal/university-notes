package extras;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryCatchFinally {

	/* Definitions:
	 * 1. Try: Tries a code block, if an exception is throw within the block it will
	 * 		handle the exception within a catch() block.
	 * 2. Catch: If its respective try statement fails, and the caught exception was the
	 * 		matching exception thrown, it will execute the code within the block.
	 * 3. Finally: Whether the code threw an exception or not, it will run the code in this block.
	 */

	/* Extra Notes:
	 * 1. There can only be one try and finally statement, but there can be multiple catches.
	 * 2. The difference between try, catch, finally and throws within the method header is
	 * 		that try, catch, finally can check specific errors that occur in a code block.
	 * 3. The moment a program throws an exception from a try block, it will not execute the
	 * 		rest of the try block's code, thus not executing any other catch blocks.
	 * 4. If a certain exception can never be thrown from a try block and the program
	 * 		has a catch block that attempts to catch an impossible exception, it will
	 * 		become a syntax error.
	 */

	// test the try, catch, finally control structures
	@SuppressWarnings("null")
	public static void main(String[] args) {
		// an example of a try and catch statement
		try {
			// try and divide by zero
			int divideByZero = 100 / 0;
			System.out.println(divideByZero);
		} catch(ArithmeticException mathError) {
			// an ArithmeticException was thrown by trying the block of code
			System.out.println("Error: Tried to divide a number by zero!");
		}
		System.out.println();

		// an example of multiple try and catch statements
		try {
			// try and divide by zero
			int divideByZero = 100 / 0;
			System.out.println(divideByZero);

			// try and use a String method on a null Object
			String thisIsNull = null;
			boolean isEmpty = thisIsNull.isEmpty();
			System.out.println(isEmpty);
		} catch(ArithmeticException mathError) {
			System.out.println("Tried to divide a number by zero: " + mathError.getMessage());
		} catch(NullPointerException nullError) {
			System.out.println("The String is null! " + nullError.getMessage());
		}
		System.out.println();

		// an example of a try and finally statement
		try {
			System.out.println("Hello World!");
		} finally {
			System.out.println("This will execute whether the program thows an exception or not.");
		}
		System.out.println();

		// an example of a try, catch, and finally statement
		try {
			// FileReader uses a FileNotFoundException
			FileReader openFile = new FileReader("unknownFile.txt");

			// close() uses an IOException
			openFile.close();
		} catch(FileNotFoundException fileError) {
			System.out.println("Could not find the file!");
		} catch (IOException ioError) {
			System.out.println("Could not close the file!");
		} finally {
			System.out.println("This will execute whether the program thows an exception or not.");
		}
	}
}
