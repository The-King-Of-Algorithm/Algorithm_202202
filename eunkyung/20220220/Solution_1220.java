package day11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1220 {
//마그네틱
	static int[] dx = { 0, 1, -1 };
	static int[] dy = { 0, 0, 0 };
	static int[][] map;
	static int N, d, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/day11/Magnetic.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(bf.readLine());
			map = new int[N][N];
			cnt = 0;
			for (int i = 0; i < map.length; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (map[i][j] == 1) {
						d = 1;
						checkN(i, j);
					} else if (map[i][j] == 2) {
						d = 2;
						checkS(i, j);
					}

				}
			}
			System.out.println("#" + tc + " " + cnt);

		}
	}

	private static void checkS(int r, int c) {
		int n = 1;
		while (true) {
			int nr = r + dx[d] * n;
			int nc = c + dy[d] * n;

			if (isMap(nr, nc) && map[nr][nc] != 2) {
				if (map[nr][nc] == 1) {
					map[r][c] = 3;
					map[nr][nc] = 3;
					cnt++;
					break;
				} else {
					n++;
				}

			} else {// 맵 밖으로 나간 경우나 같은 자성체
				map[r][c] = 0;
				break;
			}
		}
	}

	private static void checkN(int r, int c) {
		int n = 1;
		while (true) {
			int nr = r + dx[d] * n;
			int nc = c + dy[d] * n;

			if (isMap(nr, nc) && map[nr][nc] != 1) {
				if (map[nr][nc] == 2) {
					map[r][c] = 3;
					map[nr][nc] = 3;
					cnt++;
					break;
				} else {
					n++;
				}

			} else {// 맵 밖으로 나간 경우나 같은 자성체
				map[r][c] = 0;
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

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
