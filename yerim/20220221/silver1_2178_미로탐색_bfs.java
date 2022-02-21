package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class silver1_2178_미로탐색_bfs {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int N, M, result = Integer.MAX_VALUE;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int r = 0; r < map.length; r++) {
			String str = br.readLine();
			for (int c = 0; c < map[r].length; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}
		//dfs(0, 0, 1);
		bfs();
		System.out.println(result);
	}

	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0, 1));
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			if(p.r == N-1 && p.c == M-1) {
				result = Math.min(result, p.cnt);
				//System.out.println(result);
				return;
			}
			
			for (int d = 0; d < dc.length; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if(check(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
					visited[nr][nc] = true;
					queue.offer(new Point(nr, nc, p.cnt+1));
				}
			}
		}
		
	}

	static class Point{
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<M) return true;
		return false;
	}

}
