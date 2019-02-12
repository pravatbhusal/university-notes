package chapter10;

public class Person implements PersonComparable {

	/* Definitions
	 * 1. compareTo: a standard way for a Java class to define
	 * 		a comparison function for its Objects.
	 * 		- EX: In the String class, there is compareTo(String other)
	 * 		- A call of A.compareTo(B) will return:
	 * 			- a value < 0 if A comes "before" B in the ordering,
	 * 			- a value > 0 if A comes "after" B in the ordering,
	 * 			- or 0 if A and B are considered "equal" in the ordering
	 * 2. Subtraction Trick: Subtracting related numeric values produces
	 * 		the right result for what you want compareTo to return.
	 * 3. Delegation Trick: If your object's fields are comparable (such as
	 * 		Strings), use their compareTo results to help you.
	 * 4. toString Trick: If your object's toString representation is
	 * 		related to the ordering, use that to help you.
	 */

	/* Programming Hygiene Tips:
	 * 1. Any compareTo methods should be declared within an interface.
	 */

	private String name;
	private int age;

	// constructor
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// return name
	public String getName() {
		return name;
	}

	// return age
	public int getAge() {
		return age;
	}

	// using the compareTo interface method
	// an example of comparing two Objects
	@Override
	public int compareTo(Person person) {
		if(age < person.age) {
			return -1;
		} else {
			return 1;
		}
	}
}
