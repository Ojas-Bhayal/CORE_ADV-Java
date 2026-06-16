package in.co.rays.basic;

//Odd Even
//Sequence Order 
//Prime or not
public class PractiseQuestions {
	public static void main(String[] args) {
		// Finding out Odd Even Number
		int num = 5;

		if (num % 2 == 0) {
			System.out.println("Even Number");
		} else {
			System.out.println("Odd Number");
		}

		// Printing Sequence of Number

		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		System.out.println("Reverse Order : ");
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}

		// Checking number is prime or not
		boolean p = true;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				p = false;
				break;
			}
		}

		if (p) {
			System.out.println("Prime Number");
		} else {
			System.out.println("Not Prime Number");
		}

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

		// Q3 -- Later
		for (int i = 0;i<5;i++) {
			System.out.println("Random Number : " + Math.random() * 100);
		}
		// Q4 -- Factorial
		int fac = 5;
		if (fac == 0 | fac == 1) {
			System.out.println("Factorial of given number is 1");
		} else {
			for (int i = fac - 1; i > 0; i--) {
				fac *= i;
			}
		}
		System.out.println(fac);

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

		// Q6 -- Error -- Fibonacci
		int first = 0;
		int second = 1;
		for (int i = 0; i < 10; i++) {
			System.out.print(first + " ");
			second += first;
			System.out.print(second + " ");
			first = second;
		}

		// Q7 -- Divisibility & Sum
		int sum = 0;
		for (int i = 100; i < 200; i++) {
			if (i % 7 == 0) {
				sum += i;
			}
		}
		System.out.println("\nSum of integers : " + sum);

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

		// Q9 -- Pattern
		for (int i = 1; i < 5; i++) {
			for (int j = i; j > 0; j--) {
				System.out.print(i);
			}
			System.out.println();
		}

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
		
		// Q15 -- Finding Largest in Array using method
		int[] arr1 = {1,2,3,4,5,6,71,8,9,10};
		findLargest(arr1,N);
		findSecondLargest(arr1, N);
		// Q17 Q16 Q13 Q6 Q3
				
		// Q17
		int[] A = {1,2,3,4,5,6,7,8,9};
		int[] B = {1,2,3,4,5,6,7,8};
		findMissing(A,B,9);
		// Q18
		findPosition(4,A);
		findPosition(9,B);
	}
	static void findLargest(int arr[], int n) {
		int largest = arr[0];
		for(int i = 1;i<n;i++) {
			if (arr[i]>largest) {
				largest = arr[i];
			}
		}
		System.out.println("largest number in arr : "+ largest);
	}
	static void findSecondLargest(int arr[], int n) {
		int largest = arr[0];
		int secondLargest = arr[0];
		for(int i = 1;i<n;i++) {
			if (arr[i]>largest) {
				secondLargest = largest;
				largest = arr[i];
			}
			if (arr[i]<largest & arr[i]>secondLargest) {
				secondLargest = arr[i];
			}
		}
		System.out.println("Second largest number in arr : "+ secondLargest);
	}

	static void findMissing(int[] a, int[] b, int n) {
		int Asum = 0;
		int Bsum = 0;
		for(int i = 0;i<n;i++) {
			Asum += a[i];
		}
		for(int i = 0;i<n-1;i++) {
			Bsum += b[i];
		}
		System.out.println("Missing Number : " + (Asum - Bsum));
	}

	// Q18 -- Finding Position
	static void findPosition(int a,int[] x) {
		boolean q= true;
		for(int i = 0; i<x.length;i++) {
			if (a == x[i]) {
				q = true;
				break;
			}else {
				q = false;
			}
		}
		if (q) {
			System.out.println("Element Present");
		}else {
			System.out.println("Element not Present");
		}
	}
}
