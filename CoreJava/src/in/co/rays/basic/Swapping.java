package in.co.rays.basic;

public class Swapping {
	public static void main(String[] args) {
		// With and without third variable
		int a = 5;
		int b = 10;
		int c = 0;
		
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		/*
		 * Using Third Variable
		c = a;
		a = b;
		b = c;
		*/
		// Without Using Third Variable
		a = a+b;
		b = a-b;
		a = a-b;
		System.out.println("Swapped : ");
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		
	}
}
