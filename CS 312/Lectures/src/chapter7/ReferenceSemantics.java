package chapter7;

import java.util.Arrays;

public class ReferenceSemantics {

	/* Definitions:
	 * 1. Value Semantics: Behavior where values are copied when assigned,
	 * 		passed as parameters, or returned.
	 * 		- All primitive types use value semantics in Java
	 * 		- When one variable is assigned to another, its value is copied
	 * 		- Modifying the value of one variable doesn't affect others
	 * 2. Reference Semantics: Behavior where variables actually store the
	 * 		address of an object in memory.
	 * 		- When one variable is assigned to another, the object is
	 * 			not copied; both variables refer to the SAME object
	 * 		- Modifying the value of one variable affects the others
	 * 		- However, modifying the reference of one variable does NOT affect others
	 */

	/* Extra Notes:
	 * 1. Arrays and Objects use reference semantics.
	 * 		- Efficiency: Copying large objects slows down a program
	 * 		- Sharing: Useful to share an object's data among methods
	 * 
	 */

	public static void main(String[] args) {
		// example of Reference Semantics <- Read Definitions #2 for more info
		int[] data1 = {1, 5, 3};
		changeArrayValue(data1);
		System.out.println(Arrays.toString(data1)); // [3, 5, 1]

		// example of Reference Semantics <- Read Definitions #2 for more info
		int[] data2 = {1, 5, 3};
		changeArrayReference(data2);
		System.out.println(Arrays.toString(data2)); // [2, 5, 3]
	}

	public static void changeArrayValue(int[] data) {
		int temp = data[0];
		data[0] = data[data.length - 1]; // changes value to data1[0], too
		data[data.length - 1] = temp; // // changes value to data1[data.length -1], too
		System.out.println(Arrays.toString(data) + " "); // [3, 5, 1]
	}

	public static void changeArrayReference(int[] data) {
		data[0]++;
		data = new int[] {4, 6}; // new reference to data parameter
		System.out.println(Arrays.toString(data) + " "); // [4, 6]
	}
}
