package chapter9;

public class InheritedParent {

	// constructor variables
	private String eyeColor;
	private String hairColor;
	private String skinColor;

	// out-lying variables
	public String name = "Bob";

	// default constructor, no parameters (needed to prevent Syntax Error)
	public InheritedParent() {}

	// inherited parent constructor
	public InheritedParent(String eyeColor, String hairColor, String skinColor) {
		this.eyeColor = eyeColor;
		this.hairColor = hairColor;
		this.skinColor = skinColor;
	}

	// return eye color
	public String getEyeColor() {
		return eyeColor;
	}

	// return hair color
	public String getHairColor() {
		return hairColor;
	}

	// return skin color
	public String getSkinColor() {
		return skinColor;
	}

	public String getName() {
		return name;
	}

	// set the name of the person
	public void setName(String name) {
		this.name = "Bob";
	}
}
