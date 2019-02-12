package chapter5;

public class Booleans {

	/* Write a method named gcd that accepts two integers as parameters and returns
	 * the greatest common divisor of the two numbers. The greatest common divisor 
	 * (GCD) of two integers a and b is the largest integer that is a factor of 
	 * both a and b. The GCD of any number and 1 is 1, and the GCD of any number 
	 * and 0 is that number.
	 */
	public static int gcd(int a, int b) {
		// if any integer is 0 or 1, then return the absolute value of the other integer
		if(a == 0 || a == 1) {
			return Math.abs(b);
		} else if(b == 0 || b == 1) {
			return Math.abs(a);
		}

		// get the greatest common divisor
		a = Math.abs(a);
		b = Math.abs(b);
		while(b != 0) {
			int remainder = a % b;
			if(remainder == 0) {
				return b;
			}
			a = b;
			b = remainder;
		}

		return a;
	}

	/* Write a method named consecutive that accepts three integers as parameters 
	 * and returns true if they are three consecutive numbers; that is, if the 
	 * numbers can be arranged into an order such that there is some integer k 
	 * such that the parameters' values are k, k+1, and k+2. Your method should 
	 * return false if the integers are not consecutive. Note that order is not 
	 * significant; your method should return the same result for the same three 
	 * integers passed in any order.
	 */
	public static boolean consecutive(int a, int b, int c) {
		int max = Math.max(a, Math.max(b,c)); // get largest number of the range
		int min = Math.min(a, Math.min(b,c)); // get smallest number of the range
		int mid = a + b + c - max - min; // get the middle value of the range

		/* check if the max value is 1 greater than mid,
	        and check if the min value is 1 less than mid */
		return max == mid + 1 && min == mid - 1;
	}

	/* Write a method named monthApart that accepts four integer parameters 
	 * representing two calendar dates. Each date consists of a month (1 through 12
	 * and a day (1 through the number of days in that month [28-31]). The method
	 * returns whether the dates are at least a month apart. Assume that all dates
	 * in this problem occur during the same year. Note that the first date could
	 * come before or after (or be the same as) the second date. Assume that all
	 * parameter values passed are valid.
	 */
	public static boolean monthApart(int month1, int day1, int month2, int day2) {
		int monthDifference = Math.abs(month1 - month2);
		int dayDifference = Math.abs(day1 - day2);

		// if the 2 months are the same month, then they're not at least a month apart
		if(monthDifference == 0) {
			return false;
		} else {
			// if the 2 months have the same day, then they're at least a month apart
			if(dayDifference == 0) {
				return true;
			}

			/* NOTE: having more than 30 days apart means
	            that the dates are at least 30 days apart */

			/* if the greater month is greater than the day of the smaller
	            month, then the dates are at least 30 days apart */
			boolean greaterMonth = (month1 > month2 && day1 > day2) ||
					(month2 > month1 && day2 > day1);

			/* if the month difference is more than a month, then the
	            dates are at least 30 days apart */
			boolean moreThanOneMonth = monthDifference > 1;

			if(greaterMonth || moreThanOneMonth) {
				return true;
			}

			// all other cases failed, so they're not a month apart
			return false;
		} 
	}
}
