package day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj17070_파이프옮기기1 {
	static int[] dx = { 0, 1, 1 }; // 우 하 대
	static int[] dy = { 1, 0, 1 };
	static int[][][] dir = { { { 0 }, { 0, 1, 2 } }, { { 1 }, { 0, 1, 2 } }, { { 0 }, { 1 }, { 0, 1, 2 } } };
	static int[][] map;
	static int N, cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];

		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 1, 0);
		System.out.println(cnt);
	}

	private static void dfs(int r, int c, int D) {
		if (r == N - 1 && c == N - 1) {
			cnt++;
			return;
		}
		for (int d = 0; d < dir[D].length; d++) {
			boolean state = true;
			int sr = 0;
			int sc = 0;

			for (int nd = 0; nd < dir[D][d].length; nd++) {
				int nr = r + dx[dir[D][d][nd]];
				int nc = c + dy[dir[D][d][nd]];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 0) {
					sr = nr;
					sc = nc;
				} else {
					state = false;
					break;
				}
			}
			if (state) {
				dfs(sr, sc, dir[D][d][dir[D][d].length - 1]);
			}
		}

	}
//	private static void print(int[][] map) {
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
}
