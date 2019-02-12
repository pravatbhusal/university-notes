package chapter7;

public class ArrayAlgorithms {

	/* Write a static method named contains that accepts two arrays of integers a1 
	 * and a2 as parameters and that returns a boolean value indicating whether or 
	 * not a2's sequence of elements appears in a1 (true for yes, false for no). 
	 * The sequence of elements in a2 may appear anywhere in a1 but must appear 
	 * consecutively and in the same order. You may assume that both arrays passed 
	 * to your method will have lengths of at least 1. You may not use any Strings 
	 * to help you solve this problem, nor methods that produce Strings such as 
	 * Arrays.toString.
	 */
	public static boolean contains(int[] a1, int[] a2) {
		int occurrences = 0;
		int targetLength = a2.length;
		for(int i = 0; i < a1.length; i++) {
			// check if a number occurred in both Arrays
			if(a1[i] == a2[occurrences]) {
				occurrences++;
				if(occurrences == targetLength) {
					return true;
				}
			} else {
				occurrences = 0;
				/* check if a number occurred in both Arrays, again.
	                This prevents us from accidently skipping a check where
	                the occurrence becomes 0 at an index that begins the sequence. */
				if(a1[i] == a2[occurrences]) {
					occurrences++;
					if(occurrences == targetLength) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/* Write a method called collapse that accepts an array of integers as a 
	 * parameter and returns a new array containing the result of replacing each 
	 * pair of integers with the sum of that pair. If the list stores an odd number
	 * of elements, the final element is not collapsed. Your method should not 
	 * change the array that is passed as a parameter.
	 */
	public static int[] collapse(int[] args) {
		int[] collapsedArgs = new int[0];
		int argsLength = args.length;
		boolean oddLength = false;

		// check if args's length is odd or even to determine the collapsed Array length
		if(args.length % 2 == 0) {
			collapsedArgs = new int[argsLength / 2];
		} else {
			collapsedArgs = new int[argsLength / 2 + 1];
			oddLength = true;
		}

		// combine the adjacent indexes of args
		// best to set j = 1 and use j - 1 to avoid IndexOutOfBoundException
		int i = 0;
		for(int j = 1; j < argsLength; j += 2) {
			collapsedArgs[i] = args[j - 1] + args[j];
			i++;
		}
		// fence-post solution for odd lengths of collapsedArgs Array
		if(oddLength) {
			collapsedArgs[i] = args[argsLength - 1];
		}
		return collapsedArgs;
	}
}
