package SWExpert;

import java.util.Scanner;

public class d2_1954 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int[][] cell = new int[n][n];
			
			int r = 0;
			int c = -1;
			int dir = 1;
			int k = 1;
			
			for (int i = n; i > 0; i--) {
				for (int j = 0; j < n; j++) {
					c+=dir;
					cell[r][c] = k;
					k++;
				}n--;
				for (int j = 0; j < n; j++) {
					r+=dir;
					cell[r][c] = k;
					k++;
				}
				dir = dir*-1;
			}
			System.out.println("#" + tc);
			for (int i = 0; i < cell.length; i++) {
				for (int j = 0; j < cell.length; j++) {
					System.out.print(cell[i][j]+" ");
				}System.out.println();
			}
		}
	}
}
