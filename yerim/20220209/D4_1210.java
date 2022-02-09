package edu.ssafy.chap04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D4_1210 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Ladder1.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int tc = 1; tc <= T; tc++) {
			int t = sc.nextInt();
			int[][] map = new int[100][100];
			int x = 0, y = 0;
			// 입력
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 2) {
						y = i;
						x = j;
					}
				}
			}
			
			// 밑에서부터 탐색
			for(int i = y-1; i >= 0; i--) {
				// 좌
				if(x-1 >= 0 && map[i][x-1] == 1) {
					while(x-1 >= 0 && map[i][x-1] == 1) {
						x = x-1;
					}
					
				}					
				// 우
				else if(x+1 < 100 && map[i][x+1] == 1) {
					while(x+1 < 100 && map[i][x+1] == 1) {
						x = x+1;
					}
				}
			}
			
			System.out.printf("#%d %d\n", t, x);
		}

	}

}
