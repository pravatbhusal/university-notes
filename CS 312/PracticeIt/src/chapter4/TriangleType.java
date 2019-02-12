package chapter4;

/* Write a method called printTriangleType that accepts three integer 
 * arguments representing the lengths of the sides of a triangle and prints 
 * what type of triangle it is. The three types are equilateral, isosceles, 
 * and scalene.
 */
public class TriangleType {

	public static void main(String[] args) {
		printTriangleType(7,3,7); // isoceles
		printTriangleType(6,6,6); // equilateral
		printTriangleType(3,5,6); // scalene
	}
	public static void printTriangleType(int length1, int length2, int length3) {
		// if length1, length2, and length3 are equal, then it's equilateral
		if(length1 == length2 && length2 == length3) {
			System.out.println("equilateral");

			// if all lengths are different, then it's scalene
		} else if(length1 != length2 && length1 != length3 && length2 != length3) {
			System.out.println("scalene");
		} else { // if neither is true, it's isoceles
			System.out.println("isosceles");
		}
	}
}
