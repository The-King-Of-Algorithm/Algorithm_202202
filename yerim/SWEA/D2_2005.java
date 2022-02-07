package SWEA;

import java.util.Scanner;

public class D2_2005 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] num = new int[N][N];
			System.out.println("#" + tc);
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j <= i; j++) {
					if(i-1 < 0 && j-1 < 0) {
						num[i][j] = 1;
					} else if(j-1 < 0) {
						num[i][j] = num[i-1][j];
					} else if(j == i) {
						num[i][j] = num[i-1][j-1];
					} else {
						num[i][j] = num[i-1][j-1] + num[i-1][j];
					}
					System.out.print(num[i][j] + " ");
				}
				System.out.println();
			}
			
		}

	}

}
