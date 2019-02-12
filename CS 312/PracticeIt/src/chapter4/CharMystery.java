package chapter4;

// What is the output produced by the following program?
public class CharMystery {
	public static void printRange(char startLetter, char endLetter) {
		// get ASCII characters between the startLetter inclusive to endLetter inclusive
		for (char letter = startLetter; letter <= endLetter; letter++) {
			System.out.print(letter);
		}
		System.out.println(); 
	}

	public static void main(String[] args) {
		printRange('e', 'g'); // efg
		printRange('n', 's'); // nopqrs
		printRange('z', 'a'); // 
		printRange('q', 'r'); // qr
	}
}


