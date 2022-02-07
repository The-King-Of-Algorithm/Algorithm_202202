package SWEA;

import java.util.Scanner;

public class D2_2001 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map = new int[N][N];

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int max = 0;
			for (int i = 0; i <= N-M; i++) {
				for (int j = 0; j <= N-M; j++) {
					int sum = 0;
					// M만큼 순회
					for (int m = i; m < i + M; m++) {
						for (int n = j; n < j + M; n++) {
							sum += map[m][n];
						}
					}

					// System.out.println(sum);
					max = Math.max(max, sum);
				}
			}

			System.out.printf("#%d %d\n", tc, max);
		}
	}

}
