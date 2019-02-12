package chapter2;

public class MaxMin {

	/* This lectures conveys how to do Integer Expressions with variables
	 NOTE: The same methodology can be used on Double Expressions with variables. */
	public static void main(String[] args) {
		int max;
		int min = 10;
		max = 17 - 4 / 10; // 17 - 0 = 17
		max = max + 6; // 17 + 6 = 23
		min = max - min; // 23 - 10 = 13
		System.out.println(max * 2); // 46
		System.out.println(max + min); // 36
		System.out.println(max); // 23
		System.out.println(min); // 13
	}
}
