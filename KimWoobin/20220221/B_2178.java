package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2178 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] cell;
	static int[][] v;
	static int N,M;
	static int min = 987987987;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("B_2178.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cell = new int[N][M];
		v = new int[N][M];
		
		
		for (int i = 0; i < cell.length; i++) {
			String s = br.readLine();
			for (int j = 0; j < cell[i].length; j++) {
				cell[i][j] = s.charAt(j)-'0';
			}
		}
		
		v[0][0] = 1;
		//dfs(0,0,1);
		bfs(0,0);
		//System.out.println(cnt);
		//print(cell);
		System.out.println(v[N-1][M-1]);
	}
	
	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {r,c});
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			for (int d = 0; d < dr.length; d++) {
				int nr = p[0]+dr[d];
				int nc = p[1]+dc[d];
				if (nr>=0 && nr<N && nc>=0 && nc<M && v[nr][nc]== 0 && cell[nr][nc] == 1) {
					q.offer(new int[] {nr,nc});
					v[nr][nc] = v[p[0]][p[1]]+1;
				}
				
			}
			//print(v);
			//System.out.println("==============");
		}
		
		
	}
	
	private static void print(int[][] cell) {
		for (int i = 0; i < cell.length; i++) {
			for (int j = 0; j < cell[i].length; j++) {
				System.out.print(cell[i][j]+" ");
			}System.out.println();
		}
	}
	
//	private static void dfs(int r, int c, int cnt) {
//		
//		if (r== N-1 && c == M-1) {
//			min = Math.min(min, cnt);
//			return;
//		}
//		
//		for (int d = 0; d < dr.length; d++) {
//			int nr = r+dr[d];
//			int nc = c+dc[d];
//			if (nr>=0 && nr<N && nc>=0 && nc<M && cell[nr][nc] != 0 && v[nr][nc] == false) {
//				v[nr][nc] = true;
//				dfs(nr, nc,cnt+1);
//				v[nr][nc] = false;
//			}
//		}
//	}
}
