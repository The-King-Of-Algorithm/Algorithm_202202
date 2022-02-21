package IM기출;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class sol21_소금쟁이중첩 {
	
	static int[] dr = {1, 0};
	static int[] dc = {0, 1};
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Solution21.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 연못의 크기
			int S = sc.nextInt(); // 소금쟁이 수
			int[][] map = new int[N][N];
			boolean flag = false;
			int result = 0;
			
			int[][] mo = new int[S][3];
			for (int s = 0; s < S; s++) {
				mo[s][0] = sc.nextInt();
				mo[s][1] = sc.nextInt();
				mo[s][2] = sc.nextInt();
			}
			
			// 소금쟁이 수만큼 반복
			for (int s = 0; s < S; s++) {
				int start_r = mo[s][0];
				int start_c = mo[s][1];
				int dir = mo[s][2]-1;
				// 점프 3번 반복
				for (int i = 3; i > 0 ; i--) {
					int nr = start_r + dr[dir] * i;
					int nc = start_c + dc[dir] * i;
					if(nr>=0 && nr<N && nc>=0 && nc<N) {
						if(map[nr][nc] == 0) {
							map[nr][nc]++;
							start_r = nr;
							start_c = nc;
						} else {
							flag = true;
							break;
						}
					} else {
						break;
					}
				}
				if(flag) {
					result = s+1;
					break;
				}
				
			}
			
			System.out.printf("#%d %d\n", tc, result);
			
		}
		
		
	}
}