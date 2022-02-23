package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
//치킨배달
public class Baek_15686 {
	static class rc {
		int r;
		int c;

		public rc(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "rc [r=" + r + ", c=" + c + "]";
		}

	}

	static List<rc> home, chicken;
	static int N, M, res = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chicken = new ArrayList<>();
		home = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1) {
					home.add(new rc(i, j));
				} else if (n == 2) {
					chicken.add(new rc(i, j));
				}
			}
		}

		combination(new int[M][2], 0, 0);
		System.out.println(res);

	}

	private static void combination(int[][] sel, int idx, int k) {
		if (k == M) {
			operation(sel);
			return;
		}

		for (int i = idx; i < chicken.size(); i++) {
			sel[k][0] = chicken.get(i).r;
			sel[k][1] = chicken.get(i).c;
			combination(sel, i + 1, k + 1);
		}

	}

	private static void operation(int[][] sel) {
		int sum = 0;
		for (int i = 0; i < home.size(); i++) {
			int[] min = new int[] { Integer.MAX_VALUE, 0 };
			for (int j = 0; j < sel.length; j++) {
				int dist = Math.abs(home.get(i).r - sel[j][0]) + Math.abs(home.get(i).c - sel[j][1]);
				if (dist < min[0]) {
					min[0] = dist;
					min[1] = j;
				}
			}
			sum += min[0];
		}
		res = Math.min(res, sum);
	}
}
