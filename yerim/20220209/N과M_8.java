package edu.ssafy.chap04;

import java.util.Arrays;
import java.util.Scanner;

public class N과M_8 {
	
	static int N, M;
	static int[] n, sel;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		n = new int[N];
		sel = new int[M];
		
		for(int i = 0; i < N; i++) {
			n[i] = sc.nextInt();
		}
		
		Arrays.sort(n);
		
		combination(0, 0);
		System.out.println(sb);
	}

	private static void combination(int idx, int k) {
		
		if(k == sel.length) {
			for(int i : sel) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = idx; i < N; i++) {
			sel[k] = n[i];
			combination(i, k+1);
		}
		
	}
}
