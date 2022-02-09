package edu.ssafy.chap04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_3_1 {
//	static int N, M;
//	static int[] n, sel;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] n = new int[N];
		int[] sel = new int[M];

		for (int i = 0; i < N; i++) {
			n[i] = i + 1;
		}

		permutation(n, sel, 0);
		System.out.println(sb);
	}

	private static void permutation(int[] n, int[] sel, int k) {

		if (k == sel.length) {
			for (int i : sel) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n.length; i++) {
			sel[k] = n[i];
			permutation(n, sel, k + 1);
		}
	}

}
