package chapter1;

/* Write a complete Java program in a class named Stewie2 that prints the 
 * following output. Use at least one static method besides main to remove 
 * redundancy.
 * //////////////////////
 * || Victory is mine! ||
 * \\\\\\\\\\\\\\\\\\\\\\
 * || Victory is mine! ||
 * \\\\\\\\\\\\\\\\\\\\\\
 * || Victory is mine! ||
 * \\\\\\\\\\\\\\\\\\\\\\
 * || Victory is mine! ||
 * \\\\\\\\\\\\\\\\\\\\\\
 * || Victory is mine! ||
 * \\\\\\\\\\\\\\\\\\\\\\
 */

public class Stewie2 {
    public static void main(String[] args) {
        System.out.println("//////////////////////");
        victoryMine();
        victoryMine();
        victoryMine();
        victoryMine();
        victoryMine();
    }
    
    // create a method to output the "Victory is mine!" structure in order to reduce redundancy
    private static void victoryMine() {
        System.out.println("|| Victory is mine! ||");
        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
    }
}