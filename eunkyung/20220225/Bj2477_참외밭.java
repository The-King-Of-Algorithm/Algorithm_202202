package day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Bj2477_참외밭 {
	static class Point implements Comparable<Point> {
		int r, c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public int compareTo(Point o) {
			if (this.r == o.r) {
				return this.c - o.c;
			}
			return this.r - o.r;
		}
	}

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(bf.readLine());
		ArrayList<Point> point = new ArrayList<>();
		Point[][] arr = new Point[3][2];

		int x = 500;
		int y = 500;

		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			point.add(new Point(x = x + (dx[d - 1] * w), y = y + (dy[d - 1] * w)));
		}
		Collections.sort(point);
		int n = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = point.get(n++);
			}
		}
		int m = 0;
		int a1 = Math.abs(arr[0][0].c - arr[0][1].c);
		int a2 = Math.abs(arr[2][0].c - arr[2][1].c);

		m += a1 * (arr[1][0].r - arr[0][0].r);
		m += a2 * (arr[2][0].r - arr[1][0].r);
		System.out.println(m * K);
	}
}
