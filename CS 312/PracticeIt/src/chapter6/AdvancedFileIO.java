package chapter6;

import java.io.PrintStream;
import java.util.Scanner;

public class AdvancedFileIO {

	/* Write a method named doubleSpace that accepts a Scanner for an input file 
	 * and a PrintStream for an output file as its parameters, writing into the
	 * output file a double-spaced version of the text in the input file.
	 */
	public static void doubleSpace(Scanner src, PrintStream output) {
	    while(src.hasNextLine()) {
	        String doubleSpacedLine = src.nextLine() + "\n"; // add extra blank line
	        output.println(doubleSpacedLine);
	    }
	}
	
	/* Write a method called stripHtmlTags that accepts a Scanner representing an 
	 * input file containing an HTML web page as its parameter, then reads that 
	 * file and prints the file's text with all HTML tags removed. A tag is any 
	 * text between the characters < and >. You may assume that the file is a 
	 * well-formed HTML document and that there are no < or > characters inside 
	 * tags.
	 */
	public static void stripHtmlTags(Scanner src) {
	    while(src.hasNextLine()) {
	        String line = src.nextLine();
	        String strippedLine = "";
	        boolean insideTag = false; // check if inside a tag
	        
	        // strip any characters inside < or >
	        for(int i = 0; i < line.length(); i++) {
	            // check for opening or closing tag
	            char lineChar = line.charAt(i);
	            if(lineChar == '<') {
	                insideTag = true;
	            } else if(lineChar == '>') {
	                insideTag = false;
	            
	            // only concatenate if loop is not iterating inside a tag
	            } else if(!insideTag) {
	                strippedLine += lineChar;
	            }
	        }
	        System.out.println(strippedLine);
	    }
	}
	
	/* Write a method named printDuplicates that accepts as its parameter a 
	 * Scanner for an input file containing a series of lines. Your method should 
	 * examine each line looking for consecutive occurrences of the same token on 
	 * the same line and print each duplicated token along how many times it 
	 * appears consecutively. Non-repeated tokens are not printed. Repetition 
	 * across multiple lines (such as if a line ends with a given token and the 
	 * next line starts with the same token) is not considered in this problem.
	 */
	public static void printDuplicates(Scanner src) {
	    while(src.hasNextLine()) {
	        String line = src.nextLine();
	        Scanner lineScan = new Scanner(line);
	        String prevToken = "";
	        int numOccurance = 1; // number of times a token occurred
	        
	        while(lineScan.hasNext()) {
	            String token = lineScan.next();
	            
	            // check if adjacent token
	            if(prevToken.equals(token)) {
	                numOccurance++;
	            } else if(numOccurance > 1) {
	                // this token isn't adjacent, but it previously was so print the prevToken
	                System.out.print(prevToken + "*" + numOccurance + " ");
	                numOccurance = 1; // reset
	            }
	            prevToken = token;
	        }
	        
	        // fence-post solution
	        if(numOccurance > 1) {
	            System.out.print(prevToken + "*" + numOccurance);
	        }
	        System.out.println();
	    }
	}
}
