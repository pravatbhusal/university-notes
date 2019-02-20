package chapter9;

public class AbstractPolymorphism extends InheritedAbstractParent {

	/* Definitions:
	 * 1. Abstract Class: A class that contains abstract methods.
	 * 		This class cannot be instantiated, only inherited.
	 * 2. Abstract Method: A method without a body and has undefined behavior.
	 * 		This method must be implemented by the child class. 
	 */

	/* Extra Notes:
	 * 1. If there is even one abstract method, the class must be defined as abstract.
	 * 2. Abstract Methods must be either public or protected since they're implemented.
	 * 3. Abstract Methods cannot be static since that goes against abstraction.
	 * 4. Every method in an interface is actually abstract.
	 */

	// implemented from the abstract class, construct the class
	public AbstractPolymorphism(int cost, String name) {
		super(cost, name);

		// call the abstract methods implemented in this class
		setName("Bread");
		setCost(1);

		// output the results
		System.out.println(getName()); // output: Bread
		System.out.println(getCost()); // output: 1
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
}
