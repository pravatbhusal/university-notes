package chapter6;

import java.util.Scanner;

/* Write a method named negativeSum that accepts a Scanner as a parameter 
 * reading input from a file containing a series of integers, and determine 
 * whether the sum starting from the first number is ever negative. The method 
 * should print a message indicating whether a negative sum is possible and 
 * should return true if a negative sum can be reached and false if not.
 */
public class NegativeSum {

	public static boolean negativeSum(Scanner src) {
		int sum = 0;
		int steps = 0;

		while(src.hasNextInt()) {
			steps++;
			int currentInt = src.nextInt();
			sum += currentInt;

			// check if sum is negative
			if(sum < 0) {
				System.out.println(sum + " after " + steps + " steps");
				return true;
			}
		}

		// all else failed, there was no negative sum
		System.out.println("no negative sum");
		return false;
	}
}
