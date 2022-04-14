package day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj9205_맥주마시면서걸어가기 {
	static class Point {
		int r, c, d;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}

	static int dR, dC;
	static boolean flag = false;
	static Point[] place;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(bf.readLine());
			place = new Point[N + 1];
			flag = false;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			for (int i = 0; i < place.length; i++) {
				st = new StringTokenizer(bf.readLine());
				place[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			dR = place[N].r;
			dC = place[N].c;

			boolean[] v = new boolean[N + 1];
			dfs(R, C, v);

			System.out.println(flag ? "happy" : "sad");
		}

	}

	private static void dfs(int r, int c, boolean[] v) {
		if (r == dR && c == dC) {
			flag = true;
			return;
		}
		if (!flag) {
			for (int i = 0; i < place.length; i++) {
				if (!v[i] && Math.abs(r - place[i].r) + Math.abs(c - place[i].c) <= 1000) {
					v[i] = true;
					dfs(place[i].r, place[i].c, v);
				}
			}
		}
	}
}
