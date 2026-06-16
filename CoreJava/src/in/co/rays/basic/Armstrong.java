package in.co.rays.basic;

public class Armstrong {
	public static void main(String[] args) {
		// Q10 -- Finding Armstrong number
		int anum = 153;
		int atemp = anum;
		int asum = 0;
		while (atemp != 0) {
			asum += (atemp % 10) * (atemp % 10) * (atemp % 10);
			atemp = atemp / 10;
		}
		if (asum == anum) {
			System.out.println("Armstrong Number");
		} else {
			System.out.println("Not Armstrong Number");
		}
	}
}
