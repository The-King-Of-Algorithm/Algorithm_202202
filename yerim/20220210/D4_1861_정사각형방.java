package SWEA;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class D4_1861_정사각형방 {
	// 상 하 좌 우
	static int[] row = { -1, 1, 0, 0 };
	static int[] col = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			int[][] cnt = new int[N][N];
			int max = 0;
			int start = Integer.MAX_VALUE;
			
			// 입력
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = sc.nextInt();
					cnt[i][j] = 1;
				}
			}

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					int a = i;
					int b = j;
					for (int k = 0; k < 4; k++) {
						int dr = a + row[k];
						int dc = b + col[k];
						// 범위안에 있고 현재 위치 +1 이면
						if (dr >= 0 && dr < N && dc >= 0 && dc < N && map[dr][dc] == map[a][b] + 1) {							
							cnt[i][j]++;
							a = dr;
							b = dc;
							k = 0;
						}
					}
				}
			}
			// cnt 최대값 구하기
			for (int i = 0; i < cnt.length; i++) {
				for (int j = 0; j < cnt[i].length; j++) {
					max = Math.max(max, cnt[i][j]);
				}
			}
			// 최소값일때 max!!!!!!!!! 추가해주기	
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					// 시작하는 수가 제일 작은 값이고 
					if (cnt[i][j] == max && start > map[i][j]) {
						start = map[i][j];
					}
				}
			}
			
			System.out.printf("#%d %d %d\n", tc, start, max);
		}

	}

}
