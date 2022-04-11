package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1937_욕심쟁이판다 {
	static int N, max = 0, count = 0;
	static int[][] map;
	static int[][] tmp;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		tmp = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				max = Math.max(max, dfs(i, j));
			}
		}
		//print(tmp);
		System.out.println(max);
	//	System.out.println(count);
	}

	private static int dfs(int r, int c) {
		if (tmp[r][c] != 0)
			return tmp[r][c];

		tmp[r][c] = 1;

		for (int d = 0; d < dx.length; d++) {
			int nr = r + dx[d];
			int nc = c + dy[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[r][c] < map[nr][nc]) {
				//count++;
				tmp[r][c] = Math.max(tmp[r][c], dfs(nr, nc) + 1);
				print(tmp);
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
