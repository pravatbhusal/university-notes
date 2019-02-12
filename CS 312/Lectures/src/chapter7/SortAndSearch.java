package chapter7;

import java.util.Arrays;

public class SortAndSearch {

	/* Definitions:
	 * 1. Selection Sort: Sorting algorithm to sort a list in ascending order.
	 * 		- Finds the smallest item in the array (minimum)
	 * 		- Puts that value in the first element of the Array
	 * 		- Keeps iterating until all values are in-order
	 * 2. Binary Search: Searching algorithm to search for an item before or after the middle.
	 * 		- Must be implemented after sorting is complete
	 * 		- Looks at the middle of Array, then looks if the item is greater or,
	 * 			less than middle, then ignores the other half and searches from
	 * 			the correct segment of the Array.
	 */

	public static void main(String[] args) {
		// selection sort
		int[] data = {34,5432,53,324,645,876,324,456};
		selectionSort(data);
		System.out.println(Arrays.toString(data)); // outputs the data Array in ascending order

		// binary search
		int result = binarySearch(data, 645);
		System.out.println("Search found on index: " + result); // output: Search found on index: 5
	}

	// selection sort algorithm for integer Arrays
	public static void selectionSort(int[] data) {
		final int ARGS_LENGTH = data.length;
		for(int i = 0; i < ARGS_LENGTH; i++) {
			int smallestNum = data[i];
			int position = i;

			// iterate after i, so the program doesn't reverse sort
			for(int j = i + 1; j < ARGS_LENGTH; j++) {
				// get the smallest number in the Array
				if(data[j] < smallestNum) {
					smallestNum = data[j];
					position = j;
				}
			}
			// swap the current index with the smallest number
			int temp = data[i];
			data[i] = smallestNum;
			data[position] = temp;
		}
	}

	// binary search algorithm for integer Arrays
	public static int binarySearch(int[] data, int value) {
		int start = 0;
		int length = data.length - 1;
		while(start <= length) {
			int middle = (start + length) / 2;

			// binary search algorithm <- Read Definitions #2 for more info
			if(value == data[middle]) {
				return middle;
			} else if(value < data[middle]) {
				length = middle - 1;
			} else {
				start = middle + 1;
			}
		}
		return -1; // no index found
	}
}