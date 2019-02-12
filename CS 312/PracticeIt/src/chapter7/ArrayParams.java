package chapter7;

public class ArrayParams {

	/* Write a method called mode that returns the most frequently occurring 
	 * element of an array of integers. Assume that the array has at least one 
	 * element and that every element in the array has a value between 0 and 100 
	 * inclusive. Break ties by choosing the lower value.
	 */
	public static int mode(int[] arr) {
		int mode = arr[0]; // initial value
		int repeatedOccurs = 0;

		for(int i = 0; i < arr.length; i++) {
			int occurs = 0;
			for(int j = 0; j < arr.length; j++) {
				// make sure the program isn't on the same index, and the elements are the same
				if(i != j && arr[i] == arr[j]) {
					occurs++;
				}
			}
			// set the repeated occurance and mode
			if(occurs >= repeatedOccurs) {
				repeatedOccurs = occurs;
				// break ties by choosing the lower value
				if(arr[i] < mode) {
					mode = arr[i];
				}
			}
		}
		return mode;
	}

	/* Write a method called stdev that returns the standard deviation of an array 
	 * of integers. Standard deviation is computed by taking the square root of 
	 * the sum of the squares of the differences between each element and the mean,
	 * divided by one less than the number of elements. You may assume that the 
	 * array passed is non-null and contains at least two values, because the 
	 * standard deviation is undefined otherwise.
	 */
	public static double stdev(int[] arr) {  
		// get the summation of each element in the array
		double summation = 0;
		for(int i = 0; i < arr.length; i++) {
			summation += arr[i];
		}

		// get the average of the array's values
		double average = summation / arr.length;

		// get the numerator for the stdev equation
		double numerator = 0;
		for(int i = 0; i < arr.length; i++) {
			double element = arr[i] - average;
			numerator += (int)Math.pow(element, 2); // must round or else NaN
		}

		// get the fraction for the stdev equation
		double fraction = numerator / (arr.length - 1);

		// now get the sqrt of the fraction, which is also the stdev value
		double stdev = Math.sqrt(fraction);
		return stdev;
	}

	/* Write a method named minGap that accepts an integer array as a parameter 
	 * and returns the minimum 'gap' between adjacent values in the array. The gap 
	 * between two adjacent values in a array is defined as the second value minus 
	 * the first value. If you are passed an array with fewer than 2 elements, you 
	 * should return 0.
	 */
	public static int minGap(int[] arr) {
		int minGap = 0;

		// change the minGap's minimum value if there's more than one element
		if(arr.length > 1) {
			minGap = Integer.MAX_VALUE;
		}

		for(int i = 0; i < arr.length; i++) {
			// check if program is not at the last index
			if(i != arr.length - 1) {
				int gap = arr[i + 1] - arr[i];
				if(gap < minGap) {
					minGap = gap;
				}
			} else if(i != 0){
				int gap = arr[i] - arr[i - 1];
				if(gap < minGap) {
					minGap = gap;
				}
			}
		}
		return minGap;
	}
}
