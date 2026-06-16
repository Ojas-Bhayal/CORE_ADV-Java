package in.co.rays.basic;

public class MaxMin {
	public static void main(String[] args) {
		// Finding Maximum Number & Smaller Number
		int a = 5;
		int b = 10;
		if (a > b) {
			System.out.println("a is greater");
		} else if (a == b) {
			System.out.println("Both are equal");
		} else {
			System.out.println("b is greater");
		}

		String s = (a > b) ? "b is smaller" : "a is smaller";
		System.out.println(s);
	}
}
