package chapter9;

// example Interface for the Abstract class <- Read Extra Notes #5 for more info
interface inheritedInterface {
	/* all methods in an interface are abstract, so they don't
		need to be implemented by an Abstract class. However,
		the child must implement the methods, instead. */
	public void onlyImplementInChild();
}

public abstract class InheritedAbstractParent implements inheritedInterface {

	public int cost;
	public String name;

	// abstract constructor, must be implemented in child class
	public InheritedAbstractParent(int cost, String name) {
		this.cost = cost;
		this.name = name;
	}

	// return the cost
	public int getCost() {
		return cost;
	}

	// return the cost name
	public String getName() {
		return name;
	}

	// return the Object as a String
	@Override
	public String toString() {
		return name + ": " + cost;
	}

	// abstract method for setName, must be implemented in child class
	public abstract void setName(String name);

	// abstract method for setCost, must be implemented in child class
	public abstract void setCost(int cost);
}
