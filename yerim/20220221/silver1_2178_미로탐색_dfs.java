package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class silver1_2178_미로탐색_dfs {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int N, M, result = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int r = 0; r < map.length; r++) {
			String str = br.readLine();
			for (int c = 0; c < map[r].length; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}
		visited[0][0] = true;
		dfs(0, 0, 1);
		System.out.println(result);
	}

	private static void dfs(int r, int c, int cnt) {
		if(r == N-1 && c == M-1) {
			result = Math.min(result, cnt);
			//System.out.println(result);
			return;
		}
		
		for (int d = 0; d < dc.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(check(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
				visited[r][c] = true;
				dfs(nr, nc, cnt+1);
			}
		}
	}

	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<M) return true;
		return false;
	}

}
