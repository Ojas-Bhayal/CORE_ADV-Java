package in.co.rays.basic;

public class Factorial {
	public static void main(String[] args) {
		// Q4 -- Factorial
		int fac = 5;
		if (fac == 0 | fac == 1) {
			System.out.println("Factorial of given number is 1");
		} else {
			for (int i = fac - 1; i > 0; i--) {
				fac *= i;
			}
		}
		System.out.println(fac);
	}
}
