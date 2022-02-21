package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gold2_3109_빵집 {

	static int R, C, cnt = 0;
	static char[][] map;
	static boolean[][] v;
	static boolean flag;
	static int[] dr = {-1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		v = new boolean[R][C];
		
		for (int r = 0; r < map.length; r++) {
			String str = br.readLine();
			for (int c = 0; c < map[r].length; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		for(int r = 0; r < map.length; r++) {
			flag = false;
			check(r, 0);
		}

		System.out.println(cnt);
	}

	private static void check(int r, int c) {
		
		if(c == C-1) {
			flag = true;
			cnt++;
			return;
		}
		
		for(int i = 0; i < dr.length; i++) {
			int nr = r + dr[i];
			if(nr>=0 && nr<R && c+1 < C && !v[nr][c+1] && map[nr][c+1] != 'x' && !flag) {
				v[nr][c+1] = true;
				check(nr, c+1);
			}
		}
		
	}

}
