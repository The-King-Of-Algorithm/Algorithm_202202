package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2468 {
//안전 영역
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] map;

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		int max_cnt = 0;
		int min = 987654321;
		int max = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}

		for (int n = min - 1; n <= max; n++) {
			int cnt = 0;
			boolean[][] v = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > n && !v[i][j]) {
						bfs(i, j, v, n);
						cnt++;
					}
				}
			}
			max_cnt = Math.max(cnt, max_cnt);
			// print(map);

		}
		System.out.println(max_cnt);
	}

	private static void bfs(int r, int c, boolean[][] v, int n) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(r, c));
		v[r][c] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < dx.length; d++) {
				int nr = p.x + dx[d];
				int nc = p.y + dy[d];

				if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length) {
					if (map[nr][nc] > n && !v[nr][nc]) {
						v[nr][nc] = true;
						q.offer(new Point(nr, nc));
					}
				}
			}
		}
	}

	private static void print(int[][] v2) {
		System.out.println();
		for (int i = 0; i < v2.length; i++) {
			for (int j = 0; j < v2[i].length; j++) {
				System.out.print(v2[i][j]);
			}
			System.out.println();
		}
	}

}
