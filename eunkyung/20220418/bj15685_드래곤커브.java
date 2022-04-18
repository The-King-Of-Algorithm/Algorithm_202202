package day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj15685_드래곤커브 {
	static int a = 101;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int[][] map = new int[a][a];

	static class Point {
		int x, y, dx, dy, d, g;

		public Point(int x, int y, int dx, int dy, int d) {
			super();
			this.x = x;
			this.y = y;
			this.dx = dx;
			this.dy = dy;
			this.d = d;
		}

		public Point(int x, int y, int d, int g) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.g = g;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", dx=" + dx + ", dy=" + dy + ", d=" + d + ", g=" + g + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			ArrayList<Point> list = new ArrayList<>();
			list.add(new Point(x, y, (d + 1) % 4, g));
			list.get(0).dx = x + dx[d];
			list.get(0).dy = y + dy[d];
			dfs(list, 0, 0, g);
		}

		int cnt=0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j] != 1) continue;
				if (i + 1 >= a || map[i + 1][j] != 1) continue;
				if (i + 1 >= a || j + 1 >= a || map[i + 1][j + 1] != 1) continue;
				if (j + 1 >= a || map[i][j + 1] != 1) continue;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void dfs(ArrayList<Point> list, int idx, int cnt, int g) {
		if (cnt == g) {
			for (int i = 0; i < list.size(); i++) {
				int nr = list.get(i).x;
				int nc = list.get(i).y;
				if (nr >= 0 && nr < a && nc >= 0 && nc < a) {
					map[nc][nr] = 1;
				}
			}
			int nr = list.get(list.size() - 1).dx;
			int nc = list.get(list.size() - 1).dy;
			if (nr >= 0 && nr < a && nc >= 0 && nc < a) {
				map[nc][nr] = 1;
			}

			return;
		}

		int sr = list.get(list.size() - 1).dx;
		int sc = list.get(list.size() - 1).dy;
		for (int i = list.size() - 1; i >= 0; i--) {
			Point current = list.get(i);
			list.add(new Point(sr, sc, sr + dx[current.d], sc + dy[current.d], (current.d + 1) % 4));
			sr += dx[current.d];
			sc += dy[current.d];
		}
		dfs(list, 0, cnt + 1, g);
	}
}
