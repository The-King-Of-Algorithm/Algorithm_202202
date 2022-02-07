package SWEA;

import java.util.Scanner;

public class D3_2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			int revenue = 0;
			
			// 배열에 가치 저장
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
					//System.out.println("#" + tc + " " + map[i][j]);
				}
			}
			
			// 위에
			for(int j = 0; j <= N/2; j++) {
				for(int k = N/2 - j; k <= N/2 + j; k++) {
					revenue += map[j][k];
				}
			}
			
			// 아래
			int a = 1;
			for(int j = N/2+1; j < N; j++) {
				for(int k = a; k <= N-1-a; k++) {
					revenue += map[j][k];
				}
				a++;
			}

			
			System.out.println("#" + tc + " " + revenue);
		}
	}

}
