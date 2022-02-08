package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class D3_6730 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] block = new int[N];
			int max_up = 0, max_down = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 입력
			for(int i = 0; i < N; i++) {
				block[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < N-1; i++) {
				// 내려오기
				if(block[i] >= block[i+1]) {
					max_down = Math.max(max_down, block[i] - block[i+1]);
				} 
				// 올라가기
				else {
					max_up = Math.max(max_up, block[i+1] - block[i]);
				}
			}
			
			System.out.printf("#%d %d %d\n", tc, max_up, max_down);
		}
		
	}

}
