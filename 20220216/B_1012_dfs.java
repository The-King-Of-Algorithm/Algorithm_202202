package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1012_dfs {
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int N;
	static int M;
	static int[][] cell;
	static boolean[][] v;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader br = new BufferedReader(new FileReader("B_1012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			cell = new int[N][M];
			v = new boolean[N][M];
			ans = 1;
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				cell[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			for (int r = 0; r < cell.length; r++) {
				for (int c = 0; c < cell[r].length; c++) {
					if (cell[r][c] == 1 && v[r][c] == false) {
						ans++;
						dfs(r,c,ans);
					}
				}
			}
			//print(cell);
			System.out.println(ans-1);
		}

	}
	private static void dfs(int r, int c, int cnt) {
		cell[r][c] = cnt;
		
		for (int d = 0; d < dr.length; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if (nr>=0 && nr<N && nc>=0 && nc<M && cell[nr][nc] == 1 && v[nr][nc] == false) {
				v[nr][nc] = true;
				dfs(nr, nc, cnt);
				v[nr][nc] = false;
			}
		}
		
	}

	private static void print(int[][] cell) {
		for (int i = 0; i < cell.length; i++) {
			for (int j = 0; j < cell[i].length; j++) {
				System.out.print(cell[i][j]+" ");
			}System.out.println();
		}
		
	}

}
