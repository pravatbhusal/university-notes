package chapter5;

public class ToBinary {

	/* Write a method named toBinary that accepts an integer as a parameter and 
	 * returns a string of that number's representation in binary. For example, 
	 * the call of toBinary(42) should return "101010".
	 */
	public static String toBinary(int num) {
		String binary = "";

		if(num == 0) {
			binary = "0";
		} else {
			while(num > 0) {
				// binary is determined by the remainder division of 2
				binary += num % 2;
				num /= 2;
			}
		}


		// now reverse the String to get the binary in order
		String reversedBinary = "";
		for(int i = binary.length() - 1; i >= 0; i--) {
			reversedBinary += binary.charAt(i);
		}

		return reversedBinary;
	}
}
