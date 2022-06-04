package day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1865_동철이의일분배 {
	static int N;
	static double[][] per, memo;
	static double max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(bf.readLine());
			per = new double[N][N];
			max = 0;
			// memo = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					per[i][j] = Integer.parseInt(st.nextToken()) / 100.0;
				}
			}
			for (int i = 0; i < N; i++) {
				boolean[] v = new boolean[N];
				v[i] = true;
				dfs(v, 1, per[0][i]);
			}

			double Ans = max * 100;
			System.out.printf("#%d %.6f\n", tc, Ans);
		}

	}

	private static void dfs(boolean[] v, int index, double sum) {
		if (sum <= max) {
			return;
		}
		if (index == N) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				v[i] = true;
				dfs(v, index + 1, sum * per[index][i]);
				v[i] = false;
			}
		}

	}

	private static void print(double[][] per) {
		for (int i = 0; i < per.length; i++) {
			for (int j = 0; j < per.length; j++) {
				System.out.print(per[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
