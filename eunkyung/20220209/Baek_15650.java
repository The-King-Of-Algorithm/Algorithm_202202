package hw_20220209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_15650 {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		select(new boolean[N], 0, 0);
	}

	private static void select(boolean[] v, int start, int k) {
		if (k == M) {
			for (int i = 0; i < v.length; i++) {
				if (v[i]) {
					System.out.print(i + 1 + " ");
				}
			}
			System.out.println();
			return;
		}

		for (int i = start; i < N; i++) {
			if (v[i] == false) {
				v[i] = true;
				select(v, i + 1, k + 1);
				v[i] = false;
			}
		}
	}
}
