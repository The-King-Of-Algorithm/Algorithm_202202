package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class silver2_5212_지구온난화 {
	// 상 하 좌 우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		int[][] map_cnt = new int[R][C]; // 바다 수 저장
		// 입력
		for(int r = 0; r < R; r++) {
			String str = br.readLine();
			for(int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				// X 나오면 탐색
				if(map[r][c] == 'X') {
					for(int k = 0; k < dr.length; k++) {
						int nr = r + dr[k];
						int nc = c + dc[k];
						// 범위밖은 바다니까 ++
						if(nr<0 || nr>=R || nc <0 || nc>=C) {
							map_cnt[r][c]++;
						} else {
							if(map[nr][nc] == '.') {
								map_cnt[r][c]++;
							}
						}
					}
				}
			}
		}
		int start_r = R, start_c = C, end_r = 0, end_c = 0;
		
		// 3 이상인거 바다로 바꿔주기
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				// 바다로 바꿔주기
				if(map_cnt[r][c] >= 3) {
					map[r][c] = '.';
				}
				// X 좌표 구하기
				if(map[r][c] == 'X') {
					start_r = Math.min(start_r, r);
					start_c = Math.min(start_c, c);
					end_r = Math.max(end_r, r);
					end_c = Math.max(end_c, c);
				}
			}
		}
		
		// 최소 직사각형 모양으로 출력
		for(int r = start_r; r <= end_r; r++) {
			for(int c = start_c; c <= end_c; c++) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}
	}

}
