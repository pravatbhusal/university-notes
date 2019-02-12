package chapter9;

interface ImplementedParent {

	// all variables in an interface are public final static
	public final static String EYE_COLOR = "BLACK";
	final static String HAIR_COLOR = "BLACK";
	final static String SKIN_COLOR = "BROWN";

	/* even if the public final static keywords are not used,
		the variables are still public final static */
	String NAME = "Bob";

	// return eye color
	public String getEyeColor();

	// return hair color
	public String getHairColor();

	// return skin color
	public String getSkinColor();

	public String getName();
}