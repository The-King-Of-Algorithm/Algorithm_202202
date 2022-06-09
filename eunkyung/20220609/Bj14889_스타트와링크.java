package day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj14889_스타트와링크 {
	static int N, min = Integer.MAX_VALUE;
	static int[][] score;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		score = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		combination(new boolean[N], 0, 0);
		System.out.println(min);
	}

	private static void combination(boolean[] v, int index, int k) {
		if (k == N / 2) {
			if (!v[0])
				return;
			// System.out.println(Arrays.toString(v));
			operation(v);
			return;
		}

		for (int i = index; i < N; i++) {
			v[i] = true;
			combination(v, i + 1, k + 1);
			v[i] = false;
		}
	}

	private static void operation(boolean[] v) {
		int sum_a = 0;
		int sum_b = 0;
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v.length; j++) {
				if (v[i] == v[j] && v[i]) {
					sum_a += score[i][j];
				}
				if (v[i] == v[j] && !v[i]) {
					sum_b += score[i][j];
				}
			}
		}

		min = Math.min(min, Math.abs(sum_a - sum_b));
	}
}
