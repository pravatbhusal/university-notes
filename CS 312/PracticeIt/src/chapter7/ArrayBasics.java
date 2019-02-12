package chapter7;

public class ArrayBasics{

	/* Write a method named lastIndexOf that accepts an array of integers and an 
	 * integer value as its parameters and returns the last index at which the 
	 * value occurs in the array. The method should return -1 if the value is not 
	 * found.
	 */
	public static int lastIndexOf(int[] arr, int value) {
		int lastIndex = -1;

		// iterate through the entire array, until the very end
		for(int i = 0; i < arr.length; i++) {
			// update the index where the value equals to a value in the array
			if(value == arr[i]) {
				lastIndex = i;
			}
		}

		return lastIndex;
	}

	/* Write a static method named range that takes an array of integers as a 
	 * parameter and returns the range of values contained in the array. The range 
	 * of an array is defined to be one more than the difference between its 
	 * largest and smallest element. For example, if the largest element in the 
	 * array is 15 and the smallest is 4, the range is 12. If the largest and 
	 * smallest values are the same, the range is 1. You may assume that the array 
	 * contains at least one element (that its length is at least 1). You should 
	 * not make any assumptions about the values of the particular elements in the 
	 * array; they could be extremely large, very small, etc. You should not 
	 * modify the contents of the array.
	 */
	public static int range(int[] arr) {
		int largest = arr[0]; // initial value
		int smallest = arr[0]; // initial value

		// start iterating at index 1 because smallest and largest already equals to index 0
		for(int i = 1; i < arr.length; i++) {
			// update largest
			if(arr[i] > largest) {
				largest = arr[i];
			}

			// update smallest
			if(arr[i] < smallest) {
				smallest = arr[i];
			}
		}

		// update range
		int range = 0;
		if(smallest != largest) {
			range = (largest - smallest);
		}
		range++; // must add one to range (instructions said so)

		return range;
	}

	/* Write a static method named isSorted that accepts an array of doubles as a 
	 * parameter and returns true if the list is in sorted (nondecreasing) order 
	 * and false otherwise. Assume the array has at least one element. A 
	 * one-element array is considered to be sorted.
	 */
	public static boolean isSorted(double[] arr) {
		boolean isSorted = true;
		double lastNum = arr[0]; // initial value

		// start iterating at index 1 because lastNum already equals to index 0
		for(int i = 1; i < arr.length; i++) {
			// only do calculation is we determined the list is still in order
			if(isSorted) {
				// check if last number is smaller than the current number
				if(lastNum < arr[i]) {
					lastNum = arr[i];
				} else {
					isSorted = false; // failed, so that means it's not sorted
				}
			}
		}

		return isSorted;
	}
}
