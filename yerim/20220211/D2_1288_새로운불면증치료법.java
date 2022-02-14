package SWEA;

import java.util.Scanner;

public class D2_1288_새로운불면증치료법 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			boolean[] v = new boolean[10];
			int k = 1; // 양 센 횟수
			int cnt = 0;

			while (true) {
				String str = Integer.toString(k * N);
				// 글자수 세기
				for (int i = 0; i < str.length(); i++) {
					int a = Integer.parseInt(str.substring(i, i + 1));
					if (v[a] == false) {
						v[a] = true;
						cnt++;
					}
				}

				if (cnt == 10)
					break;
				k++;
			}

			System.out.printf("#%d %s\n", tc, k*N);
		}

	}

}
