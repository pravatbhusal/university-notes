package chapter12;

public class Recursion {

	/*
	 * Definitions:
	 * 1. Recursion: A method that calls itself with different parameters.
	 */

	/*
	 * 1. Any code before the recursive call is ran during the stack's pushing phase.
	 * 2. Any code that stops the recursive call (base-case) is used to transition from
	 * 		the stack's pushing phase to the stack's popping phase.
	 * 3. Any code after the recursive call is ran during the stack's popping phase.
	 * 4. Therefore, if a method is not void and returns a value, then only code that
	 * 		is NOT the base-case and is NOT after the return (which is impossible) would
	 * 		run under conditions of the algorithm.
	 */

	// a method that details simple recursion
	public static void simpleRecursion(int i) {
		if(i == 0) {
			// code below is to transition from pushing stacks to popping stacks (base-case)
			System.out.println("--- NOW POP EACH STACK FRAME ---");
		} else {
			// code below is ran during this method's stack pushing phase
			System.out.println("Pushing a new stack frame.");

			simpleRecursion(i - 1); // recursive call

			// code below is ran during this method's stack popping phase
			System.out.println("Popping a stack frame.");
		}
	}

	// a recursion factorial algorithm
	public static int factorial(int N) {
		if(N == 0) {
			return 1; // factorial base-case: 0! = 1
		}
		// recursively return N * (returned value of the stack above this stack)
		return N * factorial(N - 1); // factorial non-base case: N * (N-1)! <- The journey
	}

	// a recursive algorithm for powers
	public static int powers(int base, int pow) {
		if(pow == 0) {
			return 1; // power base-case: base^0 = 1
		}
		// recursively return the base * (returned value of the stack above this stack)
		return base * powers(base, pow - 1); // power non-base case: base * base^(pow - 1) <- The journey
	}

	// return the minimum of a list
	public static int getMinOfList(int[] data) {
		return minHelper(0, data);
	}

	// a helper method to determine the minimum of a list
	private static int minHelper(int index, int[] data) {
		if(index == data.length - 1) {
			// base-case, iterated through all of the list
			return data[index];
		}
		// recursively get the returned value of the stack above this stack
		int nextValue = minHelper(index + 1, data);

		if(nextValue < data[index]) {
			return nextValue; // return nextValue because it's smaller
		}
		return data[index]; // return data[index] because it's smaller
	}

	// a method to test the recursive methods
	public static void main(String[] args) {
		simpleRecursion(5);

		factorial(5); // 120
		powers(3, 2); // 9

		int[] data = {45, 2354, 235, 7, 234, 893, 9329};
		getMinOfList(data); // 7
	}
}
