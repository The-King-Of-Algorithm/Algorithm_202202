package edu.ssafy.chap05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bronze1_2839_설탕배달_완전탐색 {
	
	static int min = Integer.MAX_VALUE;
	static int[] input, sel;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		input = new int[]{3, 5};
		sel = new int[N/3+1];
		
		recursive(0, 0, N);
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	private static void recursive(int idx, int k, int N) {
		
		if(N == 0) {
			min = Math.min(min, k);
			return;
		}
		if(N < 0) {
			return;
		}
		
		for(int i = idx; i < 2; i++) {
			sel[k] = input[i];
			recursive(i, k+1, N - input[i]);
		}
		
	}

}
