package chapter3;

public class ReturnMathCasting {

	/* Definitions:
	 * 1. Math: A class with a set of static methods and constants for common mathematical operations.
	 * 2. Type Casting: A conversion from one type to another, has very high precedence.
	 * 		EX: (int) 3.5 / 2 = 3 / 2 = 1
	 *		EX: (int) 3.5 / 1.5 = 3 / 1.5 = 2.0
	 *		EX: (double) 5 / 2 = 5.0 / 2 = 2.5
	 * 3. Short-circuiting: Stopping the execution of code.
	 * 4. return: Sets a value to a method, also short-circuiting the method too.
	 * 5. void: Determines that a method does not return any value. return may still be used without any value.
	 */

	/* Extra Notes
	 * 1. Read all methods/constants for the Math class here:
	 * 		- https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html
	 */

	public static void main(String[] args) {
		// return Overview
		int sum = addNums(3,5);
		System.out.println(sum); // output: 8

		// Basic Math class Overview <- Read Extra Notes #1 for more info
		int max = Math.max(3, 2); // [overloadable] max method (returns greater number), returns 3
		int min = Math.min(34, 32); // [overloadable] min method (returns smaller number), returns 32
		int abs = Math.abs(-3); // [overloadable] absolute value method, returns 3
		double power = Math.pow(2, 3); // power method, 2^3 so returns 8.0
		double random = Math.random(); // random method (returns random number between 0 inclusive to 1.0 exclusive)
		double cielPositive = Math.ceil(3.2); // rounds to the ceiling, returns 4.0
		double floorPositive = Math.floor(8.8); // rounds to the floor, returns 8.0
		double cielNegative = Math.ceil(-3.011); // rounds to the ceiling, returns -3.0
		double floorNegative = Math.floor(-15.3); // rounds to the floor, returns -16.0
		double roundNum = Math.round(5.6); // rounds to the nearest integer, returns 6.0

		// Type Casting Overview <- Read Definitions #2 for more info
		int a = (int) 3.5 / 2; // 1
		double b = (double) 3 / 2; // 1.5
		int c = (int) (5.0 / 2); // (int) (2.5) = 2
		int d = (int) (-7.0 / 2 * 3.1); // (int) (-3.5 * 3.1) = (int) -10.85 = -10
	}

	// a method that adds two numbers, and returns an integer
	public static int addNums(int num1, int num2) {
		int sum = num1 + num2;
		return sum; // returns an integer variable, as specified by the method declaration

		// any code below here will not be executed because the return statement short-circuited the method
	}
}
