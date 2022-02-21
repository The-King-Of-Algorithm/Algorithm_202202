package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class silver3_1051_숫자정사각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int max = 1;
		
		// 입력
		for (int i = 0; i < map.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for (int n = 1; n < map.length; n++) {
			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map[r].length; c++) {
					int nr = r + n;
					int nc = c + n;
					if(nr < N && nc < M && map[r][c] == map[nr][nc] && map[r][c] == map[r][nc] && map[r][c] == map[nr][c]) {
						max = (n+1)*(n+1);
					}
				}
			}
		}
		
		System.out.println(max);
	}
}
