package IM기출;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class sol42_미로도착지점 {

	// 상 우 하 좌
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Solution42.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 배열 크기
			int start_r = sc.nextInt(), start_c = sc.nextInt(); // 출발점 좌표
			int J = sc.nextInt(); // 점퍼의 개수
			int[][] map = new int[N+1][N+1];
			int end_r = start_r, end_c = start_c;
			
			// 점퍼 입력받아 점퍼 좌표에 9찍기
			for (int i = 0; i < J; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				map[r][c] = 9;
			}
			
			int C = sc.nextInt(); // 이동지시 개수
			boolean flag = false;
			// 이동지시 개수만큼 반복
			for (int c = 0; c < C; c++) {
				int dir = sc.nextInt()-1; // 방향
				int move = sc.nextInt(); // 이동칸수
				
				for (int m = 1; m <= move; m++) {
					int nr = end_r + dr[dir] * m;
					int nc = end_c + dc[dir] * m;
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 9) {
						end_r = 0;
						end_c = 0;
						flag = true;
						break;
					}
				}
				if(flag) break;
				else {
					end_r = end_r + dr[dir] * move;
					end_c = end_c + dc[dir] * move;
				}
				
			}
			
			System.out.printf("#%d %d %d\n", tc, end_r, end_c);
		}
	}

}
