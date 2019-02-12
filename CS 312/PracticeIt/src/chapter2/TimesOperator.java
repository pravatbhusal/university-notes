package chapter2;

public class TimesOperator {

	/*
	* Suppose you have a real number variable x. Write a single Java statement that 
	* declares and computes a variable y storing the result of the following computation,
	* but modify the expression to use the * operator only four times while computing an equivalent value
	* (hint: factor the equation):
	* y = 12.3x^4 - 9.1x^3 + 19.3x^2 - 4.6^x + 34.2
	*/
	
	int x = 0; // placeholder x variable for the Java program to not return an error
	double y = x * (x * (19.3 + x * (12.3 * x - 9.1)) - 4.6) + 34.2;
}
