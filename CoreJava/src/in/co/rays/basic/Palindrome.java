package in.co.rays.basic;

public class Palindrome {
	public static void main(String[] args) {
		// Q12 -- Palindrome or not
		int m1 = 121;
		int n1 = m1;
		int ptemp = 0;
		while (m1 != 0) {
			int sn1 = m1;
			sn1 = m1 % 10;
			ptemp = ptemp * 10 + sn1;
			m1 = m1 / 10;
		}
		if (ptemp == n1) {
			System.out.println("Palindrome");
		} else {
			System.out.println("Not Palindrome");
		}
	}
}
