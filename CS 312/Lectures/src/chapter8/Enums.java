package chapter8;

public class Enums {

	/* Definitions:
	 * 1. Enum type: A special data type that enables for a
	 * 		variable to be a set of predefined constants. 
	 */

	/* Extra Notes:
	 * 1. Enum constants are static and final.
	 * 2. Enums with parameters MUST have a constructor.
	 * 3. Enums can be inside or outside of a class.
	 * 		- Typically, enums have their own class.
	 * 4. Objects that equal to an enum will point to the same reference,
	 * 		so they equal to each other when comparing via boolean operator.
	 */

	// a basic enum
	private enum Phones {
		APPLE, SAMSUNG, HTC;
	}

	// any method or variable called in an enum MUST be static
	private final static int FALL_VALUE = 3;

	// an enum with defined parameters
	private enum Seasons {
		SUMMER("Summer", 1), WINTER("Winter", 2),
		FALL("Fall", FALL_VALUE), SPRING("Spring", 4);

		private String name;
		private int value;

		// enum constructor
		private Seasons(String name, int value) {
			this.name = name;
			this.value = value;
		}

		// return the name
		public String getName() {
			return name;
		}

		// set the name
		public void setName(String name) {
			this.name= name;
		}

		// return the value
		public int getValue() {
			return value;
		}

	}

	public static void main(String[] args) {
		System.out.println(Phones.APPLE); // output: APPLE

		// creating a new enum Objects
		Phones samsungPhone = Phones.SAMSUNG;
		Seasons summerSeason = Seasons.SUMMER;
		System.out.println(samsungPhone); // output: SAMSUNG
		System.out.println(summerSeason); // output: SUMMER

		// getting valueOf enum constant
		Phones applePhone = Phones.valueOf("APPLE");
		Seasons winterSeason = Seasons.valueOf("WINTER");
		System.out.println(applePhone); // output: APPLE
		System.out.println(winterSeason); // output: WINTER

		// getting name of enum constant
		Phones htcPhone = Phones.valueOf("HTC");
		Seasons fallSeason = Seasons.valueOf("FALL");
		System.out.println(htcPhone.name()); // output: HTC
		System.out.println(fallSeason.name()); // output: FALL

		// getting toString of enum constant
		System.out.println(htcPhone.toString()); // output: HTC
		System.out.println(fallSeason.toString()); // output: FALL

		// getting ordinal (index position) of an enum constant
		System.out.println(htcPhone.ordinal()); // output: 2
		System.out.println(fallSeason.ordinal()); // output: 2

		// get all the list of values in an enum as an Array
		Phones[] phonesArray = Phones.values();
		Seasons[] seasonsArray = Seasons.values();

		/* you can access private values of enums
			as long as the enum is in the same class */
		System.out.println(summerSeason.value); // output: 1

		// accessing enums methods
		Seasons springSeason = Seasons.SPRING;
		System.out.println(springSeason.getName()); // output: Spring
		System.out.println(springSeason.getValue()); // output: 4

		// reference semantics for enums <- Read Extra Notes #4 for more info
		Seasons summerSeasonReference1 = Seasons.SUMMER;
		Seasons summerSeasonReference2 = Seasons.SUMMER;
		System.out.println(summerSeasonReference1 == summerSeasonReference2); // outputs: true
		summerSeasonReference1.setName("SoOmer!");
		System.out.println(summerSeasonReference2.getName()); // outputs: SoOmer!
	}
}
