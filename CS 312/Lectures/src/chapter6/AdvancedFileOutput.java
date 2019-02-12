package chapter6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdvancedFileOutput {

	/* Extra Notes:
	 * 1. Using next(), nextInt(), or nextDouble() and nextLine() simultaneously makes
	 * 		nextLine() returns the rest of the line starting from the last consumed token.
	 * 2. Calling nextLine() after all tokens have been read in the line will consume and return \n.
	 * 		Therefore, use nextLine() again to get the actual next line.
	 */

	public static void main(String[] args) throws FileNotFoundException {
		Scanner src = new Scanner(new File("AdvancedFileOutput.txt"));

		// mixing tokens and lines p1 <- Read Extra Notes #1 for more info
		int total = src.nextInt();
		total += src.nextInt();
		System.out.println(total + " " + src.nextLine()); // output: 12 24 hello

		// mixing tokens and lines p2 <- Read Extra Notes #2 for more info
		src = new Scanner(new File("AdvancedFileOutput.txt")); // reset Scanner
		System.out.println(src.nextInt() + " " + src.nextInt() + " " + src.next()); // output: 12 24 hello
		System.out.print(src.nextLine()); // output: \n

		// mixing tokens and lines p3 <- Read Extra Notes #2 for more info
		src = new Scanner(new File("AdvancedFileOutput.txt")); // reset Scanner
		System.out.println(src.nextInt() + " " + src.nextInt() + " " + src.next()); // outputs: 12 24 hello
		src.nextLine(); // consume the \n token
		System.out.println(src.nextLine()); // outputs: dsfhsdfjsd fsnfidsf fsdnif ui fisdffhiu
	}
}
