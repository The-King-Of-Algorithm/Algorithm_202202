package hw_20220215;

import java.util.Scanner;

//Z
public class Baek_1074 {
	static int idx = 0;
	static int R, C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();
		int n = exp(2, N);

		recursive(0, 0, n);
	}

	private static void recursive(int r, int c, int n) {
		if (n == 1) {
			if (r == R && c == C) {
				System.out.println(idx);
			}
			return;
		}
		int N = n / 2;
		if (R < N + r && C < N + c) {
			recursive(r, c, N);
		}
		if (R < N + r && C >= N + c) {
			idx += N * N;
			recursive(r, c + N, N);
		}
		if (R >= N + r && C < N + c) {
			idx += N * N * 2;
			recursive(r + N, c, N);
		}
		if (R >= N + r && C >= N + c) {
			idx += N * N * 3;
			recursive(r + N, c + N, N);
		}

	}

	private static int exp(int x, int n) {
		if (n == 1) {
			return 2;
		}
		if (n == 0) {
			return 1;
		}
		int y = exp(x, n / 2);
		return (n % 2 == 0) ? y * y : y * y * x;
	}
}
