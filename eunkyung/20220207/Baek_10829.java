package Solution;

import java.util.Scanner;
//이진수..
public class Baek_10829 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();

		f(N);
	}

	private static void f(long n) {
		if (n > 0) {
			f(n / 2);
			System.out.print(n % 2);
		} else
			return;
	}
}
