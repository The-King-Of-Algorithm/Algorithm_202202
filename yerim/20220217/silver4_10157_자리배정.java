package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class silver4_10157_자리배정 {
	
	static int R, C, K, idx_r=0, idx_c=0;
	static int[][] map;
	static boolean[][] v;
	
	// 하 우 상 좌
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		v = new boolean[R][C];
		
		K = Integer.parseInt(br.readLine());
		
		
		recursive(0, 0, 1);
		
		for (int[] i : map) {
			System.out.println(Arrays.toString(i));
		}
		
		//System.out.printf("%d %d", idx_r, idx_c);
	}

	private static void recursive(int r, int c, int a) {
		
		if(a == K) {
			idx_r = R-r;
			idx_c = c+1;
			return;
		}
		
		map[r][c] = a;
		v[r][c] = true;
		
		for (int d = 0; d < dc.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr>=0 && nr<R && nc>=0 && nc<C && !v[nr][nc]) {
				recursive(nr, nc, a+1);
			}
		}
	}
}
