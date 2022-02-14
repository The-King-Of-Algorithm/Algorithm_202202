package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bronze2_3040_백설공주와일곱난쟁이 {
	
	static int[] input, sel;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = new int[9];
		sel = new int[7];
		
		for(int i = 0; i < 9; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		comb(0, 0);

	}

	private static void comb(int idx, int k) {
		
		if(k == sel.length) {
			int sum = 0;
			for(int i : sel) {
				sum += i;
			}
			
			if(sum == 100) {
				for(int i : sel) {
					System.out.println(i);
				}
			}
			
			return;
		}
		
		for(int i = idx; i < 9; i++) {
			sel[k] = input[i];
			comb(i+1, k+1);
		}
	}

}
