package day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj2096_내려가기 {
	static int N, max = 0, min = Integer.MAX_VALUE;
	static int[][] map, tmp;
	// static int[] dx = { 1, 1, 1 };// 아래로만 내려감
	static int[] dy = { -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][3];
		tmp = new int[N][3];

		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < tmp.length; i++) {
			Arrays.fill(tmp[i], -1);
		}

		for (int i = 0; i < 3; i++) {
			max = Math.max(max, dfs(0, i));
		}
		for (int i = 0; i < tmp.length; i++) {
			Arrays.fill(tmp[i], -1);
		}

		for (int i = 0; i < 3; i++) {
			min = Math.min(min, dfs2(0, i));
		}
		System.out.println(max + " " + min);
	}

	private static int dfs2(int r, int c) {
		if (tmp[r][c] != -1) return tmp[r][c];

		int small = Integer.MAX_VALUE;
		tmp[r][c] = map[r][c];
		for (int d = 0; d < dy.length; d++) {
			int nr = r + 1;
			int nc = c + dy[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < 3) {
				small = Math.min(small, dfs2(nr, nc));
			}
		}
		if (small != Integer.MAX_VALUE) tmp[r][c] += small;

		return tmp[r][c];
	}

	private static int dfs(int r, int c) {
		if (tmp[r][c] != -1) return tmp[r][c];

		int big = 0;
		tmp[r][c] = map[r][c];
		for (int d = 0; d < dy.length; d++) {
			int nr = r + 1;
			int nc = c + dy[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < 3) {
				big = Math.max(big, dfs(nr, nc));
			}
		}
		tmp[r][c] += big;

		return tmp[r][c];
	}

	private static void print(int[][] map2) {
		for (int i = 0; i < map2.length; i++) {
			for (int j = 0; j < map2.length; j++) {
				System.out.print(map2[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
