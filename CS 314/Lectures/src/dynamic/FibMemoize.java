package dynamic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/*
 * A memoized fibonacci implementation.
 */
public class FibMemoize {

	// a look-up table to store (cache) fibonacci numbers
	private static List<BigInteger> lookUpTable = new ArrayList<BigInteger>();

	// initiate the first three terms of the fibonacci sequence
	static {
		// add 0 (there's no 0 in the fibonacci sequence)
		lookUpTable.add(null);

		// add two 1s
		final BigInteger one = new BigInteger("1");
		lookUpTable.add(one);
		lookUpTable.add(one);
	}

	// prevent this class from being instantiated
	private FibMemoize() {}

	// fibonacci sequence algorithm using memoization
	public static BigInteger fib(int n) {
		if(n < lookUpTable.size()) {
			// the value of n is within the table
			return lookUpTable.get(n);
		}
		// unfortunately, must calculate the nth fibonacci number until we find it in the table
		// fibonacci algorithm is f(n) = f(n - 1) + f(n + 2)
		BigInteger leftTerm = lookUpTable.get(lookUpTable.size() - 1);
		BigInteger rightTerm = lookUpTable.get(lookUpTable.size() - 2);
		for(int currentN = lookUpTable.size(); currentN <= n; currentN++) {
			// set the new right term as the sum of the two terms
			BigInteger oldRightTerm = rightTerm;
			rightTerm = rightTerm.add(leftTerm);

			// memoize the new right term (the sum) into the table
			lookUpTable.add(rightTerm);

			// set the left term to the old right term
			leftTerm = oldRightTerm;
		}
		// the loop stopped once the program handled the nth term, return the nth term
		return rightTerm;
	}
}
