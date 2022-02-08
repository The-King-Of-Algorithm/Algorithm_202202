package edu.ssafy.chap04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_9229 {
	static int N, M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int[] a = new int[N];
			int max = 0;
			
			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(st1.nextToken());
				// System.out.println(a[i]);
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {					
					int sum = a[i] + a[j];
					if(sum <= M) {
						max = Math.max(max, sum);
					}
				}
			}
			if(max == 0) max = -1;
			
			
			System.out.printf("#%d %d\n", tc, max);
		}
	}	
}
