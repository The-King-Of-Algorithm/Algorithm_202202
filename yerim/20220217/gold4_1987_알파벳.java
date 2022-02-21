package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gold4_1987_알파벳 {

	static int R, C, max=0;
	static char[][] map;
	static boolean[] alphabet;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		alphabet = new boolean[26];
		
		// map 입력
		for (int r = 0; r < map.length; r++) {
			String str = br.readLine();
			for (int c = 0; c < map[r].length; c++) {
				map[r][c] = str.charAt(c);
			}
		}		
		
		check(0, 0, 1);
		
		System.out.println(max);
		
	}

	private static void check(int r, int c, int cnt) {
		max = Math.max(max, cnt);
		
		alphabet[map[r][c]-'A'] = true;
		
		for(int i = 0; i < dr.length; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr>=0 && nr<R && nc>=0 && nc<C && !alphabet[map[nr][nc]-'A']) {
				check(nr, nc, cnt+1);
			}
		}
		alphabet[map[r][c]-'A'] = false;
	}
}
