package in.co.rays.basic;

public class DivSum {
	public static void main(String[] args) {
		// Q7 -- Divisibility & Sum
		int sum = 0;
		for (int i = 100; i < 200; i++) {
			if (i % 7 == 0) {
				sum += i;
			}
		}
		System.out.println("\nSum of integers : " + sum);
	}
}
