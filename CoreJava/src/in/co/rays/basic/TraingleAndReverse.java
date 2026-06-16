package in.co.rays.basic;

public class TraingleAndReverse {
	public static void main(String[] args) {
		for(int i = 1;i<6;i++) {
			for(int j = i;j>0;j--) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		System.out.println("Reverse Triangle : ");
		for(int i = 5;i>=1;i--) {
			for(int j = i;j>0;j--) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
