package chapter7;

public class TextProcessing {

	/* Write a method called percentEven that accepts an array of integers as a 
	 * parameter and returns the percentage of even numbers in the array as a real 
	 * number.  If the array contains no even elements or no elements at all, 
	 * return 0.0.
	 */
	public static double percentEven(int[] args) {
		int total = args.length;
		int numEvens = 0;

		for(int i = 0; i < total; i++) {
			// check if the element is even
			if(args[i] % 2 == 0) {
				numEvens++;
			}
		}

		// check if evens was 0 (avoid NaN)
		if(numEvens == 0) {
			return 0.0;
		}
		return ((double) numEvens / total) * 100;
	}

	/* Write a method named isUnique that takes an array of integers as a 
	 * parameter and that returns a boolean value indicating whether or not the 
	 * values in the array are unique (true for yes, false for no). The values in 
	 * the list are considered unique if there is no pair of values that are 
	 * equal. Notice that given this definition, a list of 0 or 1 elements would 
	 * be considered unique.
	 */
	public static boolean isUnique(int[] args) {
		boolean isUnique = true;

		// list of 0 or 1 elements is unique
		if(args.length == 0 || args.length == 1) {
			return true;
		}

		for(int i = 0; i < args.length; i++) {
			// iterate every element once again to check with args[i]
			for(int j = 0; j < args.length; j++) {
				// found an element that is not the same index and are the same value
				if(i != j && args[i] == args[j]) {
					isUnique = false;
				}
			}
		}

		return isUnique;
	}

	/* Write a method named longestSortedSequence that accepts an array of 
	 * integers as a parameter and that returns the length of the longest sorted 
	 * (nondecreasing) sequence of integers in the array. Notice that sorted means
	 * nondecreasing, which means that the sequence could contain duplicates. Your 
	 * method should return 0 if passed an empty array.
	 */
	public static int longestSortedSequence(int[] args) {
		int longestLength = 1;

		// exception for 0 length
		if(args.length == 0) {
			return 0;
		}

		for(int i = 0; i < args.length; i++) {
			int length = 1;
			boolean continousSequence = true;
			int prevNum = args[i];

			// check sequence starting after args[i]
			for(int j = i + 1; j < args.length; j++) {
				if(prevNum <= args[j] && continousSequence) {
					length++;
				} else {
					continousSequence = false;
				}
				prevNum = args[j];
			}

			// update the longest length
			if(length > longestLength) {
				longestLength = length;
			}
		}
		return longestLength;
	}
}
