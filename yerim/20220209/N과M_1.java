package edu.ssafy.chap04;

import java.util.Scanner;

public class N과M_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		permitation(N, new int[M], 0, new boolean[N]);
	}

	private static void permitation(int n, int[] sel, int k, boolean[] v) {

		if (k == sel.length) {
			for (int i : sel) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		
		for (int i = 0; i < n; i++) {
			if(v[i] == false) {
				v[i] = true;
				sel[k] = i+1;
				permitation(n, sel, k + 1, v);
				v[i] = false;
			}
		}
	}

}
