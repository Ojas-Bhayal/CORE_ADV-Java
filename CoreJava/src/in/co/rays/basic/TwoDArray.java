package in.co.rays.basic;

public class TwoDArray {
	public static void main(String[] args) {
		// Q8 -- 2D Array
		int[][] arr = new int[9][10];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 10; j++) {
				arr[i][j] = (i + 2) * (j + 1);
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
