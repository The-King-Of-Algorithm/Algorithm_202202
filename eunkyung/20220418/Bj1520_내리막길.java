package day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1520_내리막길 {
	static int M, N, cnt = 0;
	static int[][] map, tmp;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
//	  0
//	3  1
//	 2

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		tmp = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // 산 지형 입력 받음
			}
		}

		for (int i = 0; i < tmp.length; i++) {
			Arrays.fill(tmp[i], -1);
		}

		print(map);
		print(tmp);

		tmp[M - 1][N - 1] = 1;
		System.out.println(dfs(0, 0));
		print(tmp);
	}

	private static long dfs(int r, int c) {
//		if (M - 1 == r && c == N - 1) {
//			return 1;
//		}
		if (tmp[r][c] != -1) {
			return tmp[r][c];
		}

		tmp[r][c] = 0;
		for (int d = 0; d < dx.length; d++) {
			int nr = r + dx[d];
			int nc = c + dy[d];
			if (nr >= 0 && nr < M && nc >= 0 && nc < N && map[r][c] > map[nr][nc]) {
				tmp[r][c] += dfs(nr, nc);
			}
		}
		return tmp[r][c];
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
