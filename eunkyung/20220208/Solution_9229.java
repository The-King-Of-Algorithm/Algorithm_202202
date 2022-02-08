package hw_20220208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229 {
	static int max;
	static int M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int[] w = new int[N];
			max = 0;
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < N; i++) {
				w[i] = Integer.parseInt(st.nextToken());
			}

			select(w, new int[2], 0, 0);
			if (max == 0) {
				max = -1;
			}
			System.out.println("#" + test_case + " " + max);
		}
	}

	private static void select(int[] w, int[] sel, int start, int k) {
		if (k == sel.length) {
			int sum = sel[0] + sel[1];
			if (sum <= M) {
				max = Math.max(max, sum);
			}
			return;
		}
		for (int i = start; i < w.length; i++) {
			sel[k] = w[i];
			select(w, sel, i + 1, k + 1);
		}
	}
}
