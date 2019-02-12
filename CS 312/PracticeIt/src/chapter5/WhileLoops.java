package chapter5;

import java.util.Scanner;

public class WhileLoops {

	/* Write a method named diceSum that prompts the user for a desired sum, then 
	 * repeatedly rolls two six-sided dice until their sum is the desired sum.
	 */
	public static void diceSum() {
		Scanner src = new Scanner(System.in);

		// prompt the user for a dice sum
		System.out.print("Desired dice sum: ");
		int desiredSum = src.nextInt();
		int sum = 0;

		while(sum != desiredSum) {
			int roll1 = (int)((Math.random() * 6) + 1);
			int roll2 = (int)((Math.random() * 6) + 1);
			sum = roll1 + roll2;

			// print the roll and sum statement
			System.out.println(roll1 + " and " + roll2 + " = " + sum);
		}
	}

	/* Write a method named printAverage that accepts a Scanner for the console as 
	 * a parameter and repeatedly prompts the user for numbers. Once any number 
	 * less than zero is typed, the average of all non-negative numbers typed is 
	 * displayed. Display the average as a double, and do not round it.
	 */
	public static void printAverage(Scanner src) {
		// calculate average variables
		double num = 9999999;
		double totalNum = 0;
		double numberOfNums = 0;

		while(num >= 0) {
			System.out.print("Type a number: ");
			num = src.nextDouble();

			// update the values to calculate average
			if(num >= 0) {
				totalNum += num;
				numberOfNums ++;
			}
		}

		// if the first case was negative, do not print the average
		if(totalNum != 0) {
			double average = totalNum / numberOfNums;
			System.out.println("Average was " + average);
		}
	}
}
