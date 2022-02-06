package Solution;

import java.util.Scanner;

//한수
public class Baek_1065 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			if (i < 100) {
				cnt++;
			} else if (i < 1000) {
				boolean state = check(i);
				if (state) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}

	private static boolean check(int i) {
		int n = i % 10;
		i = i / 10;
		int n1 = i % 10;
		i = i / 10;
		int n2 = i % 10;

		if (n - n1 != n1 - n2) {
			return false;
		}
		return true;
	}

}
