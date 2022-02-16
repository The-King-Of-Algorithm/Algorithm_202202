package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1012_bfs {
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int N;
	static int M;
	static int[][] cell;
	static boolean[][] v;
	static int ans;
	
	static class Point{
		int r;
		int c;
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c +"]";
		}
		
		
	}

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
			ans = 0;
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				cell[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			for (int r = 0; r < cell.length; r++) {
				for (int c = 0; c < cell[r].length; c++) {
					if (cell[r][c] == 1 && v[r][c] == false) {
						bfs(r,c);
						ans++;
					}
				}
			}
			//print(cell);
			System.out.println(ans);
			
		}

		
	}

	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<Point>();
		
		q.offer(new Point(r,c));
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			v[p.r][p.c] = true;
			cell[p.r][p.c] = ans+1;
			for (int d = 0; d < dr.length; d++) {
				int nr = p.r+dr[d];
				int nc = p.c+dc[d];
				
				if (nr>=0 && nr<N && nc>=0 && nc<M && cell[nr][nc] ==1 && v[nr][nc] == false) {
					q.offer(new Point(nr,nc));
					v[nr][nc] = true;
				}
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
