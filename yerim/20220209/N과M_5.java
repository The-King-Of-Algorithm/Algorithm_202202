package edu.ssafy.chap04;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class N과M_5 {

	static int N, M;
	static int[] n, sel;
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		n = new int[N];
		sel = new int[M];
		v = new boolean[N];

		for (int i = 0; i < N; i++) {
			n[i] = sc.nextInt();
		}
		Arrays.sort(n);

		permutation(0);
		System.out.println(sb);
	}

	private static void permutation( int k) {

		if (k == sel.length) {
			for (int i : sel) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n.length; i++) {
			if(v[i] == false) {
				v[i] = true;
				sel[k] = n[i];
				permutation(k + 1);
				v[i] = false;
			}
			
		}
	}

}
