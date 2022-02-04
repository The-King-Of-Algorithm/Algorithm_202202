package SWExpert;

import java.util.Scanner;

public class d2_2001 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int q = 1; q < t+1; q++) {
			int n = sc.nextInt();
			int[][] cell = new int[n][n];
			int m = sc.nextInt();
			int temp = 0;
			
			for (int i = 0; i < cell.length; i++) {
				for (int j = 0; j < cell.length; j++) {
					cell[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < cell.length-m+1; i++) {
				for (int j = 0; j < cell.length-m+1; j++) {
					int sum = 0;
					if(i+m <=n && j+m <=n) {
						for (int r = 0; r < m; r++) {
							for (int c = 0; c < m; c++) {
								sum += cell[i+r][j+c];
							}
						}
					}
					if (sum>temp) {
						temp = sum;
					}
				}
			}
			System.out.println("#"+q+" "+temp);
		}
	}

}
