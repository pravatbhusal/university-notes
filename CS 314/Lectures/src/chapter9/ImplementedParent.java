package chapter9;

interface ImplementedParent {

	// all variables in an interface are public static final
	public static final String EYE_COLOR = "BLACK";
	public static final String HAIR_COLOR = "BLACK";
	public static final String SKIN_COLOR = "BROWN";

	/* even if the public final static keywords are not used,
		the variables are still public static final */
	String NAME = "Bob";

	// return eye color
	public String getEyeColor();

	// return hair color
	public String getHairColor();

	// return skin color
	public String getSkinColor();

	public String getName();
}