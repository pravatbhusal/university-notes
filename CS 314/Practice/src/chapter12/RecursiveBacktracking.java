package chapter12;

public class RecursiveBacktracking {

	/* Write a method countBinary that accepts an integer n as a parameter and 
	 * that prints all binary numbers that have n digits in ascending order, 
	 * printing each value on a separate line. All n digits should be shown for 
	 * all numbers, including leading zeros if necessary. You may assume that n is 
	 * non-negative. If n is 0, a blank line of output should be produced.
	 */
	public static void countBinary(int number) {
		String currentNumber = "";
		helperCountBinary(number, currentNumber);
	}

	// a helper method for count binary
	private static void helperCountBinary(int number, String currentNumber) {
		if(number == 0) {
			/* base case where we exhausted the length of number for this recursive combination,
				so print the current number that contains all the concatenated 0s and 1s */
			System.out.println(currentNumber);
		} else {
			// do every binary combination of either 0 or 1, becoming O(N^2)
			helperCountBinary(number - 1, currentNumber + "0");
			helperCountBinary(number - 1, currentNumber + "1");
		}
	}

	public static void waysToClimb(int stairs) {
		helperWaysToClimb(stairs, 0, "[");
	}

	// a helper method for the ways to climb method
	private static void helperWaysToClimb(int stairs, int stepsSum, String steps) {
		if(stepsSum == stairs && stairs != 0) {
			// base-case for this recursive call combination, print the steps Stack without trailing comma
			final int TRAILING_COMMA_LENGTH = 2;
			steps = steps.substring(0, steps.length() - TRAILING_COMMA_LENGTH);
			System.out.println(steps + "]");
		} else if(stepsSum < stairs) {
			// test out every stairs combination of either 1 or 2, becoming O(N^2)
			helperWaysToClimb(stairs, stepsSum + 1, steps + "1, ");
			helperWaysToClimb(stairs, stepsSum + 2, steps + "2, ");
		}
	}
}
