package edu.ssafy.chap04;

import java.util.Arrays;
import java.util.Scanner;

public class N과M_6 {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] num = new int[N];
		
		for(int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		
		Arrays.sort(num);

		combination(num, new int[M], 0, 0);
		System.out.println(sb);
	}

	private static void combination(int[] num, int[] sel, int idx, int k) {
		
		if(k == sel.length) {
			for (int i : sel) {
				sb.append(i + " ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i = idx; i < num.length; i++) {
			sel[k] = num[i];
			combination(num, sel, i+1 , k+1);
		}
		
	}

}
