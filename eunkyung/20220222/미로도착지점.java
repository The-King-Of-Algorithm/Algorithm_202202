package day06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미로도착지점 {
	static int[] dx = { 0, -1, 0, 1, 0 };
	static int[] dy = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/day06/미로도착지점.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int n = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];

			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < n; i++) {
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				map[x][y] = 1;
			}
			// print(map);

			int M = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());

			outer: for (int i = 0; i < M; i++) {
				int d = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				for (int cnt = 0; cnt < count; cnt++) {
					int nr = r + dx[d];
					int nc = c + dy[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 1) {
						map[nr][nc] = 2;
						r = nr;
						c = nc;
					} else {
						r = -1;
						c = -1;
						break outer;
					}
				}
			}
			//print(map);

			System.out.println("#" + tc + " " + (r + 1) + " " + (c + 1));

		}
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
