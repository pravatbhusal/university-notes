package chapter9;

public abstract class InheritedAbstractParent {

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

	// abstract method for setName, must be implemented in child class
	public abstract void setName(String name);

	// abstract method for setCost, must be implemented in child class
	public abstract void setCost(int cost);
}
