package chapter1;

/* Write a complete Java program in a class named StarFigures that generates 
 * the following output. Use static methods to show structure and eliminate 
 * redundancy in your solution.
 * *****
 * *****
 *  * *
 *   *
 *  * *
 *
 * *****
 * *****
 *  * *
 *   *
 *  * *
 * *****
 * *****
 * 
 *   *
 *   *
 *   *
 * *****
 * *****
 *  * *
 *   *
 *  * *
 */

public class StarFigures {
	/* In order to remove redundancy, we need to breakdown the
	 * output into different components, and each component
	 * is its own method. Therefore, before starting to code,
	 * it's best to write out or think of an algorithm to
	 * break-down the output to individual components (methods).
	 */
	public static void main(String[] args) {
        starFigure();
        System.out.println();
        starFigure();
        starBase();
        System.out.println();
        threeStars();
        starFigure();
    }
    
    public static void starFigure() {
        System.out.println("*****");
        System.out.println("*****");
        System.out.println(" * *");
        System.out.println("  *");
        System.out.println(" * *");
    }
    
    public static void starBase() {
        System.out.println("*****");
        System.out.println("*****");
    }
    
    public static void threeStars() {
        System.out.println("  *");
        System.out.println("  *");
        System.out.println("  *");
    }
}
