package hw_20220209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_15652 {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		select(new int[M], 0, 0);
	}

	private static void select(int[] sel, int start, int k) {
		if (k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + 1 + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < N; i++) {
			sel[k] = i;
			select(sel, i, k + 1);
		}
	}

}
