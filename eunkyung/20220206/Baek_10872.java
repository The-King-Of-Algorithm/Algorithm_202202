package Solution;

import java.util.Scanner;

public class Baek_10872 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int sum = factorial(N);
		System.out.println(sum);
		
	}
	private static int factorial(int n) {
		if (n <= 1)
			return 1;

		return n * factorial(n - 1);
	}



 
}
