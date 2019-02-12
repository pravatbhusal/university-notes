package chapter6;

// import Scanner and File class
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileOutput {

	/* Definitions:
	 * 1. Absolute Path: Specifies a drive or a top "/" folder
	 * 		EX: C:/Documents/bhusal/hw6/input/data.csv
	 * 2. Relative Path: Does not specify any top-level folder
	 * 		EX: names.dat
	 * 		EX: input/kinglear.txt
	 * 3. Exception: An object representing a runtime error
	 * 4. NoSuchElementException: Read past the end of the input
	 * 5. InputMismatchException: Read the wrong type of token
	 * 		EX: "hi" as an int
	 * 6. Unchecked Exception: Logic errors that can be resolved
	 * 7. Checked Exception: Errors that must be handled by program
	 * 		and possibly outside the client program's reach.
	 * 8. throws Clause: Keyword on method's header stating it may
	 * 		generate an exception (and will not handle it)
	 * 9. Token: A unit of user input, separated by white space
	 * 10. Consuming Input: Reading input and advancing the cursor
	 * 11. hasNext(): returns true if there is a next token
	 * 12. hasNextInt(): returns true if there is a next token
	 * 		and can be read as an int
	 * 13. hasNextDouble(): returns true if there is a next token
	 * 		and can be read as a double
	 * 14. hasNextLine(): returns true if there are any more lines to read.
	 * 		(always true for console input)
	 * 15. next(): consumes and returns the next token
	 * 16. nextInt(): consumes and returns the next token as an integer, or else error
	 * 17. nextDouble(): consumes and returns the next token as a double, or else error
	 * 18. nextLine(): consumes and returns the entire line
	 * 19. String Scanners: Can "tokenize" each token of the String.
	 */

	// do file input program and throw an error if a file was not found
	public static void main(String[] args) throws FileNotFoundException {
		// get the absolute path that the program is in
		String absolutePath = System.getProperty("user.dir");

		// create new File object
		File file = new File("FileOutput.txt");

		// returns whether file is able to be read
		boolean canReadFile = file.canRead();

		// deletes file from disk, returns if successfully deleted
		boolean deletedFile = file.delete();

		// returns if file exists
		boolean fileExists = file.exists();

		// returns the file's name
		String fileName = file.getName();

		// returns the number (double) of bytes in file
		double fileByteLength = file.length();

		// get file "FileOutput.txt" in root (current) directory
		Scanner src = new Scanner(new File("FileOutput.txt"));

		// iterate through the entire file for any type of token
		while(src.hasNext()) {
			// check if next token is a double
			if(src.hasNextDouble()) {
				// set to the next double
				double numToken = src.nextDouble();
				System.out.print(numToken + " ");
			} else {
				src.next(); // throw away unwanted token
			}
		}

		// line-based Scanner output
		src = new Scanner(new File("FileOutput.txt"));
		while(src.hasNextLine()) {
			String line = src.nextLine(); // any \n is consumed, but NOT returned
			System.out.println(line); // use println to create new line, instead
		}
		System.out.println();

		// mixing lines and tokens with multiple Scanners
		src = new Scanner(new File("FileOutput.txt")); // reset Scanner
		while(src.hasNext()) {
			String line = src.nextLine();
			Scanner lineScan = new Scanner(line); // <- Read Definitions #19 for more info

			// process contents of this line
			while(lineScan.hasNext()) {
				String word = lineScan.next();
				System.out.print(word + " ");
			}
			System.out.println();
		}
	}
}
