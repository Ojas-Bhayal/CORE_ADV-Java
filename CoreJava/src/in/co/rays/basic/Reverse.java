package in.co.rays.basic;

public class Reverse {
	public static void main(String[] args) {
		// Q5 -- Reverse of Digits
		int m = 1234;
		int temp = 0;
		while (m != 0) {
			int sn = m;
			sn = m % 10;
			temp = temp * 10 + sn;
			m = m / 10;
		}
		System.out.println(temp);
	}
}
