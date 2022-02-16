package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1012 {
//유기농배추
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] v;
	static int[][] map;
	static int cnt = 0;

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
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			v = new boolean[N][M];
			cnt = 0;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(bf.readLine());
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == 1 && !v[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			//print(map);
			System.out.println(cnt);
		}
	}

	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(r, c));
		v[r][c] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < dx.length; d++) {
				int nr = p.x + dx[d];
				int nc = p.y + dy[d];

				if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length) {
					if (map[nr][nc] == 1 && !v[nr][nc]) {
						q.offer(new Point(nr, nc));
						v[nr][nc] = true;
					}
				}
			}
		}

	}

//	private static void print(int[][] map) {
//		//System.out.println();
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//	}

}
