package edu.ssafy.chap04;

import java.util.Scanner;

public class N과M_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		combination(N, new int[M], 1, 0);
	}

	private static void combination(int n, int[] sel, int idx, int k) {
		
		if(k == sel.length) {
			for(int i : sel) {
				System.out.print(i + " ");
			}
			System.out.println();
			
			return;
		}
		
		for(int i = idx; i <= n; i++) {
			sel[k] = i;
			combination(n, sel, i+1, k+1);
		}
		
	}

}
