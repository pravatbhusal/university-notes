package chapter9;

public class Abstracts extends InheritedAbstractParent {

	/* Definitions:
	 * 1. Abstract Class: A class that contains abstract methods.
	 * 		- This class cannot be instantiated, only inherited.
	 * 		- However, just like interfaces, the class can be a declare-type
	 * 2. Abstract Method: A method without a body and has undefined behavior.
	 * 		- Must be implemented by the child class unless if the child class
	 * 			itself is an abstract class.
	 * 		- There is no such thing as an "abstract variable"
	 */

	/* Extra Notes:
	 * 1. If there is even one abstract method, the class must be defined as abstract.
	 * 2. Abstract Methods must be either public or protected since they're implemented.
	 * 3. Abstract Methods cannot be static since that goes against abstraction.
	 * 4. Every method in an interface is actually abstract.
	 * 5. Abstract classes can implement interfaces, but don't need to implement their
	 * 		methods because the methods of interfaces are abstract themselves.
	 * 		- However, any class that extends the Abstract class must
	 * 			 implement those interface methods themselves
	 * 6. Abstract classes may have constructors, but only for the purpose of
	 * 		calling super() from the child class.
	 */

	public static void main(String[] args) {
		// Abstract class as a declare-type and initialize it to the child-type
		InheritedAbstractParent parentDeclare = new Abstracts(5, "Bread");
		parentDeclare.setCost(10);
		System.out.println(parentDeclare); // Bread: 10
	}

	// implemented from the abstract class, construct the class
	public Abstracts(int cost, String name) {
		super(cost, name); // <- Read Extra Notes #6 for more info
	}

	// implemented from the abstract class, set the name
	@Override
	public void setName(String name) {
		super.name = name;
	}

	// implemented from the abstract class, set the cost
	@Override
	public void setCost(int cost) {
		super.cost = cost;
	}

	/* must implement the methods from the interfaces that the Abstract
		class uses <- Read Extra Notes #5 for more info */
	@Override
	public void onlyImplementInChild() {}
}
