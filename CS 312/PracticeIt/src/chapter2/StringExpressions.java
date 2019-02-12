package chapter2;

/* String (text) Concatenation/Mathematical Expressions */
public class StringExpressions {
	
	/* String concatenation uses the plus operator +
	 * It still follows the rules of PEMDAS.
	 * Ex: "hello " + "world" = hello world
	 */
	
	/* String concatenation can also concatenate with numbers,
	 * but it MUST follow PEMDAS. Therefore, any numbers outside
	 * of a parenthesis and after a String will be concatenated
	 * rather than added mathematically.
	 * Ex: 3 + 5 + "hello" + 3 + 2 = 8hello32
	 * Ex: 3 + 2 + "yes" + (3 + 2) = 5yes5
	 * Ex: "okay" + 3 + 2 = okay32
	 * Ex: "hello" + 3 * 2 = hello6
	 * Ex: 3 - 2 + "okay" = 1okay
	 * Ex: 2 - 1 + "hello" + 3 - 2 = ERROR! The minus symbol's order of precedence cannot go after a String!
	 */

	/*  Example Questions:
		2 + 2 + 3 + 4 = 11
		"2 + 2 " + 3 + 4 = 2 + 2 34
		2 + " 2 + 3 " + 4 = 2 2 + 3 4
		3 + 4 + " 2 + 2" = 7 2 + 2
		"2 + 2 " + (3 + 4) = 2 + 2 7
		"(2 + 2) " + (3 + 4) = (2 + 2) 7
		"hello 34 " + 2 * 4 = hello 34 8
		2 + "(int) 2.0" + 2 * 2 + 2 = 2(int) 2.042
		4 + 1 + 9 + "." + (-3 + 10) + 11 / 3 = 14.73
		8 + 6 * -2 + 4 + "0" + (2 + 5) = 007
		1 + 1 + "8 - 2" + (8 - 2) + 1 + 1 = 28 - 2611
		5 + 2 + "(1 + 1)" + 4 + 2 * 3 = 7(1 + 1)46
		"1" + 2 + 3 + "4" + 5 * 6 + "7" + (8 + 9) = 123430717
	 */
}
