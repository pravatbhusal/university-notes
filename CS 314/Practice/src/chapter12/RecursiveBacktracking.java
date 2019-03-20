package chapter12;

import java.util.List;
import java.util.TreeSet;

/*
How to solve any recursive backtracking problem:
	1. Base Case: Think about when the program MUST stop and what value to return when at the stop point.
	2. Non-Base Case: Think of solving the problem where each case in the recursive calls must have the
	same logic, and calling recursively is ONLY to compare the next step with the current step.

 * Try not to think of the program as "what if the stack gets to this point? what if the stack is
	pushed in reverse? etc." these questions will only confuse you when programming in recursion
 * Also, when I say "next step" it's actually the "next few steps" but those "next few steps"
	add up to just be the "next step" when thinking of the problem as a single case instead of a Stack
 */
public class RecursiveBacktracking {

	/* Write a method countBinary that accepts an integer n as a parameter and 
	 * that prints all binary numbers that have n digits in ascending order, 
	 * printing each value on a separate line. All n digits should be shown for 
	 * all numbers, including leading zeros if necessary. You may assume that n is 
	 * non-negative. If n is 0, a blank line of output should be produced.
	 */
	public static void countBinary(int number) {
		String currentNumber = "";
		helperCountBinary(number, currentNumber);
	}

	// a helper method for count binary
	private static void helperCountBinary(int number, String currentNumber) {
		if(number == 0) {
			/* base case where we exhausted the length of number for this recursive combination,
				so print the current number that contains all the concatenated 0s and 1s */
			System.out.println(currentNumber);
		} else {
			// do every binary combination of either 0 or 1, becoming somewhat O(N^2)
			helperCountBinary(number - 1, currentNumber + "0");
			helperCountBinary(number - 1, currentNumber + "1");
		}
	}

	/* In this problem, the scenario we are evaluating is the following: You're 
	 * standing at the base of a staircase and are heading to the top. A small 
	 * stride will move up one stair, and a large stride advances two. You want to 
	 * count the number of ways to climb the entire staircase based on different 
	 * combinations of large and small strides. For example, a staircase of three 
	 * steps can be climbed in three different ways: three small strides, one 
	 * small stride followed by one large stride, or one large followed by one 
	 * small. Write a recursive method waysToClimb that takes a non-negative 
	 * integer value representing a number of stairs and prints each unique way to 
	 * climb a staircase of that height, taking strides of one or two stairs at a 
	 * time. Your method should output each way to climb the stairs on its own 
	 * line, using a 1 to indicate a small stride of 1 stair, and a 2 to indicate 
	 * a large stride of 2 stairs.
	 */
	public static void waysToClimb(int stairs) {
		helperWaysToClimb(stairs, 0, "[");
	}

	// a helper method for the ways to climb method
	private static void helperWaysToClimb(int stairs, int stepsSum, String steps) {
		if(stepsSum == stairs && stairs != 0) {
			// base-case for this recursive call combination, print the steps Stack without trailing comma
			final int TRAILING_COMMA_LENGTH = 2;
			steps = steps.substring(0, steps.length() - TRAILING_COMMA_LENGTH);
			System.out.println(steps + "]");
		} else if(stepsSum < stairs) {
			// test out every stairs combination of either 1 or 2, becoming somewhat O(N^2)
			helperWaysToClimb(stairs, stepsSum + 1, steps + "1, ");
			helperWaysToClimb(stairs, stepsSum + 2, steps + "2, ");
		}
	}

	/* Write a method printSquares that uses recursive backtracking to find all 
	 * ways to express an integer as a sum of squares of unique positive integers. 
	 * Some numbers (such as 128 or 0) cannot be represented as a sum of squares, 
	 * in which case your method should produce no output. Keep in mind that the 
	 * sum has to be formed with unique integers.
	 */
	public static void printSquares(int number) {
		helperPrintSquares(number, 1, new TreeSet<Integer>());
	}

	// a helper method for the print squares method
	private static void helperPrintSquares(int currentNumber, int index, TreeSet<Integer> squares) {
		if(currentNumber == 0) {
			// base case found a list that adds up to number
			System.out.println(squares);
		} else if(currentNumber > 0) {
			// iterate through each potential number that can be summed to equal the currentNumber
			final int MAXIMUM_POSSIBLE_INTEGER = (int) Math.sqrt(currentNumber);
			for(int number = index; number <= MAXIMUM_POSSIBLE_INTEGER; number++) {
				int potentialSquare = number * number;
				if(potentialSquare <= currentNumber) {
					// found a number's square that isn't greater than the current number
					squares.add(number);

					/* recursively go to the next step by decreasing the current
	                    number by the square and going to the next index */
					helperPrintSquares(currentNumber - potentialSquare, number + 1, squares);

					/* a combination was finished and the stack is being popped, so
	                    remove the number to open up space for the next combination */
					squares.remove(number);
				}
			}
		}
		// combination is finished, either it failed or did the base-case
	}

	/* Write a recursive method maxSum that accepts a list of integers L and an 
	 * integer limit n as its parameters and uses backtracking to find the maximum 
	 * sum that can be generated by adding elements of L that does not exceed n. 
	 * Each index's element in the list can be added to the sum only once, but the 
	 * same number value might occur more than once in a list, in which case each 
	 * occurrence might be added to the sum. You may assume that all values in the 
	 * list are non-negative. Your method may alter the contents of the list L as 
	 * it executes, but L should be restored to its original state before your 
	 * method returns.
	 */
	public static int maxSum(List<Integer> list, int limit) {
		return helperMaxSum(list, 0, limit, list.size());
	}

	private static int helperMaxSum(List<Integer> list, int index, int limit, int remaining) {
		if(limit <= 0 || remaining == 0) {
			// base case found a sum that either equaled to the limit or exceeded it
			// or base case exhausted the list with no elements left over, so do not add to the sum
			return 0;
		}
		// get the next sums with this element and without this element
		int element = list.get(index);
		int withElement = element + helperMaxSum(list, index + 1, limit - element, remaining - 1);
		int withoutElement = helperMaxSum(list, index + 1, limit, remaining - 1);

		if(withElement <= limit && withElement > withoutElement) {
			// with element is in-bounds and greater than without
			return withElement;
		}
		// either the with element was not in-bounds or less than without
		return withoutElement;
	}

	/* Write a method subsets that uses recursive backtracking to find every 
	 * possible sub-list of a given list. A sub-list of a list L contains 0 or 
	 * more of L's elements. Your method should accept a List of strings as its 
	 * parameter and print every sub-list that could be created from elements of 
	 * that list, one per line.
	 */
	public static void subsets(List<String> list) {
		helperSubsets(list, 0, list.size());
	}

	// a helper method for the subsets method
	private static void helperSubsets(List<String> list, int index, int remaining) {
		if(remaining == 0) {
			// base case, this list's combination was exhausted
			System.out.println(list);
		} else {
			// go to the next step
			helperSubsets(list, index + 1, remaining - 1);

			// remove this step's String at the index
			String removedString = list.remove(index);

			// go to the next step without the String at the index
			helperSubsets(list, index, remaining - 1);

			// restore the state of the list from when removing the String
			list.add(index, removedString);
		}
	}
}
