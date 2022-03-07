package day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW4613_러시아국기같은깃발 {
	static int N, M, res;
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			int cnt = 0;
			res = Integer.MAX_VALUE;
			for (int i = 0; i < map.length; i++) {
				String str = bf.readLine();
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			for (int i = 0; i < M; i++) {
				if (map[0][i] != 'W')
					cnt++;
			}
			for (int i = 0; i < M; i++) {
				if (map[N - 1][i] != 'R')
					cnt++;
			}
			dfs(1, 'W', cnt);
			dfs(1, 'B', cnt);

			System.out.println("#" + tc + " " + res);

		}

	}

	private static void dfs(int idx, char color, int cnt) {
		if (idx == N - 1) {
			res = Math.min(res, cnt);
			return;
		}

		for (int i = 0; i < M; i++) {
			if (map[idx][i] != color) {
				cnt++;
			}
		}

		if (color == 'W') {
			if (idx + 1 != N - 2)
				dfs(idx + 1, 'W', cnt);
			dfs(idx + 1, 'B', cnt);
		} else if (color == 'B') {
			dfs(idx + 1, 'B', cnt);
			dfs(idx + 1, 'R', cnt);
		} else if (color == 'R')
			dfs(idx + 1, 'R', cnt);
	}
}
