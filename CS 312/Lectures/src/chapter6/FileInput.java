package chapter6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class FileInput {

	/* Definitions:
	 * 1. PrintStream: Object in java.io that lets you write input to a
	 * 		destination, such as a file.
	 */

	/* Extra Notes:
	 * 1. PrintStream's print and println work the same as System.out
	 * 2. PrintStream creates a file if it has not been created.
	 * 2. PrintStream will completely OVERWRITE the file once created.
	 * 4. Therefore, do not open the same file for both reading (Scanner)
	 * 		and writing (PrintStream) at the same time.
	 */

	public static void main(String[] args) throws FileNotFoundException {
		// utilizing the PrintStream object <- Read Definitions #1 for more info
		PrintStream output = new PrintStream(new File("FileInput.txt"));
		output.println("Hello, file!");
		output.println("This is a second line of output.");
		output.print("This is on the same line.");
		output.print("This is on the same line.");
	}
}
