package chapter6;

import java.util.Scanner;

public class FileInputLines {

	/* Write a method named readEntireFile that accepts a Scanner representing an 
	 * input file as its parameter, then reads that file and returns the entire 
	 * text contents of that file as a String.
	 */
	public static String readEntireFile(Scanner src) {
		String fileContent = "";

		// read through the next token
		while(src.hasNext()) {
			fileContent += src.nextLine() + "\n"; // concatenate each line
		}

		return fileContent;
	}

	/* Write a method called wordWrap that accepts a Scanner representing an input 
	 * file as its parameter and outputs each line of the file to the console, 
	 * word-wrapping all lines that are longer than 60 characters.
	 */
	public static void wordWrap(Scanner src) {
		String fileContent = "";

		// read through the next token
		while(src.hasNext()) {
			String getLine = src.nextLine();

			// number of lines is based on if the scanner line is greater than 60 chars
			int numLines = (getLine.length() / 60) + 1;

			// if length is a multiple of 60, subtract one from numLines
			boolean multipleOfSixty = getLine.length() % 60 == 0;
			if(multipleOfSixty) {
				numLines--;
			}

			if(numLines > 1) {
				int extraChars = getLine.length() % 60;
				String newLines = "";

				// wrap lines to 60 characters each
				for(int i = 0; i < numLines; i++) {
					if(i != numLines - 1) {
						// at a line with more than 60 chars
						final int LINE_INDEXES = (i * 60) + 60;
						for(int j = i * 60; j < LINE_INDEXES; j++) {
							newLines += getLine.charAt(j);
						}
						newLines += "\n";
					} else {
						// at last line, add only number of extraChars
						final int LAST_LINE_INDEXES = (i * 60) + extraChars;
						for(int j = i * 60; j < LAST_LINE_INDEXES; j++) {
							newLines += getLine.charAt(j);
						}
						newLines += "\n";
					}
				}
				fileContent += newLines; // concatenate the lines
			} else {
				fileContent += getLine + "\n"; // concatenate each line
			}
		}
		System.out.println(fileContent);
	}
}
