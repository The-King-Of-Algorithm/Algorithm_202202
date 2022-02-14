package BAEKJOON;

import java.util.Scanner;

public class bronze1_2563_색종이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[100][100];
		int area = 0;
		
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int m = y; m < y+10; m++) {
				for (int n = x; n < x+10; n++) {
					map[n][m] = 1;
				}
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 1) {
					area++;
				}
			}
		}
		
		System.out.println(area);

	}

}
