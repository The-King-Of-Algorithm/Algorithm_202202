package edu.ssafy.chap04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_3 {
	static int N, M;
	static int[] n, sel;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		n = new int[N];
		sel = new int[M];

		for (int i = 0; i < N; i++) {
			n[i] = i + 1;
		}

		permutation(0);
		System.out.println(sb);
	}

	private static void permutation(int k) {

		if (k == sel.length) {
			for (int i : sel) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n.length; i++) {
			sel[k] = n[i];
			permutation(k + 1);
		}
	}

}
