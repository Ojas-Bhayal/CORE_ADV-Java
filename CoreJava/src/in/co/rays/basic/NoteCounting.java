package in.co.rays.basic;

public class NoteCounting {
	public static void main(String[] args) {
		int money = 12850;

		int[] note = { 1000, 500, 200, 100, 50 };
		int count = 0;
		for (int i : note) {
			count = money / i;
			if (count > 0) {
				System.out.println("The count of " + i + " in 12850 is " + count);
			}
			money = money % i;
		}
	}
}
