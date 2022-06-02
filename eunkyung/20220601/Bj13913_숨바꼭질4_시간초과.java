package day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj13913_숨바꼭질4_시간초과 {
	static int s = 100001;

	static class Point {
		int n, c;
		ArrayList<Integer> list = new ArrayList<Integer>();

		public Point(int n, int c) {
			super();
			this.n = n;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		bfs(N, K);
	}

	private static void bfs(int n, int k) {
		Queue<Point> q = new LinkedList<Point>();
		boolean[] v = new boolean[s];
		Point point = new Point(n, 0);
		point.list.add(n);
		q.offer(point);
		v[n] = true;

		while (!q.isEmpty()) {
			Point current = q.poll();
			if (current.n == k) {
				System.out.println(current.c);
				for (int i = 0; i < current.list.size(); i++) {
					System.out.print(current.list.get(i) + " ");
				}
				break;
			}

			if (current.n - 1 >= 0 && current.n - 1 < s && !v[current.n - 1]) {
				v[current.n - 1] = true;
				Point p = new Point(current.n - 1, current.c + 1);
				p.list.addAll(current.list);
				p.list.add(current.n - 1);
				q.offer(p);
			}
			if (current.n + 1 >= 0 && current.n + 1 < s && !v[current.n + 1]) {
				v[current.n + 1] = true;
				Point p = new Point(current.n + 1, current.c + 1);
				p.list.addAll(current.list);
				p.list.add(current.n + 1);
				q.offer(p);
			}
			if (current.n * 2 >= 0 && current.n * 2 < s && !v[current.n * 2]) {
				v[current.n * 2] = true;
				Point p = new Point(current.n * 2, current.c + 1);
				p.list.addAll(current.list);
				p.list.add(current.n * 2);
				q.offer(p);
			}

		}
	}
}



