package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_9229_Combination {
	
	static int N, M;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int[] a = new int[N];
			max = 0;
			
			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(st1.nextToken());
			}
			
			combination(a, new int[2], 0, 0);
			System.out.printf("#%d %d\n", tc, max);
		}

	}

	private static void combination(int[] a, int[] sel, int idx, int k) {
		
		if(k == sel.length) {
			int sum = 0;
			for(int i : sel) {
				sum += i;
			}
			if(sum <= M) {
				max = Math.max(max, sum);
			}
			if(max == 0) {
				max = -1;
			}
			return;
		}
		
		for(int i = idx; i < a.length; i++) {
			sel[k] = a[i];
			combination(a, sel, i+1, k+1);
		}
	}

}
