package in.co.rays.basic;

public class Prime {
	public static void main(String[] args) {
		// Checking number is prime or not
		int num = 5;
		boolean p = true;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				p = false;
				break;
			}
		}

		if (p) {
			System.out.println("Prime Number");
		} else {
			System.out.println("Not Prime Number");
		}
	}
}
