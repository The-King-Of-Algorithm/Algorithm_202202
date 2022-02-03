package day03;

import java.util.Scanner;

public class Baek_2999 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int R = 0;
		int C = 0;

		for (int i = 1; i < str.length(); i++) {
			if (str.length() % i == 0) {
				int c = str.length() / i;
				if (c >= i) {
					if (R < i) {
						R = i;
						C = c;
					}
				}
			}
		}

		char[][] arr = new char[R][C];
		int n = 0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				arr[j][i] = str.charAt(n);
				n++;
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j]);
			}
		}

	}
}
