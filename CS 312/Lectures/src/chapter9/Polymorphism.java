package chapter9;

// "extends" refers to inheriting a class
public class Polymorphism extends InheritedParent {

	/* Definitions:
	 * 1. Hierarchies: Used to organize information, typically the
	 * 		top is more generalized and bottom is more specific.
	 * 2. Inheritance: A way to form new classes based on existing classes,
	 * 		taking on their attributes or behavior.
	 * 		- Group related classes
	 * 		- Share code between two or more classes
	 * 		- Utilize the "extends" keyword <- This is also referred to as "Polymorphism"
	 * 		- Some argue that using "implements" to an interface is also inheritance
	 * 3. Polymorphism: Ability for the same code to be used with different
	 *		types of objects and behave differently with each.
	 *		- A subset of inheritance
	 *		- EX: System.out.println can print any type of Object in its own way
	 *		- EX: extended classes
	 * 4. Superclass: Parent class that is being extended.
	 * 5. Subclass: Child class that extends the superclass to inherit its behavior.
	 * 		- Gets a copy of every field and method from the Superclass
	 * 		- A child class can only extend from ONE parent class
	 * 6. super: A keyword to call the Parent class, a child's version of "this".
	 * 		- When calling the super class's constructor, it MUST be the
	 * 			first line of code of a child constructor like the "this" keyword
	 * 		- The super keyword may be used anywhere in the class, like the "this" keyword
	 */

	/* Extra Notes:
	 * 1. Object oriented languages provide mechanism to create hierarchies
	 * 		among data types in a program and in code libraries.
	 * 		- This is used for organization, modeling, and avoiding redundancy
	 * 2. Methods from the parent class can be overrided by just creating the
	 * 		same method identifier and parameters in the child class.
	 * 		- IDEs use the @Override annotation to note this, but all
	 * 			annotations are optional in Java
	 * 3. There must be a zero-parameter constructor in the Parent class if you
	 * 		do not use super or this as the first line of code in a Child constructor.
	 * 4. If you are creating your own constructor and you don't have either this
	 * 		or super as the first line of code, the compiler will provide super()
	 * 		as the first statement of the constructor.
	 * 5. All classes extend the Object class.
	 * 6. Polymorphism extensions allow for the top-most Parent class to equal to a
	 * 		child class. However, when doing this the variable is set to the Parent
	 *		class, so the variable cannot access any variables or methods in the child class.
	 *		Also, when doing this, all the overrided methods, interfaces, etc. in the Child
	 *		class are used instead of the Parent's.
	 * 		- EX: InheritedParent parent = new Polymorphism();
	 * 				parent.setName("Jack"); <- the name is now Jack
	 * 			^ The "parent" variable is of the InheritedParent class
	 * 			^ The overrided method setName is used from the Polymorphism
	 * 				 class, not the InheritedParent class
	 */

	public Polymorphism() {
		super(); // <- Read Extra Notes #3 and #4 for more info
	}

	public Polymorphism(String eyeColor, String hairColor, String skinColor) {
		// super call <- Read Definitions #5 for more info
		super(eyeColor, hairColor, skinColor); // calls the parent constructor
		String childEyeColor = getEyeColor(); // eyeColor's value
		String childHairColor = getHairColor(); // hairColor's value
		String childSkinColor = getSkinColor(); //skinColor's value
		String childSkinColorAgain = super.getSkinColor(); //skinColor's value

		setName("Harry");
		String name = getName(); // Harry

		// creating a new Object of a class inside the same file
		MorePolymorphism classExample = new MorePolymorphism("BLACK", "BLACK", "BROWN");
		System.out.println(classExample.getEyeColor()); // output: BLACK

		// polymorphic extensions <- Read Extra Notes #6 for more info
		InheritedParent[] extensions =
			{new Polymorphism(getEyeColor(), getHairColor(), getSkinColor()),
					new MorePolymorphism(getEyeColor(), getHairColor(), getSkinColor()),
					new MoreMorePolymorphism(getEyeColor(), getHairColor(), getSkinColor())};
	}

	// overrides the setName method from the InheritedParent class
	@Override // <- Read Extra Notes #2 for more info
	public void setName(String name) {
		this.name = name;
	}
}

// creating a new class inside a Java file
// extending a class that already extends a class
// NOTE: you cannot define the class within a scope
class MorePolymorphism extends Polymorphism {
	public MorePolymorphism(String eyeColor, String hairColor, String skinColor) {
		super(eyeColor, hairColor, skinColor);
	}
}

// extending a class that already extends a class that already extends a class
class MoreMorePolymorphism extends MorePolymorphism {
	public MoreMorePolymorphism(String eyeColor, String hairColor, String skinColor) {
		super(eyeColor, hairColor, skinColor);
	}
}
