package day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2578_빙고 {
	static int[][] map;
	static int cnt;
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int[][] dir = { { 0, 7 }, { 1, 6 }, { 2, 5 }, { 3, 4 } };

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5];

		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;
		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map.length; j++) {
				int n = Integer.parseInt(st.nextToken());
				count++;
				int[] point = find(n);
				map[point[0]][point[1]] = 0;
				checkBingo(point[0], point[1]);
				if (cnt >= 3) {
					System.out.println(count);
					return;
				}
			}
		}

	}

	private static void checkBingo(int r, int c) {
		for (int d = 0; d < dir.length; d++) {
			int sum = 0;
			for (int nd = 0; nd < dir[d].length; nd++) {
				int n = 1;
				while (true) {
					int nr = r + dx[dir[d][nd]] * n;
					int nc = c + dy[dir[d][nd]] * n;
					if (nr >= 0 && nr < map.length && nc >= 0 && nc < map.length && map[nr][nc] == 0) {
						n++;
					} else
						break;
				}
				sum += n;
			}
			if (sum - 1 == 5) {
				cnt++;
			}
		}
	}

	private static int[] find(int n) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == n) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}
}
