package hw_20220217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1987 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		boolean[] visit = new boolean[26];

		for (int i = 0; i < map.length; i++) {
			String str = bf.readLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		visit[map[0][0] - 'A'] = true;
		dfs(map, visit, 0, 0, 1);
		System.out.println(max);
	}

	private static void dfs(int[][] map, boolean[] visit, int r, int c, int cnt) {

		for (int d = 0; d < dx.length; d++) {
			int nr = r + dx[d];
			int nc = c + dy[d];
			if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length) {
				if (!visit[map[nr][nc] - 'A']) {
					visit[map[nr][nc] - 'A'] = true;
					dfs(map, visit, nr, nc, cnt + 1);
					visit[map[nr][nc] - 'A'] = false;
				}
			}
		}

		max = Math.max(max, cnt);

	}
}
