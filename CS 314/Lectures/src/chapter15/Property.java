package chapter15;

public class Property {

	// instance variables
	private int price;
	private String name;

	// construct a Property for Monopoly using its price and name
	public Property(int price, String name) {
		this.price = price;
		this.name = name;
	}

	// return the price
	public int getPrice() {
		return price;
	}

	// return the name
	public String getName() {
		return name;
	}

	// return the Property as a String
	public String toString() {
		return name + " costs " + price;
	}

	/* check if another property is equal to this property by
		overriding the equals method from the Object class */
	public boolean equals(Object obj) {
		boolean isInstance = obj instanceof Property;
		if(isInstance) {
			// cast the Object variable into a Property variable to use the Property methods
			Property objProperty = (Property) obj;
			return objProperty.getName().equals(name) && objProperty.getPrice() == price;
		}
		// the program never ran the Property checker, so it failed the instanceOf check
		return false;
	}
}