package day11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇이동거리 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/day11/로봇이동거리.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(bf.readLine());
			String[][] map = new String[N][N];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j].equals("A")) {
						robotA(map, i, j);
					} else if (map[i][j].equals("B")) {
						robotB(map, i, j);
					} else if (map[i][j].equals("C")) {
						robotC(map, i, j);
					}
				}
			}

			System.out.println("#" + tc + " " + cnt);
			//print(map);

		}
	}

	private static void robotC(String[][] map, int r, int c) {
		for (int d = 0; d < dx.length; d++) {
			int n = 1;
			while (true) {
				int nr = r + dx[d] * n;
				int nc = c + dy[d] * n;
				if (isMap(nr, nc) && map[nr][nc].equals("S")) {
					cnt++;
				} else {
					break;
				}
				n++;
			}
		}
	}

	private static void robotB(String[][] map, int r, int c) {
		for (int d = 2; d < dx.length; d++) {
			int n = 1;
			while (true) {
				int nr = r + dx[d] * n;
				int nc = c + dy[d] * n;
				if (isMap(nr, nc) && map[nr][nc].equals("S")) {
					cnt++;
				} else {
					break;
				}
				n++;
			}
		}
	}

	private static void robotA(String[][] map, int r, int c) {
		while (true) {
			int nr = r + dx[3];
			int nc = c + dy[3];
			if (isMap(nr, nc) && map[nr][nc].equals("S")) {
				cnt++;
				r = nr;
				c = nc;
			} else {
				break;
			}
		}
	}

	private static boolean isMap(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
			return true;
		}
		return false;
	}

	private static void print(String[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
