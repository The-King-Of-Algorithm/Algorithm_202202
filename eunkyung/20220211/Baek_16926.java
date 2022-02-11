package day07;

import java.util.Scanner;
//배열 돌리기1
public class Baek_16926 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] map;
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int R = sc.nextInt();
		int min = Math.min(N, M) / 2;

		map = new int[N][M];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < R; i++) {
			rotate(min);
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void rotate(int min) {
		for (int i = 0; i < min; i++) {
			int dir = 0;// 이동방향변수
			int sr = i;
			int sc = i;// 시작 위치
			int tmp = map[sr][sc]; // 첫번째 값 저장

			while (dir < 4) {
				int nr = sr + dx[dir];
				int nc = sc + dy[dir];

				// 경계값 체크
				if (nr >= i && nr < N - i && nc >= i && nc < M - i) {
					map[sr][sc]=map[nr][nc];
					sr = nr;
					sc = nc; // 현재 위치 변경
				} else { // 경계선 밖이면 방향 변경
					dir++;
				}
			}
			map[i + 1][i] = tmp;
		}
	}
}
