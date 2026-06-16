package in.co.rays.basic;

public class EsumOsum {
	public static void main(String[] args) {
		int N = 10;
		int esum = 0;
		int osum = 0;

		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) {
				esum += i;
			} else {
				osum += i;
			}
		}
		System.out.println("Even Sum : " + esum + " Odd Sum : " + osum);
	}
}
