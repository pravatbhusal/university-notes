package chapter6;

import java.util.Scanner;

/* Write a method named evenNumbers that accepts a Scanner as a parameter 
 * reading input from a file containing a series of integers, and report 
 * various statistics about the integers. You may assume that there is at 
 * least one integer in the file. Report the total number of numbers, the sum 
 * of the numbers, the count of even numbers and the percent of even numbers.
 */
public class EvenNumbers {

	public static void evenNumbers(Scanner src) {
		int numCount = 0;
		int sum = 0;
		int numEvens = 0;

		while(src.hasNextInt()) {
			numCount++;
			int currentInt = src.nextInt();
			sum += currentInt;

			// check if currentInt is even
			if(currentInt % 2 == 0) {
				numEvens++;
			}
		}

		System.out.println(numCount + " numbers, sum = " + sum);

		// output the even fraction and percentage
		double evenFraction = ((double)numEvens / numCount) * 100;
		System.out.printf("%d evens (%.2f%s)", numEvens, evenFraction, "%");

	}
}
