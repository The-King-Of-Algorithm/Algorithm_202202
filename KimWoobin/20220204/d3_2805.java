package SWExpert;

import java.util.Scanner;

public class d3_2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int m = 1; m < t+1; m++) {
			
		int n = sc.nextInt();
		int[][] cell = new int[n][n];
		int sum=0;
		
		for (int i = 0; i < n; i++) {
			String temp = sc.next();
			for (int j = 0; j < n; j++) {
				cell[i][j] =  temp.charAt(j)-'0';
			}
		}
		
		for (int i = 0; i < cell.length; i++) {
				int center = (n-1)/2;
					for (int k = 0; k < n-(Math.abs(center-i)*2); k++) {
						sum += cell[i][Math.abs(center-i)+k];
					}
		}
		
		System.out.println("#" + m + " " + sum);
		}
	}
}
