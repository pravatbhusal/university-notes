package chapter7;

import java.util.Scanner;

public class SortAndSearch {

	/* Write a method called median that accepts an array of integers as its 
	 * argument and returns the median of the numbers in the array. The median is 
	 * the number that will appear in the middle if you arrange the elements in 
	 * order. Assume that the array is of odd size (so that one sole element 
	 * constitutes the median) and that the numbers in the array are between 0 and 
	 * 99 inclusive.
	 */
	public static int median(int[] args) {
		selectionSort(args); // sort Array

		// get the middle (median) number of the odd Array length
		int middle = args.length / 2;
		return args[middle];
	}

	/* Write a method called kthLargest that accepts an integer k and an array a 
	 * as its parameters and returns the element such that k elements have greater 
	 * or equal value. If k = 0, return the largest element; if k = 1, return the 
	 * second largest element, and so on. Assume that 0 <= k < a.length.
	 */
	public static int kthLargest(int k, int[] a) {
		selectionSort(a);

		// get the kth largest number
		int kIndex = (a.length - 1) - k;
		return a[kIndex];
	}

	/* Write a method called wordLengths that accepts a Scanner representing an 
	 * input file as its argument. Your method should read from the given file, 
	 * count the number of letters in each token in the file, and output a result 
	 * diagram of how many words contain each number of letters. Use tabs before 
	 * the asterisks so that they'll line up. If there are no words of a given 
	 * length, omit that line from the output.
	 */
	public static void wordLengths(Scanner src) {
		final int MAX_TOKEN_LENGTH = 80;
		int[] args = new int[MAX_TOKEN_LENGTH];

		while(src.hasNext()) {
			// increment the Array for the specific char length
			String token = src.next();
			int length = token.length() - 1; // indexing
			args[length]++;
		}
		for(int i = 0; i < args.length; i++) {
			// only output when length's num occurances > 0
			if(args[i] > 0) {
				String asterisks = "";
				for(int j = 0; j < args[i]; j++) {
					asterisks += "*";
				}
				int length = i + 1; // indexing
				System.out.println(length + ": " + args[i] + "\t" + asterisks);
			}
		}
	}

	// selection sort algorithm for integer Arrays
	public static void selectionSort(int[] args) {
		final int ARGS_LENGTH = args.length;
		for(int i = 0; i < ARGS_LENGTH; i++) {
			int smallestNum = args[i];
			int position = i;

			// iterate after i, so the program doesn't reverse sort
			for(int j = i + 1; j < ARGS_LENGTH; j++) {
				// get the smallest number in the Array
				if(args[j] < smallestNum) {
					smallestNum = args[j];
					position = j;
				}
			}
			// swap the current index with the smallest number
			int temp = args[i];
			args[i] = smallestNum;
			args[position] = temp;
		}
	}
}
