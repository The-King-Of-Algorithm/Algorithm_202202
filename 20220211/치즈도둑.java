package problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈도둑 {
	static int n;
	static int arr[][];
	static int dr[] = {1,-1,0,0};
	static int dc[]= {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("치즈도둑.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(bf.readLine());
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max =0;
			for (int cnt = 1; cnt <= 100; cnt++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (arr[i][j] == cnt) {
							arr[i][j] = 0;
						}
					}
				}
				boolean visit[][] = new boolean[n][n];
				int count=0;
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (arr[i][j] != 0 && !visit[i][j]) {
							count++;
							bfs(i, j, visit);
						}
					}
				}
				max=Math.max(max, count);
			}
			System.out.println("#"+tc+" "+max);
		}
	}

	private static void bfs(int row, int col, boolean[][] visit) {
		Queue <int[]> queue = new LinkedList<>();
		visit[row][col]=true;
		queue.add(new int[]{row,col});
		while(!queue.isEmpty()) {
			int r =queue.peek()[0];
			int c =queue.peek()[1];
			queue.poll();
			for(int i =0; i<4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr>=0 && nr<n && nc>=0 && nc<n && !visit[nr][nc] && arr[nr][nc]!=0) {
					visit[nr][nc]=true;
					queue.add(new int[] {nr,nc});
				}
			}
		}
		
	}

	static void print(int[][] arr) {
		for (int tmp[] : arr) {
			for (int t : tmp) {
				System.out.print(t + " ");
			}
			System.out.println();
		}
	}
}
