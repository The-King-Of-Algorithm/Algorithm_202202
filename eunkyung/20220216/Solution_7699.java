package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//수지의 수지 맞는 여행
public class Solution_7699 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			char[][] map = new char[R][C];
			boolean[] v = new boolean[26];
			max = 0;

			for (int i = 0; i < R; i++) {
				String str = bf.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			v[map[0][0] - 'A'] = true;
			dfs(map, v, 0, 0, 1);
			//print(map);
			System.out.println("#"+tc+" "+max);
		}
	}
	private static void dfs(char[][] map, boolean[] v, int r, int c, int cnt) {
		for (int d = 0; d < dx.length; d++) {
			int nr = r + dx[d];
			int nc = c + dy[d];
			if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length) {
				if (!v[map[nr][nc] - 'A']) {
					v[map[nr][nc] - 'A'] = true;
					dfs(map, v, nr, nc, cnt + 1);
					v[map[nr][nc] - 'A'] = false;
				}
			}
		}
		max = Math.max(max, cnt);
	}

	private static void print(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
