package chapter7;

import java.util.Arrays;

public class ArrayBasics {

	/* Definitions:
	 * 1. Data Structure: A variable that stores other variables.
	 * 2. Array: Object that stores many values of the same type.
	 * 		- element: One value in an Array
	 * 		- index: a 0-based integer to access an element in an Array
	 * 3. Subscript Operator []: An operator pointing to an index in an Array.
	 * 4. Traversal: An examination of each element of an Array.
	 * 		- You can use a for or while loop to traverse through an Array
	 */

	/* Extra Notes:
	 * 1. <name>[<index>] // access Array
	 * 2. <name>[<index>] = <value> // modify Array
	 * 3. Array lengths use the length constant, not the length() method like Strings
	 * 4. Default element value of any number-type Array is 0.
	 * 5. Default element value of a boolean-type Array is false.
	 * 6. Default element value of an Object-type Array is null.
	 */

	/* Programming Hygiene Tips:
	 * 1. Add the subscript identifier when declaring an Array after the data-type
	 * 		- EX: int[] x NOT int x[]
	 * 2. Do not create a pre-defined Array with magic numbers.
	 */

	public static void main(String[] args) {
		// creating an int Array of fixed length 5
		int[] x = new int[5];
		System.out.println(x[0]); // outputs: 0 <- Read Extra Notes #4 for more info
		
		// Arrays with length 0 are blank, and Arrays below 0 throw a NegativeArraySizeException
		int[] zeroLength = new int[0]; // 0 length Array
		// int[] negativeLength = new int[-2]; // throws a runtime exception

		// setting an element in an Array
		x[0] = 25; // setting the 0th of x element to 25

		// creating an int Array with fixed values (pre-defined Arrays)
		int[] y = {34,78,345,34,21}; // <- Read Programming Hygiene #2 for more info
		int[] z = new int[] {34,78,345,34,21}; // another way to create pre-defined Arrays

		// accessing an element inside an Array
		System.out.println(y[0]); // outputs 0th index of y: 34
		System.out.println(x[0]); // outputs 0th index of x: 25
		System.out.println(y[4]); // outputs 4th index of y: 21

		// creating an Array for another data-type (String)
		String[] names = new String[3];
		names[0] = "Pravat";
		names[1] = "Bob";
		names[2] = "Carl";
		// names cannot go past index 2, since length is 3

		// get length (number of elements) of an Array
		int namesLength = names.length; // returns: 3

		// traversing through the names Array
		for(int i = 0; i < namesLength; i++) {
			System.out.println(names[i]); // outputs each element of an Array
		}

		// Arrays class (contains static methods)
		int[] arr = {234,324,345,3245,34,53};
		String arrAsString = Arrays.toString(arr);
		System.out.println(arrAsString); // output: [234, 324, 345, 3245, 34, 53]
	}
}
