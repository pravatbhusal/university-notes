package chapter15;

public class IntList {
	private int[] con;
	private int size;

	/*
	 * Question: 
	 * Complete an instance method for the IntList class that removes a
	 * given range from the IntList.
	 */

	/*
	 * pre: 0 <= start <= stop <= size()
	 * post: Removes from this list all of the elements whose index is between
	 * start, inclusive, and stop, exclusive. Shifts any succeeding elements to the
	 * left (reduces their index). Size of list updated correctly.
	 */
	public void removeRange(int start, int stop) {
		if(start < 0 || start > stop || stop > size) {
			throw new IllegalArgumentException("The start is either less than zero, "
					+ "greater than stop, or stop is greater than the size.");
		}
		// short-circuit the algorithm if it's the same start and stop
		if(start != stop) {
			int range = start - stop;
			for(int removeIndex = stop; removeIndex < size; removeIndex++) {
				/* replace all elements after the stop index
					into the delete range of elements */
				con[removeIndex - range] = con[removeIndex];
			}
		}
	}

	/*
	 * Question:
	 * Given a list with N elements, what is the average time efficiency of your method?
	 * Express in Big O notation and explain your answer.
	 * 
	 * Answer:
	 * O(N) because average case typically means random values for N, so on average
	 * the value of start and stop are random, and the preconditions would succeed,
	 * so the algorithm would take an O(N/2) time, which simplifies to O(N).
	 */

	/*
	 * Question:
	 * Given a list with N elements, what is the average space efficiency for your method?
	 * Express in Big O notation and explain your answer. (Space efficiency refers to the number
	 * of extra variables your method requires. Ignore the space it takes to initially store
	 * the N elements of the list which is within the parameter.
	 * 
	 * Answer:
	 * O(1) because there are no variables that are declared N number of times, such as an Array.
	 * The space complexity refers to how many variables are used that rely on the value of N,
	 * but this algorithm doesn't have any variables, aside from the con[] Array which we ignore
	 * according to the question, so the actual space complexity is just O(1).
	 */
}