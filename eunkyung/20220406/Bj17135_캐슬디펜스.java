package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Bj17135_캐슬디펜스 {
	static class Point implements Comparable<Point> {
		int r, c, d;

		public Point(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", d=" + d + "]";
		}

		@Override
		public int compareTo(Point o) {
			if (this.d == o.d) {
				return this.c - o.c;
			}
			return this.d - o.d;
		}

	}

	static int N, M, D, max = 0;
	static int[][] map;
	static ArrayList<Point> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					list.add(new Point(i, j, 0));
			}
		}
		//System.out.println(list);
	//	print(map);

		combination(new int[3], 0, 0);
		System.out.println(max);
	}

	private static void combination(int[] sel, int idx, int k) {
		if (k == sel.length) {
			//System.out.println(Arrays.toString(sel));
			operation(sel);
			return;
		}
		for (int i = idx; i < M; i++) {
			sel[k] = i;
			combination(sel, i + 1, k + 1);
		}
	}

	private static void operation(int[] sel) {
		ArrayList<Point> tmp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			tmp.add(new Point(list.get(i).r, list.get(i).c, 0));
		}
		
		int cnt = 0;
		while (!tmp.isEmpty()) {
			ArrayList<Point> die = new ArrayList<>();
			for (int i = 0; i < sel.length; i++) {
				for (int j = 0; j < tmp.size(); j++) {
					Point current = tmp.get(j);
					current.d = Math.abs(current.r - N) + Math.abs(current.c - sel[i]);
				}
				Collections.sort(tmp);
				//System.out.println("$$"+tmp);
				for (int j = 0; j < tmp.size(); j++) {
					Point current = tmp.get(j);
					if (current.d <= D) {
						if (!die.contains(current))
							die.add(current);
						break;
					}
				}
				//System.out.println(die);
			}
			cnt += die.size();
			for (int j = 0; j < die.size(); j++) {
				tmp.remove(die.get(j));
			}
			//System.out.println("#1" + tmp);
			for (int i = tmp.size() - 1; i>=0; i--) {
				if (tmp.get(i).r + 1 < N) tmp.get(i).r++;
				else tmp.remove(i);
				
			}
			//System.out.println("#2" + tmp);

		}
		//System.out.println(cnt);
		max = Math.max(max, cnt);
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
