package IM기출;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class sol13_빌딩 {

	static int[] r = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] c = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Solution13.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			String[][] map = new String[N][N];
			int max = 0;
			
			// 값 입력받기
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.next();
					//System.out.print(map[i][j] + " ");
				}
				//System.out.println();
			}
			
			for(int i = 0; i < map.length; i++) {
				for(int j = 0; j < map[i].length; j++) {
					if(map[i][j].equals("B")) {
						boolean flag = true;
						// 8방 탐색
						for(int k = 0; k < r.length; k++) {
							int dr = i + r[k];
							int dc = j + c[k];
							// 경계 확인
							if(dr>=0 && dr<N && dc>=0 && dc<N) {
								// 주변에 공원있으면?
								if(map[dr][dc].equals("G")) {
									max = Math.max(max, 2);
									flag = false;
									break;
								}
							}
						}
						// 8방 탐색했는데 공원이 없으면?
						if(flag) {
							int max_B = 0;
							for(int k = 0; k < N; k++) {
								// 가로 탐색
								if(map[i][k].equals("B")) {
									max_B++;
								}
								// 세로 탐색
								if(map[k][j].equals("B")) {
									max_B++;
								}
							}
							max_B--;
							max = Math.max(max_B, max);
						}
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}

	}

}
