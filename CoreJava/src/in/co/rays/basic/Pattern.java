package in.co.rays.basic;

public class Pattern {
	public static void main(String[] args) {
		// Q9 -- Pattern
		for (int i = 1; i < 5; i++) {
			for (int j = i; j > 0; j--) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
