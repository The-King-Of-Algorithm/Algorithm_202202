package SWEA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D2_1974_스도쿠검증 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("스도쿠검증.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int[][] map = new int[9][9];
			boolean result = true;

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 가로
			for (int i = 0; i < map.length; i++) {
				int[] v = new int[9];
				for (int j = 0; j < map[i].length; j++) {
					if (v[map[i][j] - 1] == 0) {
						v[map[i][j] - 1] = 1;
					}					
				}
				for (int j = 0; j < 9; j++) {
					if(v[j] == 0) {
						result = false;
						break;
					}
				}
			}

			// 세로
			for (int i = 0; i < map.length; i++) {
				int[] v = new int[9];
				for (int j = 0; j < map[i].length; j++) {
					if (v[map[j][i] - 1] == 0) {
						v[map[j][i] - 1] = 1;
					}
				}
				for (int j = 0; j < 9; j++) {
					if(v[j] == 0) {
						result = false;
						break;
					}
				}
			}
			
			// 격자
			for(int i = 0; i <= 6; i=i+3) {
				for(int j = 0; j <= 6; j=j+3) {
					int[] v = new int[9];
					for (int m = 0; m < 3; m++) {						
						for (int n = 0; n < 3; n++) {
							if (v[map[m+i][n+j] - 1] == 0) {
								v[map[m+i][n+j] - 1] = 1;
							}
						}
					}
					for (int k = 0; k < 9; k++) {
						if(v[k] == 0) {
							result = false;
							break;
						}
					}
				}
			}
			
			if(result == true)
				System.out.printf("#%d %d\n", tc, 1);
			else
				System.out.printf("#%d %d\n", tc, 0);
		}

	}

}
