package in.co.rays.basic;

import java.util.Scanner;

public class SwitchCase {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter First number : ");
		int a = input.nextInt();

		System.out.println("Enter Second number : ");
		int b = input.nextInt();

		System.out.println("Please Select operation to perform : (+, -, *, /, %) ");
		String op = input.next();

		switch (op) {
		case "+":
			System.out.println("Addition : " + (a + b));
			break;
		case "-":
			System.out.println("Subtraction : " + (a - b));
			break;
		case "*":
			System.out.println("Multiplication : " + (a * b));
			break;
		case "/":
			System.out.println("Division : " + (a / b));
			break;
		case "%":
			System.out.println("Modulo : " + (a % b));
			break;
		default:
			System.out.println("Wrong Operator Used..");
			break;
		}
	}
}
