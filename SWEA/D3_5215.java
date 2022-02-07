package SWEA;

import java.util.Scanner;

public class D3_5215 {
	
	static int N, L, result;
	static int[] T, K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Tc = sc.nextInt();
		
		for(int tc = 1; tc <= Tc; tc++) {
			N = sc.nextInt();  // 재료의 수
			L = sc.nextInt();  // 제한 칼로리
			T = new int[N];
			K = new int[N];
			result = 0;
			
			for(int i = 0; i < N; i++) {
				T[i] = sc.nextInt();
				K[i] = sc.nextInt();
			}
			
			combination(0, 0, 0);
			
			System.out.printf("#%d %d\n", tc, result);
		}

	}
	
	public static void combination(int idx, int sum_cal, int sum_score) {
		if(sum_cal > L) {
			return;
		}
		if(idx == N) {
			result = Math.max(result, sum_score);
			return ;
		}

		
		// 선택한 경우
		combination(idx+1, sum_cal+K[idx], sum_score+T[idx]);
				
		// 선택하지 않은 경우
		combination(idx+1, sum_cal, sum_score);
	}

}
