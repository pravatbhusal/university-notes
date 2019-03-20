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
			/* base case where we exhausted the length of number, so print the
	            current number that contains all the concatenated 0s and 1s */
			System.out.println(currentNumber);
		} else {
			// create cases for when the next binary is 0 or 1
			helperCountBinary(number - 1, currentNumber + "0");
			helperCountBinary(number - 1, currentNumber + "1");
		}
	}
}
