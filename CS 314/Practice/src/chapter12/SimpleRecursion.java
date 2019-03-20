package chapter12;

public class SimpleRecursion {

	/* Write a method starString that accepts an integer parameter n and returns a 
	 * string of stars (asterisks) 2n long. You should throw an 
	 * IllegalArgumentException if passed a value less than 0.
	 */
	public static String starString(int starRate) {
		if(starRate < 0) {
			throw new IllegalArgumentException("The parameter starRate cannot be less than 0!");
		}
		if(starRate == 0) {
			// base case, the program should return a single star
			return "*";
		}
		// append the this star Strings to the next recursive call's star Strings
		String totalStars = "";
		String recursiveStars = starString(starRate - 1);
		for(int star = 0; star < recursiveStars.length(); star++) {
			/* create a String double the time of recurisve Stars since
	            the program receives the square number of stars */
			totalStars += "*";
		}
		totalStars += recursiveStars;
		return totalStars;
	}


	/* Write a method writeNums that accepts an integer parameter n and prints the 
	 * first n integers starting with 1 in sequential order, separated by commas. 
	 * Your method should throw an IllegalArgumentException if passed a value less 
	 * than 1. Note that the output does not advance to the next line.
	 */
	public static void writeNums(int numbers) {
		if(numbers < 1) {
			throw new IllegalArgumentException("The numbers cannot be less than 1!");
		}
		helperWriteNums(numbers, 1);
	}

	// a helper method for the write numbers method
	private static void helperWriteNums(int numbers, int currentNumber) {
		if(currentNumber == numbers) {
			// base case, print the number without a trailing comma
			System.out.print(currentNumber);
		} else {
			// print this number, then go to the next number in the recursive call
			System.out.print(currentNumber + ", ");
			helperWriteNums(numbers, currentNumber + 1);
		}
	}

	/* Write a method writeSequence that accepts an integer n as a parameter and 
	 * prints a symmetric sequence of n numbers with descending integers ending in 
	 * 1 followed by ascending integers beginning with 1. Notice that for odd 
	 * numbers the sequence has a single 1 in the middle while for even values it 
	 * has two 1s in the middle.
	 */
	public static void writeSequence(int number) {
		if(number < 1) {
			throw new IllegalArgumentException("The number cannot be less than 1!");
		}
		// grab the number as its half, then call the helper method
		final double HALF = 2;
		int currentNumber = (int) Math.ceil(number / HALF);
		helperWriteSequence(number, currentNumber);
	}

	// a helper method for the write sequence method
	private static void helperWriteSequence(int number, int currentNumber) {
		if(currentNumber == 1 && number % 2 == 0) {
			// base case for even number, print the number twice and begin the popping of the stack
			System.out.print(currentNumber + " ");
			System.out.print(currentNumber + " ");
		} else if(currentNumber == 1) {
			// base case for odd number, print the number once and begin the popping of the stack
			System.out.print(currentNumber + " ");
		} else {
			// call the next recursive call and push stacks
			System.out.print(currentNumber + " ");
			helperWriteSequence(number, currentNumber - 1);

			// recursive call done, program is popping the stack so output the current number again
			System.out.print(currentNumber + " ");
		}
	}

	/* Write a method writeSquares that accepts an integer parameter n and prints 
	 * the first n squares separated by commas, with the odd squares in descending 
	 * order followed by the even squares in ascending order. Your method should 
	 * throw an IllegalArgumentException if passed a value less than 1. Note that 
	 * the output does not advance onto the next line.
	 */
	public static void writeSquares(int number) {
		if(number < 1) {
			throw new IllegalArgumentException("The number cannot be less than 1");
		}
		// print the odds, then print the evens
		helperWriteSquaresOdd(number);
		if(number != 1) {
			// only print the evens if the number is not 1
			helperWriteSquaresEven(number, 1);
		}
	}

	// a helper method to write squares in odd and ascending order
	private static void helperWriteSquaresOdd(int currentExponent) {
		int currentNumber = currentExponent * currentExponent;
		if(currentNumber == 1) {
			// base case, stop the sequence
			System.out.print(currentNumber);
		} else {
			// get the next odd square
			final int EVEN_ODD_RATIO = 2;
			while(currentNumber % EVEN_ODD_RATIO == 0 && currentExponent != 1) {
				currentExponent--;
				currentNumber = currentExponent * currentExponent;
			}
			if(currentExponent != 1) {
				// current exponent is not 1, so print it out and go to the next step
				System.out.print(currentNumber + ", ");
				helperWriteSquaresOdd(currentExponent - 1);
			} else {
				// current exponent is 1, so it'll handle base-case
				helperWriteSquaresOdd(currentExponent);
			}
		}
	}

	// a helper method to write squares in even and descending order
	private static void helperWriteSquaresEven(int number, int currentExponent) {
		final int EVEN_ODD_RATIO = 2;
		int currentNumber = currentExponent * currentExponent;
		if(currentExponent == number) {
			// base case, stop the sequence
			if(currentNumber % EVEN_ODD_RATIO == 0) {
				// print if the number is even
				System.out.print(currentNumber);
			}
		} else {
			/* print a comma for the previous call (since commas a trailing comma may
	            be added if the last number is odd, and we don't want that) */
			System.out.print(", ");

			// get the next even square
			while(currentNumber % EVEN_ODD_RATIO == 1 && currentExponent != number) {
				currentExponent++;
				currentNumber = currentExponent * currentExponent;
			}
			if(currentExponent != number) {
				// current exponent is not number, so print it out and go to the next step
				System.out.print(currentNumber);
				helperWriteSquaresEven(number, currentExponent + 1);
			} else {
				// current exponent is number, so it'll handle base-case
				helperWriteSquaresEven(number, currentExponent);
			}
		}
	}
}
