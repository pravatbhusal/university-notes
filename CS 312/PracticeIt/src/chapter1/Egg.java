package chapter1;

/* Write a complete Java program in a class named Egg that displays the 
 * following output:
 *   _______
 *  /       \
 * /         \
 * -"-'-"-'-"-
 * \         /
 *  \_______/
 */

public class Egg {
    public static void main(String[] args) {
    	/* NOTE: You can find out which space to start the output line from
    	 * based on the output that needs to use the very back spacing.
    	 * For example, the -"-'-"-'-"- line uses the very back spacing
    	 * of the entire output, so we base the spacing on that line.
    	 */
    	System.out.println("  _______");
        System.out.println(" /       \\"); // you need to use a double backslash \\ to output a backslash
        System.out.println("/         \\");
        System.out.println("-\"-'-\"-'-\"-"); // we need to use the escape sequence \" to output a quote
        System.out.println("\\         /");
        System.out.println(" \\_______/");
    }
}
