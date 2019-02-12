package chapter1;

/* Write a complete Java program in a class named Stewie that prints the 
 * following output:
 * //////////////////////
 * || Victory is mine! ||
 * \\\\\\\\\\\\\\\\\\\\\\
 */

public class Stewie{
    public static void main(String[] args){
    	// we can use the slash / in Java without consequences
        System.out.println("//////////////////////");
        System.out.println("|| Victory is mine! ||");
        // however, we need a double backslash \\ in order to return a single backslash \
        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
    }
}