package day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//빵집
public class Baek_3109 {
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };
	static char[][] map;
	static boolean[][] v;
	static int max = 0;
	static boolean state;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		v = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = bf.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			state = false;
			dfs(i, 0);
		}

		System.out.println(max);
	}

	private static void dfs(int r, int c) {
		if (c == map[0].length - 1) {
			max++;
			state = true;
			return;
		}
		for (int d = 0; d < dx.length; d++) {
			int nr = r + dx[d];
			int nc = c + dy[d];
			if (isMap(nr, nc) && map[nr][nc] == '.' && !v[nr][nc] && !state) {
				v[nr][nc] = true;
				dfs(nr, nc);
			}
		}
	}

	private static boolean isMap(int nr, int nc) {
		if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length) {
			return true;
		}
		return false;
	}
}
