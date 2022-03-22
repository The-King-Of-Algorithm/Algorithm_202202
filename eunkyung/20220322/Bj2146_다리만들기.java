package day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj2146_다리만들기 {
	static int[][] map;
	static boolean[][] v;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		v = new boolean[N][N];

		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 1;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] > 0 && !v[i][j]) {
					bfs(i, j, cnt++);
				}
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] > 0) {
					bfs2(i, j, map[i][j], 0);
				}
			}
		}

		print(map);
		System.out.println(min);
	}

	private static void bfs2(int r, int c, int k, int cnt) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] v = new boolean[N][N];
		v[r][c] = true;
		q.offer(new int[] { r, c });

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] current = q.poll();
				for (int d = 0; d < dx.length; d++) {
					int nr = current[0] + dx[d];
					int nc = current[1] + dy[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] != k) {
						if (map[nr][nc] == 0) {
							v[nr][nc] = true;
							q.offer(new int[] { nr, nc });
						} else {
							min = Math.min(min, cnt);
						}
					}
				}
			}
			++cnt;
		}
	}

	private static void bfs(int r, int c, int cnt) {
		Queue<int[]> q = new LinkedList<int[]>();
		v[r][c] = true;
		map[r][c] = cnt;
		q.offer(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] current = q.poll();
			for (int d = 0; d < dx.length; d++) {
				int nr = current[0] + dx[d];
				int nc = current[1] + dy[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] == 1) {
					v[nr][nc] = true;
					map[nr][nc] = cnt;
					q.offer(new int[] { nr, nc });
				}
			}
		}

	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
