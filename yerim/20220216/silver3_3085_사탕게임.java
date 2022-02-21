package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class silver3_3085_사탕게임 {
	
	static int N, result;
	static char[][] map, map_copy;
	static int[] dr = {0, 1};
	static int[] dc = {1, 0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		result = 1;
		
		// 입력받기
		for (int i = 0; i < map.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// 4방탐색
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {								
				for(int d = 0; d < 2; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					// 서로 다른 글자면 바꾸기
					if(nr>=0 && nr<N && nc>=0 && nc<N && map[i][j] != map[nr][nc]) {
						// 기존 배열 copy
						map_copy = new char[N][N];
						for (int k = 0; k < N; k++) {
							System.arraycopy(map[k], 0, map_copy[k], 0, map_copy[k].length);
						}
						
						// 자리 교환해주기
						char tmp = map_copy[i][j];
						map_copy[i][j] = map_copy[nr][nc];
						map_copy[nr][nc] = tmp;
						
						// 행 또는 열 최대길이찾기
						calMax();
					}
				}
			}
		}
		System.out.println(result);
	}

	// 최대 길이 찾기
	private static void calMax() {
		
		// 행 최대
		for(int r = 0; r < N; r++) {
			int cnt = 1;
			for (int c = 1; c < N; c++) {
				if(map_copy[r][c] == map_copy[r][c-1]) {
					cnt++;
				} else {
					cnt = 1;
				}
				result = Math.max(result, cnt);
			}
		}
		
		// 열 최대
		for(int r = 0; r < N; r++) {
			int cnt = 1;
			for (int c = 1; c < N; c++) {
				if(map_copy[c][r] == map_copy[c-1][r]) {
					cnt++;
				} else {
					cnt = 1;
				}
				result = Math.max(result, cnt);
			}
		}
	}
}
