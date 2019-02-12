package chapter5;

import java.util.Random;

public class RandomNumbers {

	/* Write a method named randomX that keeps printing lines, where each line 
	 * contains a random number of x characters between 5 and 19 inclusive, until 
	 * it prints a line with 16 or more characters.
	 */
	public static void randomX() {
		Random rand = new Random();

		// iterate based on a random number from 5 and 19, inclusive
		// keep printing until i = 16 or more
		int i = 0;
		for(i = rand.nextInt(15) + 5; i < 16; i = rand.nextInt(15) + 5) {
			// iterate based on value of i
			for(int j = 0; j < i; j++) {
				System.out.print("x");
			}
			System.out.println();
		}

		// solve the fence post situation
		// print out the remaining x's once the value of i >= 16
		for(int j = 0; j < i; j++) {
			System.out.print("x");
		}
	}

	/* Write a method named randomWalk that performs a random one-dimensional 
	 * walk, reporting each position reached and the maximum position reached 
	 * during the walk. The random walk should begin at position 0. On each step, 
	 * you should either increase or decrease the position by 1 (with equal 
	 * probability). The walk stops when 3 or -3 is hit.
	 */
	public static void randomWalk() {
		Random rand = new Random();
		int position = 0;
		int maxPosition = 0;

		System.out.println("position = " + position);

		// iterate the loop as long as the position isn't -3 or 3
		// the position random variable will either be 0 or 1
		for(int i = rand.nextInt(2); position != -3 && position != 3; i = rand.nextInt(2)) {
			// increment or decrement position based on value of i
			if(i == 0) {
				position++;
			} else {
				position--;
			}

			// update max position if the position is greater
			if(position > maxPosition) {
				maxPosition = position;
			}
			System.out.println("position = " + position);
		}

		System.out.println("max position = " + maxPosition);
	}
}
