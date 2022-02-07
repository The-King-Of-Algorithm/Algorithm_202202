package SWEA;

import java.util.Scanner;

public class D2_1959 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] A = new int[N];
			int[] B = new int[M];
			int result = 0;
			
			for(int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			for(int i = 0; i < M; i++) {
				B[i] = sc.nextInt();
			}
			
			if(N >= M) {
				result = multi(A, B);
			} else {
				result = multi(B, A);
			}
			
			System.out.printf("#%d %d\n", tc, result);
		}

	}

	private static int multi(int[] a, int[] b) {
		int[] sum = new int[a.length-b.length+1];
		int result = 0;
		
		for(int i = 0; i < a.length-b.length+1; i++) {
			for(int j = 0; j < b.length; j++) {
				sum[i] += b[j] * a[j+i];
			}
			result = Math.max(result, sum[i]);
		}
		
		return result;
	}
	
	

}
