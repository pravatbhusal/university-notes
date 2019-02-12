package chapter5;

import java.util.Random;

public class RandomNumbers {
	
	/* Definitions:
	 * 1. Random: The Random object generates pseudo-random numbers.
	 */
	
	public static void main(String[] args) {
		// get the maximum amount of a positive Integer (2^31 -1)
		int maxInt = Integer.MAX_VALUE;
		
		// get the maximum amount of a negative Integer (-2^31)
		int minInt = Integer.MIN_VALUE;
		
		// creating a Random object
		Random rand = new Random();
		
		// get a random integer of any size
		int a = rand.nextInt();
		
		// get a random integer from 0 to 9
		int b = rand.nextInt(10);
		
		// get a random integer from 23 and 30
		int c = rand.nextInt(8) + 23;
		
		// get random number between 0 inclusive to 1.0 exclusive
		double d = rand.nextDouble();
	}
}
