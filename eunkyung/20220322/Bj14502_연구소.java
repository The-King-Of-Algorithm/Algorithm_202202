package day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj14502_연구소 {
	static class Point {
		int r, c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}

	static int N, M, max = 0;
	static ArrayList<Point> list = new ArrayList<Point>();
	static ArrayList<Point> virus = new ArrayList<Point>();
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) list.add(new Point(i, j));
				if (map[i][j] == 2) virus.add(new Point(i, j));
			}
		}
		combination(new Point[3], 0, 0);
		System.out.println(max);
	}

	private static void combination(Point[] sel, int idx, int k) {
		if (k == sel.length) {
			operation(sel);
			return;
		}
		for (int i = idx; i < list.size(); i++) {
			sel[k] = list.get(i);
			combination(sel, i + 1, k + 1);
		}
	}

	private static void operation(Point[] sel) {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < sel.length; i++) {
			tmp[sel[i].r][sel[i].c] = 1;
		}
		for (int i = 0; i < virus.size(); i++) {
			bfs(tmp, virus.get(i).r, virus.get(i).c);
		}
		int cnt = 0;
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {
				if (tmp[i][j] == 0) cnt++;
			}
		}
		max = Math.max(max, cnt);
	}

	private static void bfs(int[][] tmp, int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c));

		while (!q.isEmpty()) {
			Point current = q.poll();
			for (int d = 0; d < dx.length; d++) {
				int nr = current.r + dx[d];
				int nc = current.c + dy[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && tmp[nr][nc] == 0) {
					q.offer(new Point(nr, nc));
					tmp[nr][nc] = 2;
				}
			}
		}
	}
//	private static void print(int[][] tmp) {
//		for (int i = 0; i < tmp.length; i++) {
//			for (int j = 0; j < tmp[i].length; j++) {
//				System.out.print(tmp[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
}
