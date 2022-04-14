package day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW1767_프로세서연결하기 {
	static int N, max, min;
	static int[][] cell;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static ArrayList<int[]> core;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(bf.readLine());
			cell = new int[N][N];
			max = 0;
			min = Integer.MAX_VALUE;
			core = new ArrayList<int[]>();
			for (int i = 0; i < cell.length; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < cell.length; j++) {
					cell[i][j] = Integer.parseInt(st.nextToken());
					if (cell[i][j] == 1 && i >= 1 && i < N - 1 && j >= 1 && j < N - 1) {
						core.add(new int[] { i, j });
					}
				}
			}

			// print(cell);

			boolean[] v = new boolean[core.size()];
			dfs(cell, v, 0, 0, 0);
			// System.out.println("#" + tc + " " + max);
			System.out.println("#" + tc + " " + min);
		}
	}

	private static void dfs(int[][] cell, boolean[] v, int i, int ccnt, int csum) {

		//print(cell);
		if (i == core.size()) {
			//System.out.println("------------");
			//print(cell);
			if (max < ccnt) {
				max = ccnt;
				min = csum;
			}
			if (max == ccnt) {
				min = Math.min(min, csum);
			}
			return;
		}
		// for (int i = idx; i < core.size(); i++) {
		// if (!v[i]) {
		boolean state = false;
		int[] c = core.get(i);
		for (int d = 0; d < dx.length; d++) {
			int cnt = check(c[0], c[1], d, cell);
			if (cnt > 0) {
				// v[i] = true;
				int[][] tmp = copymap(cell);
				int nr = c[0], nc = c[1];
				while (true) {
					nr += dx[d];
					nc += dy[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N)
						break;
					tmp[nr][nc] = 1;
				}
				state = true;
				dfs(tmp, v, i + 1, ccnt + 1, csum + cnt);
				// v[i] = false;
			}
		}
		// }
		// }
		if (!state)
			dfs(cell, v, i + 1, ccnt, csum);
	}

	private static int[][] copymap(int[][] cell) {
		int[][] tmp = new int[N][N];
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp.length; j++) {
				tmp[i][j] = cell[i][j];
			}
		}
		return tmp;
	}

	private static int check(int r, int c, int d, int[][] map) {
		int cnt = 0;
		while (true) {
			r += dx[d];
			c += dy[d];
			cnt++;
			if (r < 0 || r >= N || c < 0 || c >= N)
				return cnt - 1;
			if (map[r][c] == 1)
				return 0;
		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
