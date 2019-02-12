package chapter2;

public class ValuesOfJFK {

	/* This lecture conveys how to variables, specifically integers */
	public static void main(String[] args) {
		int i = 2;
		int j = 3;
		int k = 4;
		int x = i + j + k; // 9
		i = x - i - j; // 4
		j = x - j - k; // 2
		k = x - i - k; // 1
	}
}
