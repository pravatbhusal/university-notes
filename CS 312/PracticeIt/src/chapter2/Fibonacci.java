package chapter2;

/* Write a piece of code that uses a for loop to compute and print the first 
 * 12 Fibonacci numbers.
 */
public class Fibonacci {

	public static void main(String[] args) {
		int a = 1; // first preceding number
		int b = 1; // second preceding number
		int c; // current number

		// print out the first two fibonacci numbers to start the sequence
		System.out.print(a + " " + b + " ");

		// iterate through 10 more times
		for(int i = 0; i < 10; i++) {
		    c = a + b;
		    a = b; // set to number after a in the sequence
		    b = c; // set to number after b in the sequence
		    System.out.print(c + " ");
		}
	}
}
