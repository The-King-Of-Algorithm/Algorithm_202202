package hw_20220209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_15654 {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		select(arr, new int[M], new boolean[N], 0);
	}

	private static void select(int[] arr, int[] sel, boolean[] v, int k) {
		if (k == M) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i] + " ");
			}
			System.out.println(sb);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (v[i] == false) {
				v[i] = true;
				sel[k] = arr[i];
				select(arr, sel, v, k + 1);
				v[i] = false;
			}
		}
	}

}
