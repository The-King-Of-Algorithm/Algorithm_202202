package day07;

import java.util.Scanner;
//자리배정
public class Baek_10157 {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int C, R, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		R = sc.nextInt();
		K = sc.nextInt();
		int[][] map = new int[R][C];

		if (R * C < K) {
			System.out.println(0);
		} else {
			f(map, 0, 0, 0);
		}

	}

	private static void f(int[][] map, int r, int c, int d) {
		map[r][c] = 1;
		int cnt = 1;
		while (d < 4) {
			if (cnt == K) {
				System.out.println((c + 1) + " " + (r + 1));
				break;
			}
			int nr = r + dx[d];
			int nc = c + dy[d];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 0) {
				map[nr][nc] = ++cnt;
				r = nr;
				c = nc;
			} else {
				if (d == 3)
					d = 0;
				else
					d++;
			}
		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
