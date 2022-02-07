package SWEA;

import java.util.Scanner;

public class D3_4615 {
	
	static int[] row = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] col = {-1, 0, 1, -1, 1, -1, 0, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 보드의 한 변의 길이
			int M = sc.nextInt(); // 플레이어가 돌을 놓는 횟수
			int[][] map = new int[N][N];
			// 흑 : 1, 백 : 2
			// 초기 설정
			map[N/2-1][N/2-1] = 2;
			map[N/2][N/2] = 2;
			map[N/2][N/2-1] = 1;
			map[N/2-1][N/2] = 1;
			
			for(int cnt = 0; cnt < M; cnt++) {
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				int color = sc.nextInt();
				
				map[a][b] = color; // 입력받은 돌 놓기
				
				// 8방 탐색
				for(int i = 0; i < row.length; i++) {
					int check = 0;
					
					for(int j = 1; j < map.length; j++) {
						int dr = a + row[i] * j;
						int dc = b + col[i] * j;
						// 경계 벗어나면
						if(dr<0 || dr>=N || dc<0 || dc>=N) {
							break;
						} 
						// 빈칸일때
						else if(map[dr][dc] == 0) {
							check = 0; break;
						} 
						// 다른 돌 있을 때
						else if(map[dr][dc] != color) {
							check++;
						} 
						// 같은 색 돌을 만나고, 자신 돌이 아닐때
						else if(map[dr][dc] == color && check != 0) {
							for(int k = 0; k <= check; k++) {
								map[dr][dc] = color;
							}
							check = 0;
							break;
						} else {
							break;
						}
					}
					
				}
			}
			
			int black = 0, white = 0;
			
			for(int i = 0; i < map.length; i++) {
				for(int j = 0; j < map[i].length; j++) {
					if(map[i][j] == 1) {
						black++;
					} else if (map[i][j] == 2) {
						white++;
					}
				}
			}
			
			System.out.printf("#%d %d %d", tc, black, white);
		}
	}

}
