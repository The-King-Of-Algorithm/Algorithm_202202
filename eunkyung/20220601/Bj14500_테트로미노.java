package day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj14500_테트로미노 {
	static int N, M, max = 0;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][] v = new boolean[N][M];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				v[i][j] = true;
				dfs(i, j, v, 1, map[i][j]);
				v[i][j] = false;
				operation(i, j, map[i][j]);
			}
		}
		System.out.println(max);
	}

	private static void operation(int r, int c, int sum) {
		if (r + 1 < N && c + 2 < M)
			max = Math.max(max, sum + map[r][c + 1] + map[r][c + 2] + map[r + 1][c + 1]);
		if (r - 1 >= 0 && c + 2 < M)
			max = Math.max(max, sum + map[r][c + 1] + map[r][c + 2] + map[r - 1][c + 1]);
		if (r + 2 < N && c + 1 < M)
			max = Math.max(max, sum + map[r + 1][c] + map[r + 2][c] + map[r + 1][c + 1]);
		if (r + 2 < N && c - 1 >= 0)
			max = Math.max(max, sum + map[r + 1][c] + map[r + 2][c] + map[r + 1][c - 1]);
	}

	private static void dfs(int r, int c, boolean[][] v, int k, int sum) {
		if (k == 4) {
			max = Math.max(max, sum);
			return;
		}
		for (int d = 0; d < dx.length; d++) {
			int nr = r + dx[d];
			int nc = c + dy[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc]) {
				v[nr][nc] = true;
				dfs(nr, nc, v, k + 1, sum + map[nr][nc]);
				v[nr][nc] = false;
			}
		}
	}
}
