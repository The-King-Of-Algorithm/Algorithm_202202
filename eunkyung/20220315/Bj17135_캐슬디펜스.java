package day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Bj17135_캐슬디펜스 {
	static int N, M, D, max = 0;
	static ArrayList<Point> list = new ArrayList<>();

	static class Point implements Comparable<Point> {
		int r, c;
		int dist;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", dist=" + dist +"]";
		}

		@Override
		public int compareTo(Point o) {
			if (this.dist == o.dist) {
				return this.c - o.c;
			}
			return this.dist - o.dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					list.add(new Point(i, j));
				}
			}
		}
		combination(new int[3], 0, 0);
		System.out.println(max);

	}

	private static void combination(int[] sel, int start, int k) {
		if (k == sel.length) {
			operation(sel);
			return;
		}

		for (int i = start; i < M; i++) {
			sel[k] = i;
			combination(sel, i + 1, k + 1);
		}

	}

	private static void operation(int[] sel) {
		ArrayList<Point> tmplist = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			tmplist.add(new Point(list.get(i).r, list.get(i).c));
		}
		int cnt = 0;

		while (!tmplist.isEmpty()) {
			ArrayList<Point> die = new ArrayList<>();

			// 죽일 수 있는지 검사
			for (int current = 0; current < sel.length; current++) {
				for (int i = 0; i < tmplist.size(); i++) {
					tmplist.get(i).dist = getdistance(N, sel[current], tmplist.get(i).r, tmplist.get(i).c);
				}
				Collections.sort(tmplist);
				if (tmplist.get(0).dist <= D && !die.contains(tmplist.get(0))) {
					die.add(tmplist.get(0));
				}
			}
			// 궁수가 죽일 수 있는 애들 죽이기
			if (!die.isEmpty()) {
				Collections.sort(die);
				cnt += die.size();

				for (int i = 0; i < die.size(); i++) {
					tmplist.remove(die.get(i));
				}
			}

			// 적 위치 옮기기
			for (int i = tmplist.size() - 1; i >= 0; i--) {
				if (tmplist.get(i).r + 1 < N)
					tmplist.get(i).r = tmplist.get(i).r + 1;
				else
					tmplist.remove(i);
			}
		}
		max = Math.max(max, cnt);

	}

	private static int getdistance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
}
