package SWEA;

import java.util.Scanner;

public class D2_1954 {
	// 우, 하, 좌, 상
	static int[] row = { 0, 1, 0, -1 };
	static int[] col = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];

			int idx = 0;
			int num = 1;
			int curR = 0, curC = 0;

			// 배열크기만큼 탐색
			while (num <= N * N) {
				// 값 저장
				map[curR][curC] = num;
				
				// 같은 방향으로 직진
				int dr = curR + row[idx];
				int dc = curC + col[idx];

				// 꺾여야할때 (경계이거나, 다음칸에 숫자 채워져있을때)
				if (dr < 0 || dr >= N || dc < 0 || dc >= N || map[dr][dc] != 0) {
					idx = (idx + 1) % 4;
					dr = curR + row[idx];
					dc = curC + col[idx];
				}
				
				num++;
				curR = dr;
				curC = dc;
			}

			System.out.println("#" + tc);
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}

	}

}
