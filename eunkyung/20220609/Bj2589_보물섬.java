package day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj2589_보물섬 {
	static int N, M, max;
	static char[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] V;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = bf.readLine().toCharArray();
		}

		V = new boolean[N][M];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 'L' && !V[i][j]) {
					V[i][j] = true;
					bfs(i, j);
				}
			}
		}
		System.out.println(max);

	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] v = new boolean[N][M];
		v[r][c] = true;
		q.offer(new int[] { r, c, 0 });
		while (!q.isEmpty()) {
			int[] current = q.poll();
			for (int d = 0; d < dx.length; d++) {
				int nr = current[0] + dx[d];
				int nc = current[1] + dy[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] == 'L') {
					v[nr][nc] = true;
					q.offer(new int[] { nr, nc, current[2] + 1 });
				}
			}
			max = Math.max(max, current[2]);
		}
	}

	private static void print(char[][] map2) {
		for (int i = 0; i < map2.length; i++) {
			for (int j = 0; j < map2[i].length; j++) {
				System.out.print(map2[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
