package hw_20220210;

import java.util.Scanner;
//색종이
public class Baek_2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[100][100];
		int M = map.length;
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int c = x - 1; c < x + 9; c++) {
				for (int r = y - 1; r < y + 9; r++) {
					if (map[r][c] == 0) {
						map[r][c] = 1;
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}	
}
