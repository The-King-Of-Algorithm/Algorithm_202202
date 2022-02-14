package BAEKJOON;

import java.io.FileInputStream;
import java.util.Scanner;

public class silver2_16926_배열돌리기1 {
	// 우상좌하
	static int[] dr = {0, 1 ,0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int[][] map;
	static int N, M, R;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		map = new int[N][M];
		
		// 입력
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 돌려야하는 그룹 개수
		// 이 규칙에서 항상 시작점은 x, y 값이 같은 값에서 시작
		int cnt = Math.min(N,  M)/2; 
		
		// 회전
		for(int i = 0; i < R; i++) {
			rotate(cnt);
		}
		
		print(map);
	}
	
	private static void rotate(int cnt) {
		// 지도의 크기에 따라 min(n, m)/2 횟수만큼 반복
		for(int i = 0; i < cnt; i++) {
			// 이동방향변수
			int dir = 0;
			// 시작점
			int sr =  i;
			int sc = i;
			// 기준점에 있는 값을 저장해놓는다
			int tmp = map[sr][sc];
			// 방향을 4번 바꾸면 끝~~~!!
			while(dir < 4) {
				int nr = sr + dr[dir];
				int nc = sc + dc[dir];
				// 경계선 쳌
				if(nr>=i && nr<N-i && nc>=i && nc<M-i) {
					map[sr][sc] = map[nr][nc];
					sr = nr;
					sc = nc;
				}
				// 만약 경계선 밖으로 벗어나면 방향을 바꾼다
				else{
					dir++;
				}
			}
			map[i+1][i] = tmp;
			
		}
		
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}
	
	
}
