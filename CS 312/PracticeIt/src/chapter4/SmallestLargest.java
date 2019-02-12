package chapter4;

import java.util.Scanner;

/* Write a method named smallestLargest that asks the user to enter numbers, 
 * then prints the smallest and largest of all the numbers typed in by the 
 * user. You may assume the user enters a valid number greater than 0 for the 
 * number of numbers to read.
 */
public class SmallestLargest {

	public static void main(String[] args) {
		smallestLargest();
	}
	public static void smallestLargest() {
		Scanner src = new Scanner(System.in);

		// use a print statement so the user can input the number on the same line
		System.out.print("How many numbers do you want to enter? ");
		int numbers = src.nextInt(); // after the user presses enter, a new line is formed

		int smallest = 0;
		int largest = 0;

		// iterate based on the number of inputs the user wishes to enter
		for(int i = 1; i <= numbers; i++) {
			System.out.print("Number " + i + ": ");
			int number = src.nextInt(); // after the user presses enter, a new line is formed

			if(i == 1) { // first test case, set smallest and largest to number
				smallest = number;
				largest = number;
			} else if(number < smallest) { // if the inputted number is less than smallest
				smallest = number;
			} else if(number > largest) { // if the inputted number is greater than largest
				largest = number;
			}
		}

		System.out.println("Smallest = " + smallest);
		System.out.println("Largest = " + largest);
	}
}
