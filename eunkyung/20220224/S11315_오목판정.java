package day08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class S11315_오목판정 {
	static int[] dx = { 0, 1, 1, 1 };
	static int[] dy = { 1, 0, 1, -1 };
	static boolean flag = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/day08/오목판정.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(bf.readLine());
			char[][] map = new char[N][N];
			flag = false;

			for (int i = 0; i < map.length; i++) {
				map[i] = bf.readLine().toCharArray();
			}

			outer: for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == 'o') {
						if (check(map, i, j)) {
							break outer;
						}
					}
				}
			}
			if (flag) {
				System.out.println("#" + tc + " YES");
			} else {
				System.out.println("#" + tc + " NO");
			}
		}
	}

	private static boolean check(char[][] map, int r, int c) {
		for (int d = 0; d < dx.length; d++) {
			int cnt = 1;
			int n = 1;
			while (true) {
				int nr = r + dx[d] * n;
				int nc = c + dy[d] * n;
				if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && map[nr][nc] == 'o') {
					cnt++;
					n++;
				} else
					break;
			}
			if (cnt >= 5) {
				flag = true;
				return true;
			}
		}
		return false;
	}
}
